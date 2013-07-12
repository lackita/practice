import java.io.InputStream;

public class SequenceLength {
	private InputStream systemIn;

	public SequenceLength() {
		this(System.in);
	}

	public SequenceLength(InputStream in) {
		systemIn = in;
	}
}
