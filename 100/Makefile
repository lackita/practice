all: SequenceLength.class FakeInputStream.class SequenceLengthTest.class

clean:
	rm *.class

SequenceLengthTest.class: SequenceLengthTest.java SequenceLength.class FakeInputStream.class
	javac -classpath /usr/share/java/junit4.jar SequenceLengthTest.java

SequenceLength.class: SequenceLength.java
	javac SequenceLength.java

FakeInputStream.class: FakeInputStream.java
	javac FakeInputStream.java
