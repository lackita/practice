package com.lackita.uva.threenplusone;

public class FakeInputStream {
	private String source;
	public FakeInputStream(String source) {
		this.source = source;
	}

	public String nextLine() {
		return source;
	}
}
