javac -classpath `yarn classpath` -d . "${1}Mapper.java"

javac -classpath `yarn classpath` -d . "${1}Reducer.java"

javac -classpath `yarn classpath`:. -d . "${1}.java"

jar -cvf "${1}.jar" *.class



hadoop jar "${1}.jar" $1 clean_ethnicity_output/clean_ethnicity  ${1}/output


