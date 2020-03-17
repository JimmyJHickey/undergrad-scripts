# Delete everything to start fresh
delete from course
	where course_id='CS-001';
delete from section
	where course_id='CS-001';
delete from takes
	where course_id='CS-001';

# Part A. Creating a course.
insert into course (course_id,title,credits)
	values('CS-001','Weekly Seminar',0);

# Part B. Creating a section of the new course
insert into section(course_id,sec_id,semester,year)
	values('CS-001',1, 'Autumn', 2009);
    
# Part C. Enrolling every CS Student into this new section.
  insert into takes
	select ID, "CS-001" course_id, 1 sec_id, "Autumn" semester, 2009 year, "NA" grade
			from student
			where dept_name = "Comp. Sci.";
	
  
    
# Part D. Delete tuples from takes where student's ID
# matches a student with the name Chavez
delete from takes
	where course_ID='CS-001' and sec_id = '1' and ID in (select ID
					from student
					where name = 'Chavez');
                    
# Part E. Delete te course from the course relation
# but not from the section relation.
delete from course
	where course_id='CS-001';
    
# Part F. Delete tuples from the takes relation
# that have 'database' in the course name.
delete from takes
	where course_id in (select course_id
						from course
						where title like '%database%');
                        
#Display all students: ID, name, and number of classes
select student.ID, Name, count(takes.ID) as total_classes
	from student left outer join takes on student.ID=takes.ID group by ID;