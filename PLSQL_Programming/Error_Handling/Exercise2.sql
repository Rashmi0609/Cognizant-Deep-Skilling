SET SERVEROUTPUT ON;

-- SCENARIO 1

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_FromAccount IN NUMBER,
    p_ToAccount   IN NUMBER,
    p_Amount      IN NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;
    IF v_Balance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Balance');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccount;


    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccount;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Fund Transfer Successful.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: ' || SQLERRM);
END;
/

-- SCENARIO 2

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percentage / 100)
    WHERE EmployeeID = p_EmployeeID;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found');
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary Updated Successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- SCENARIO 3

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_Name       IN VARCHAR2,
    p_DOB        IN DATE,
    p_Balance    IN NUMBER
)
IS
BEGIN
    INSERT INTO Customers (
        CustomerID,
        Name,
        DOB,
        Balance,
        LastModified,
        IsVIP
    )
    VALUES (
        p_CustomerID,
        p_Name,
        p_DOB,
        p_Balance,
        SYSDATE,
        NULL
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer Added Successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/ 