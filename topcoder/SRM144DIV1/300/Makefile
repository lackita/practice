test: BinaryCodeTest.class
	java -classpath ".:/usr/share/java/junit4.jar" org.junit.runner.JUnitCore BinaryCodeTest

clean:
	rm *.class

BinaryCodeTest.class: BinaryCodeTest.java BinaryCode.class
	javac -classpath ".:/usr/share/java/junit4.jar" BinaryCodeTest.java

BinaryCode.class: BinaryCode.java
	javac BinaryCode.java
