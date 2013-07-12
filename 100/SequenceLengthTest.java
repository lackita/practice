package com.lackita.uva.threenplusone;
//import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;

@RunWith(JUnit4.class) public class SequenceLengthTest {
	@Test public void BaseCase() {
		SequenceLength sl = SequenceLength(FakeInputStream("1 1"));
	}
}
