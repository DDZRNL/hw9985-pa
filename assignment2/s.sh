#! /bin/bash
javacc lexparse.jj
javac *.java
java SemanticCHecker > Output.txt


