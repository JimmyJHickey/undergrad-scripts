section_info <- read.csv(file = "section_schedule_data2.csv",header = TRUE, sep = ",", colClasses = "factor")


section_schedule = data.frame(section_id = numeric(3), day_of_the_week=character(1), start_time=character(3), end_time=character(3),stringsAsFactors=FALSE)


for(i in 1:nrow(section_info)){
  num_of_days <- section_info[i,8]
  string <- section_info[i,7]
  
    for(j in 1:num_of_days){
      sub <- substr(string, j,j)
      id <- section_info[i,1]
      start <- section_info[i,5]
      end <- section_info[i,6]
      
      newrow <- list(id,sub,start,end)
      section_schedule=rbind(section_schedule,newrow)
    }
  
  
}

section_schedule <- section_schedule[-c(1,2,3),]
write.csv(section_schedule, file="section_schedule_data.csv",row.names = FALSE, quote = FALSE)
