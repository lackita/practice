TEST_CLASSPATH = ".:/usr/share/java/junit4.jar"
TEST_COMPILE = javac -classpath ${TEST_CLASSPATH}
TEST_RUN = java -classpath ${TEST_CLASSPATH} org.junit.runner.JUnitCore

test: PrimeDigitReplacementTest.class PrimeTest.class
	${TEST_RUN} PrimeDigitReplacementTest PrimeTest

PrimeDigitReplacementTest.class: PrimeDigitReplacementTest.java PrimeDigitReplacement.class
	${TEST_COMPILE} PrimeDigitReplacementTest.java

PrimeDigitReplacement.class: PrimeDigitReplacement.java PrimeChecker.class
	javac PrimeDigitReplacement.java

PrimeTest.class: PrimeTest.java PrimeChecker.class
	${TEST_COMPILE} PrimeTest.java

PrimeChecker.class: PrimeChecker.java
	javac PrimeChecker.java
