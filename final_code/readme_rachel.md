# Instructions for Rachel's data set

## Directory structures
- Input file path on hdfs:
  - /user/rmk461/project/input/hdb_stats_final.csv


- Cleaning directory on peel: /home/rmk461/cs-big-data-project/final_code/etl_code/rachel
  - MR Job CleanEthnicity: Takes input file and creates a table of aggregate ethnicity statistics for each planning areas and year combination 
  - MR Job CleanLanguages: Takes input file and creates a table of aggregate language statistics for each planning areas and year combination 
  - MR Job CleanReligions: Takes input file and creates a table of aggregate religion statistics for each planning areas and year combination 

- Profiling directory peel: /home/rmk461/cs-big-data-project/final_code/profiling_code/rachel
  - MR Job CountAreas: Count number of records for each planning area
  - MR Job CountLines: Count number of lines in files


- Analyse directory peel: /home/rmk461/cs-big-data-project/final_code/ana_code/rachel
  - MR Job Percent: Converts aggregate statistics into percentages or proportions. Ex: 100 Chinese, 200 Indians, 300 Malays ->   0.25 Chinese, 0.5 Indians, 0.75 Malays

## Steps to run jobs
- Cleaning:
  - steps
    - cd /home/rmk461/project/final_code/etl_code/rachel
    - sh compile.sh CleanEthnicity 
    - sh compile.sh CleanLanguages
    - sh compile.sh CleanReligions 
  - output path in hdfs:
    - CleanEthnicity/output/part-r-00000
    - CleanLanguages/output/part-r-00000
    - CleanReligions/output/part-r-00000
- Profiling:
  - steps
    - cd /home/rmk461/project/final_code/profiling_code/rachel
    - sh compile.sh CountAreas
    - sh compile.sh CountLines
  - output path in hdfs:
    - CountLines/output/part-r-00000
    - CountAreas/output/part-r-00000
- Analyse
  - steps
    - cd /home/rmk461/project/final_code/ana_code/rachel
    - sh compile.sh Percent 
  - output path in hdfs:
    - Percent/output/part-r-00000
- NOTE:
  - For Profiling and Analyse code, if we want to run jobs on other cleaned datasets, compile.sh must be modified. Input file can be: 
    - project/cleanOutputEthnicity/part-r-00000
    - project/cleanOutputLanguages/part-r-00000
    - project/cleanOutputReligions/part-r-00000