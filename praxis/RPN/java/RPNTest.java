import static org.junit.Assert.*;
import org.junit.Test;

public class RPNTest {
	@Test
	public void SingleNumber() {
		RPN rpn = new RPN();
		assertEquals(0, rpn.calc("0"));
		assertEquals(1, rpn.calc("1"));
	}

	@Test
	public void Plus() {
		RPN rpn = new RPN();
		assertEquals(0, rpn.calc("0 0 +"));
		assertEquals(1, rpn.calc("0 1 +"));
	}
}
