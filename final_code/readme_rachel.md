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
    - sh compile.sh CountAreas Languages 
    - sh compile.sh CountAreas Religions
    - sh compile.sh CountAreas Ethnicity
    - sh compile.sh CountLines Languages 
    - sh compile.sh CountLines Religions
    - sh compile.sh CountLines Ethnicity
  - output path in hdfs:
    - CountLines/Languages/output/part-r-00000
    - CountLines/Religions/output/part-r-00000
    - CountLines/Ethnicity/output/part-r-00000
    - CountAreas/Languages/output/part-r-00000
    - CountAreas/Religions/output/part-r-00000
    - CountAreas/Ethnicity/output/part-r-00000
- Analyse #1 with MR:
  - steps
    - cd /home/rmk461/project/final_code/ana_code/rachel
    - sh compile.sh Percent Languages 
    - sh compile.sh Percent Religions
    - sh compile.sh Percent Ethnicity 
  - output path in hdfs:
    - Percent/Languages/output/part-r-00000
    - Percent/Religions/output/part-r-00000
    - Percent/Ethnicity/output/part-r-00000
- Analyse #2 with Hive:
  - Executed several Hive statements to analyse dataset, included in final_code/screenshots/rachel/ana/hive