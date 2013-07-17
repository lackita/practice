all: RPNTest.class RPN.class

test: RPNTest.class
	java -classpath ".:/usr/share/java/junit4.jar" org.junit.runner.JUnitCore RPNTest

clean:
	rm *.class

RPNTest.class: RPNTest.java RPN.class
	javac -classpath ".:/usr/share/java/junit4.jar" RPNTest.java

RPN.class: RPN.java
	javac RPN.java
