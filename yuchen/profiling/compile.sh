javac -classpath `yarn classpath` -d . CountRecsMapper.java

javac -classpath `yarn classpath` -d . CountRecsReducer.java

javac -classpath `yarn classpath`:. -d . CountRecs.java

jar -cvf countRecs.jar *.class



hadoop jar countRecs.jar CountRecs p7/cleaning/output/part-r-00000  p7/profiling/after



