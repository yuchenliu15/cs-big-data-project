javac -classpath `yarn classpath` -d . CountRecsMapper.java

javac -classpath `yarn classpath` -d . CountRecsReducer.java

javac -classpath `yarn classpath`:. -d . CountRecs.java

jar -cvf countRecs.jar *.class



hadoop jar countRecs.jar CountRecs resale-flat-prices-based-on-approval-date-2000-feb-2012.csv  p7/profiling/after



