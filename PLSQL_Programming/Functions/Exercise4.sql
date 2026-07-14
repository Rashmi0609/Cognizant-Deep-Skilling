SET SERVEROUTPUT ON;

-- SCENARIO 1

CREATE OR REPLACE FUNCTION CalculateAge (
    p_DOB IN DATE
)
RETURN NUMBER
IS
    v_Age NUMBER;
BEGIN
    v_Age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
    RETURN v_Age;
END;
/

-- SCENARIO 2

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYears IN NUMBER
)
RETURN NUMBER
IS
    v_MonthlyInstallment NUMBER;
BEGIN
    v_MonthlyInstallment :=
        (p_LoanAmount + (p_LoanAmount * p_InterestRate * p_DurationYears / 100))
        / (p_DurationYears * 12);

    RETURN v_MonthlyInstallment;
END;
/

-- SCENARIO 3

CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_AccountID IN NUMBER,
    p_Amount IN NUMBER
)
RETURN BOOLEAN
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;

    WHEN OTHERS THEN
        RETURN FALSE;
END;
/