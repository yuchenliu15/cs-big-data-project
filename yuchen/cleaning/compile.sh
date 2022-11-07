javac -classpath `yarn classpath` -d . CleanMapper.java

javac -classpath `yarn classpath` -d . CleanReducer.java

javac -classpath `yarn classpath`:. -d . Clean.java 

jar -cvf clean.jar *.class



hadoop jar clean.jar Clean resale-flat-prices-based-on-approval-date-2000-feb-2012.csv  p7/cleaning/output



