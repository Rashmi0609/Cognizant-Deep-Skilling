SET SERVEROUTPUT ON;

-- SCENARIO 1

DECLARE

    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID,
               c.Name,
               t.TransactionID,
               t.TransactionDate,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a
            ON c.CustomerID = a.CustomerID
        JOIN Transactions t
            ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    v_Record GenerateMonthlyStatements%ROWTYPE;

BEGIN

    OPEN GenerateMonthlyStatements;

    LOOP
        FETCH GenerateMonthlyStatements INTO v_Record;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID: ' || v_Record.CustomerID ||
            ', Name: ' || v_Record.Name ||
            ', Transaction ID: ' || v_Record.TransactionID ||
            ', Amount: ' || v_Record.Amount ||
            ', Type: ' || v_Record.TransactionType ||
            ', Date: ' || TO_CHAR(v_Record.TransactionDate,'DD-MON-YYYY')
        );

    END LOOP;

    CLOSE GenerateMonthlyStatements;

END;
/


-- SCENARIO 2

DECLARE

    CURSOR ApplyAnnualFee IS
        SELECT AccountID
        FROM Accounts;

    v_Account ApplyAnnualFee%ROWTYPE;

    v_Fee NUMBER := 100;

BEGIN

    OPEN ApplyAnnualFee;

    LOOP

        FETCH ApplyAnnualFee INTO v_Account;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_Fee
        WHERE AccountID = v_Account.AccountID;

    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual maintenance fee applied successfully.');

END;
/


-- SCENARIO 3

DECLARE

    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID
        FROM Loans;

    v_Loan UpdateLoanInterestRates%ROWTYPE;

BEGIN

    OPEN UpdateLoanInterestRates;

    LOOP

        FETCH UpdateLoanInterestRates INTO v_Loan;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = v_Loan.LoanID;

    END LOOP;

    CLOSE UpdateLoanInterestRates;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated successfully.');

END;
/ 