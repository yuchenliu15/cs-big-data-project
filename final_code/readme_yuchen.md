# Instructions for Yuchen's data set

## Directory structures
- Final project directory on Peel:
  - /home/yl6448/project/final_code

- Input file path on hdfs:
  - /user/yl6448/resale-flat-prices-based-on-approval-date-2000-feb-2012.csv

- Cleaning directory on peel: /home/yl6448/project/final_code/etl_code/yuchen
  - java and jar files: 
    - /home/yl6448/project/final_code/etl_code/yuchen/Clean.jar 
    - /home/yl6448/project/final_code/etl_code/yuchen/Clean.java
    - /home/yl6448/project/final_code/etl_code/yuchen/CleanMapper.java
    - /home/yl6448/project/final_code/etl_code/yuchen/CleanReducer.java
  - output on brightspace:
    - data_output/yuchen/cleaning_output


- Profiling directory peel: /home/yl6448/project/final_code/profiling_code/yuchen
  - java and jar files: 
    - /home/yl6448/project/final_code/profiling_code/yuchen/CountRecs.jar 
    - /home/yl6448/project/final_code/profiling_code/yuchen/CountRecs.java
    - /home/yl6448/project/final_code/profiling_code/yuchen/CountRecsMapper.java
    - /home/yl6448/project/final_code/profiling_code/yuchen/CountRecsReducer.java
  - output on brightspace:
    - data_output/yuchen/profiling_output



- First analyze directory peel: /home/yl6448/project/final_code/ana_code/yuchen
  - java and jar files: 
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze1/Ana.jar 
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze1/Ana.java
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze1/AnaMapper.java
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze1/AnaReducer.java
    - output on brightspace:
      - data_output/yuchen/analyze1_output



- Second analyze directory peel: /home/yl6448/project/final_code/ana_code/yuchen/analyze2
  - java and jar files: 
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze2/Aggregate.jar 
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze2/Aggregate.java
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze2/AggregateMapper.java
    - /home/yl6448/project/final_code/ana_code/yuchen/analyze2/AggregateReducer.java
  - output on brightspace:
    - data_output/yuchen/analyze2_output


- Third analyze:
  - hive tables:
    - yl6448/house_price
    - yl6448/ethnicity

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
    - Aggregate/output/part-r-00000
- Third analyze takes (Aggregate/output/part-r-00000) as input:
  - steps are commands in screenshots in /screenshots/yuchen/analyze3
    - move analyze2 data into table house_price in hive
      - load data inpath 'hdfs://horton.hpc.nyu.edu:8020/user/yl6448/Aggregate/output/part-r-00000' overwrite into table house_price;
    - move ethnicity into table in hive
      - load data inpath 'hdfs://horton.hpc.nyu.edu:8020/user/yl6448/clean_ethnicity' overwrite into table ethnicity;
    - join house_price and ethnicity on region
      - select * from ethnicity inner join house_price on ethnicity.region = house_price.region where ethnicity.year=2000;
    - output is in screenshots
  - goal: use house_price (countains housing price average of each region) to map to ethnicity (contains ethnicity percentage of each region). Therefore, we can analyze the ethnicity distribution based on housing price in each region.

