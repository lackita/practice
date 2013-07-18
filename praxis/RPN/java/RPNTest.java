import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RPNTest {
	private RPN rpn;
	@Before
	public void setUp() {
		rpn = new RPN();
	}

	@Test
	public void SingleNumber() {
		assertEquals(0, rpn.calc("0"), 0.1);
		assertEquals(1, rpn.calc("1"), 0.1);
	}

	@Test
	public void Addition() {
		assertEquals(0, rpn.calc("0 0 +"), 0.1);
		assertEquals(1, rpn.calc("0 1 +"), 0.1);
	}

	@Test
	public void Subtraction() {
		assertEquals(0, rpn.calc("0 0 -"), 0.1);
		assertEquals(1, rpn.calc("1 0 -"), 0.1);
		assertEquals(1, rpn.calc("2 1 -"), 0.1);
	}

	@Test
	public void Multiplication() {
		assertEquals(0, rpn.calc("0 1 *"), 0.1);
	}

	@Test
	public void Division() {
		assertEquals(2, rpn.calc("4 2 /"), 0.1);
	}

	@Test
	public void Composite() {
		assertEquals(5, rpn.calc("1 2 2 + +"), 0.1);
		assertEquals(85.2974, rpn.calc("19 2.14 + 4.5 2 4.3 / - *"), 0.0001);
	}
}
