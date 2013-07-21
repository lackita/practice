test: BingoTest.class
	java -classpath ".:/usr/share/java/junit4.jar" org.junit.runner.JUnitCore BingoTest

BingoTest.class: BingoTest.java Bingo.class
	javac -classpath ".:/usr/share/java/junit4.jar" BingoTest.java

Bingo.class: Bingo.java
	javac Bingo.java
