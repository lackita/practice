COMPILE = javac -Xlint
TEST_CLASSPATH = ".:/usr/share/java/junit4.jar"
TEST_COMPILE = ${COMPILE} -classpath ${TEST_CLASSPATH}
TEST_RUN = java -classpath ${TEST_CLASSPATH} org.junit.runner.JUnitCore

test: PrimeDigitReplacementTest.class PrimeTest.class MathSetTest.class
	${TEST_RUN} PrimeDigitReplacementTest PrimeTest MathSetTest

PrimeDigitReplacementTest.class: PrimeDigitReplacementTest.java PrimeDigitReplacement.class
	${TEST_COMPILE} PrimeDigitReplacementTest.java

PrimeDigitReplacement.class: PrimeDigitReplacement.java PrimeChecker.class MathSet.class
	${COMPILE} PrimeDigitReplacement.java

PrimeTest.class: PrimeTest.java PrimeChecker.class
	${TEST_COMPILE} PrimeTest.java

PrimeChecker.class: PrimeChecker.java
	${COMPILE} PrimeChecker.java

MathSetTest.class: MathSetTest.java MathSet.class
	${TEST_COMPILE} MathSetTest.java

MathSet.class: MathSet.java
	${COMPILE} MathSet.java
