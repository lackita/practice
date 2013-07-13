all: SequenceLength.class SequenceLengthTest.class

test: SequenceLengthTest.class
	java -classpath ".:/usr/share/java/junit4.jar" org.junit.runner.JUnitCore SequenceLengthTest

clean:
	rm *.class

SequenceLengthTest.class: SequenceLengthTest.java SequenceLength.class
	javac -classpath ".:/usr/share/java/junit4.jar" SequenceLengthTest.java

SequenceLength.class: SequenceLength.java
	javac SequenceLength.java
