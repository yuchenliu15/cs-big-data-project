# Instructions to use the scripts

## compile.sh (This compiles and runs map reduce jobs)
1) move compile.sh into same directory as java files
2) run `sh compile.sh <classname>`.
  * i.e. if I have `Clean.java`, `CleanMapper.java`, and `CleanReducer.java`, I would run `sh compile.sh Clean`.

## cat.sh (print output file)
1) after running compile.sh, run `sh cat.sh <classname>`
