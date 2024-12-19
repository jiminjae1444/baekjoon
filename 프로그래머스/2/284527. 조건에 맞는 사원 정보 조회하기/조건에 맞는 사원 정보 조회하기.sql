-- 코드를 작성해주세요
SELECT 
    SUM(HR_GRADE.score) AS score, 
    HR_EMPLOYEES.emp_no, 
    HR_EMPLOYEES.emp_name, 
    HR_EMPLOYEES.position, 
    HR_EMPLOYEES.email
FROM 
    HR_EMPLOYEES
JOIN 
    HR_GRADE ON HR_GRADE.emp_no = HR_EMPLOYEES.emp_no
GROUP BY 
    HR_EMPLOYEES.emp_no, HR_EMPLOYEES.emp_name, HR_EMPLOYEES.position, HR_EMPLOYEES.email
HAVING 
    SUM(HR_GRADE.score) = (
        SELECT MAX(emp_score) 
        FROM (
            SELECT SUM(score) AS emp_score
            FROM HR_GRADE
            GROUP BY emp_no
        ) AS subquery
    );