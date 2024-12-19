-- 코드를 작성해주세요
select HR_department.dept_id , HR_department.dept_name_en , round(avg(HR_Employees.sal),0) as avg_sal from HR_department join HR_Employees on HR_department.dept_id = HR_Employees.dept_id group by HR_Employees.dept_id order by avg_sal desc;
