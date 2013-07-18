test: SieveTest.class
	java -classpath ".:/usr/share/java/junit4.jar" org.junit.runner.JUnitCore SieveTest

SieveTest.class: SieveTest.java Sieve.class
	javac -classpath ".:/usr/share/java/junit4.jar" SieveTest.java

Sieve.class: Sieve.java
	javac Sieve.java
