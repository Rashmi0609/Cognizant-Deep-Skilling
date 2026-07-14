-- Enable DBMS Output
SET SERVEROUTPUT ON;

-------------------------------------------------------
-- Add IsVIP column (Run ONLY ONCE)
-------------------------------------------------------

ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);

-------------------------------------------------------
-- SCENARIO 1


BEGIN
    FOR customer_rec IN (
        SELECT CustomerID,
               FLOOR(MONTHS_BETWEEN(SYSDATE, DOB) / 12) AS Age
        FROM Customers
    )
    LOOP
        IF customer_rec.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                '1% discount applied to Customer ID: '
                || customer_rec.CustomerID
            );

        END IF;
    END LOOP;

    COMMIT;
END;
/

-- SCENARIO 2

BEGIN
    FOR customer_rec IN (
        SELECT CustomerID,
               Balance
        FROM Customers
    )
    LOOP
        IF customer_rec.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ID '
                || customer_rec.CustomerID
                || ' promoted to VIP.'
            );

        END IF;
    END LOOP;

    COMMIT;
END;
/

-- SCENARIO 3

BEGIN
    FOR loan_rec IN (
        SELECT c.CustomerID,
               c.Name,
               l.LoanID,
               l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND (SYSDATE + 30)
    )
    LOOP 

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID '
            || loan_rec.LoanID
            || ' for Customer '
            || loan_rec.Name
            || ' is due on '
            || TO_CHAR(loan_rec.EndDate,'DD-MON-YYYY')
        );

    END LOOP;
END;
/