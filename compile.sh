javac -classpath `yarn classpath` -d . "${1}Mapper.java"

javac -classpath `yarn classpath` -d . "${1}Reducer.java"

javac -classpath `yarn classpath`:. -d . "${1}.java"

jar -cvf "${1}.jar" *.class



hadoop jar "${1}.jar" $1 resale-flat-prices-based-on-approval-date-2000-feb-2012.csv  ${1}/output



