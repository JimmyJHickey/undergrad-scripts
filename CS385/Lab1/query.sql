alter table timeslot add num_sec smallint;
alter table timeslot drop num_sec;
use lab1;
select *
from timeslot;