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
	public void Addition() {
		RPN rpn = new RPN();
		assertEquals(0, rpn.calc("0 0 +"));
		assertEquals(1, rpn.calc("0 1 +"));
	}

	@Test
	public void Subtraction() {
		RPN rpn = new RPN();
		assertEquals(0, rpn.calc("0 0 -"));
		assertEquals(1, rpn.calc("1 0 -"));
		assertEquals(1, rpn.calc("2 1 -"));
	}

	@Test
	public void Multiplication() {
		RPN rpn = new RPN();
		assertEquals(0, rpn.calc("0 1 *"));
	}

	@Test
	public void Division() {
		RPN rpn = new RPN();
		assertEquals(2, rpn.calc("4 2 /"));
	}

	@Test
	public void Composite() {
		RPN rpn = new RPN();
		assertEquals(5, rpn.calc("1 2 2 + +"));
	}
}
