# Instructions for Yuchen's data set

## Directory structures
- Input file path on hdfs:
  - /user/yl6448/resale-flat-prices-based-on-approval-date-2000-feb-2012.csv


- Cleaning directory on peel: /home/yl6448/project/final_code/etl_code/yuchen
  - java and jar files: 
    - /home/yl6448/project/final_code/etl_code/yuchen/Clean.jar 
    - /home/yl6448/project/final_code/etl_code/yuchen/Clean.java
    - /home/yl6448/project/final_code/etl_code/yuchen/CleanMapper.java
    - /home/yl6448/project/final_code/etl_code/yuchen/CleanReducer.java


- Profiling directory peel: /home/yl6448/project/final_code/profiling_code/yuchen
  - java and jar files: 
    - /home/yl6448/project/final_code/profiling_code/yuchen/CountRecs.jar 
    - /home/yl6448/project/final_code/profiling_code/yuchen/CountRecs.java
    - /home/yl6448/project/final_code/profiling_code/yuchen/CountRecsMapper.java
    - /home/yl6448/project/final_code/profiling_code/yuchen/CountRecsReducer.java


- First analyze directory peel: /home/yl6448/project/final_code/ana_code/yuchen
  - java and jar files: 
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze1/Ana.jar 
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze1/Ana.java
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze1/AnaMapper.java
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze1/AnaReducer.java


- Second analyze directory peel: /home/yl6448/project/final_code/ana_code/yuchen/analyze2
  - java and jar files: 
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze2/Group.jar 
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze2/Group.java
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze2/GroupMapper.java
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze2/GroupReducer.java


## Steps to run jobs
- Cleaning:
  - steps
    - cd /home/yl6448/project/final_code/etl_code/yuchen
    - sh compile.sh Clean
  - output path in hdfs:
    - Clean/output/part-r-00000
- Profiling (Clean/output/part-r-00000) as input:
  - steps
    - cd /home/yl6448/project/final_code/profiling_code/yuchen
    - sh compile.sh CountRecs
  - output path in hdfs:
    - CountRecs/output/part-r-00000
- First analyze takes (Clean/output/part-r-00000) as input:
  - steps
    - cd /home/yl6448/project/final_code/ana_code/yuchen/analyze1
    - sh compile.sh Ana 
  - output path in hdfs:
    - Ana/output/part-r-00000
- Second analyze takes (Ana/output/part-r-00000) as input:
  - steps
    - cd /home/yl6448/project/final_code/ana_code/yuchen/analyze2
    - sh compile.sh Group
  - output path in hdfs:
    - Group/output/part-r-00000
