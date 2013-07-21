test: SudokuTest.class
	java -classpath ".:/usr/share/java/junit4.jar" org.junit.runner.JUnitCore SudokuTest

SudokuTest.class: SudokuTest.java Sudoku.class
	javac -classpath ".:/usr/share/java/junit4.jar" SudokuTest.java

Sudoku.class: Sudoku.java
	javac Sudoku.java
