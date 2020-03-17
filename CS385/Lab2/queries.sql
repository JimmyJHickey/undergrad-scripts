#select name, salary/12 as monthly_salary from instructor;
select * from instructor;

#Find all instructors in Computer Science with salary > 80,000
select name from instructor where dept_name='Comp. Sci.' and salary > 80000;

#course x intructor
select * from course, instructor;

#For all instructors who have taught a class, find their names and course ID of the course they taught
select name,course_id from teaches, instructor where instructor.ID=teaches.ID;

#Mathes tuples with the same values for all common attributes and retains only one copy of each common column
select * 
from instructor natural join teaches;

#natural join on an attribute
select name, title from instructor natural join teaches, course where teaches.course_id=course.course_id;

#Using renaming to make subsets
select distinct T.name from instructor as T, instructor as S where T.salary > S.salary and S.dept_name = 'Comp. Sci.';

#Sort by name
select distinct name from instructor order by dept_name, name;

#Find courses that ran in Fall 2009 or in Spring 2010
select course_id from section where (year = '2009' and semester = 'Fall') or (year = '2010' and semester = 'Spring');


#Using Aggregate functions
#Average
select avg (salary) from instructor where dept_name='History';

#Count
select count(distinct ID) from teaches where semester = 'Spring' and year = '2010';

#Grouping then averaging
select dept_name, avg(salary) from instructor group by dept_name;

#Having Clause
select dept_name, avg(salary) from instructor group by dept_name having avg(salary) > 42000;

#Everything so far! So pretty!
#Order is: from, where, group by, avg(salary), having, select
select dept_name, avg(salary) from instructor where dept_name like '%c%' group by dept_name having avg(salary) > 42000;

#Subqueries
select distinct course_id from section where semester = 'Fall' and year = 2009 and course_id not in
	(select course_id from section where semester = 'Spring' and year = 2010);	
    
select count(distinct takes.ID) from takes, teaches where teaches.ID=10101;

#Some commnad is not supported. so this will give the wrong output
#It works as the existential quantifier
select name from instructor where salary > some 
	(select salary from instructor where dept_name = 'Biology');
    
#All is the universal quantifier
select name from instructor where salary > all 
	(select salary from instructor where dept_name = 'Biology');
    
#Find the average instrucot's salary for departments with avg_salary > 42000
select dept_name, avg_salary
from (select dept_name, avg(salary) as avg_salary
	from instructor
    group by dept_name) as temp
where avg_salary > 42000;
    
# with Clause is not avaiable
# with max_budget (value) as
#	 (select max(budget)
#	 from department)
# select budget 
# from department, max_budget
# where department.budget = max_budget.value;

# Work around for the missing with clause
select budget
from department, (select max(budget) as max_v
					from department) as max_value
where department.budget = max_value.max_v;

# Broken
# Replacing with clause again
select dept_name
from (select dept_name, sum(salary) as dept_total_salary
    from instructor
    group by dept_name) as department_salaries,
    (select avg(dept_total_salary) as avg_total_salary
     from department_salaries) as average_dept_salary
where department_salaries.dept_total_salary >= average_dept_salary.avg_total_salary;

# Case  and Update Statements
update instructor
set salary = case
	when salary <= 100000 then salary*1.05
    else salary*1.03
    end;

###########################################################################################################################################################################
# Joins
###########################################################################################################################################################################

# Using Natural Join
select *
from course natural join prereq;

# Using Left outer join
select *
from course natural left outer join prereq;

# Using full outer join (there is no full outer join in mySQL)
#select *
#from course natural full outer join prereq;

# Using inner join on different attributes
select * 
from course inner join prereq on
	 course.course_id = prereq.course_id;
     
select *
from course inner join prereq on
course.course_id=prereq.prereq_id;
  
# Using left outer join on different attributes
select *
from course left outer join prereq on
course.course_id=prereq.prereq_id;

# Using the using condition
select *
from course right outer join prereq using (course_id);

###########################################################################################################################################################################
# Views
###########################################################################################################################################################################

# Create a view
create view faculty as 
	select ID, name, dept_name
    from instructor;
    
# Select from that view
select name
from faculty
where dept_name = 'Biology';

# Create another view
create view depts_total_salary(dept_name, total_salary) as
	select dept_name, sum(salary)
    from instructor
    group by dept_name;
 
 # Select from that view
select *
from depts_total_salary;

###########################################################################################################################################################################
#	Chapter 6
###########################################################################################################################################################################

# Work around for missing set difference operator
# R - S using Not Exists
# Slide 6.8
Select R.course_id
From section as R
Where R.semester="Fall" AND R.year=2009 AND Not Exists
	(Select S.course_id
	From section as S
    Where S.semester="Spring" and S.year=2010 AND R.course_id=S.course_id);
   
# Using exists to work around missing intersect operator
Select R.course_id
From section as R
Where R.semester="Fall" AND R.year=2009 AND Exists
	(Select S.course_id
	From section as S
    Where S.semester="Spring" and S.year=2010 AND R.course_id=S.course_id);