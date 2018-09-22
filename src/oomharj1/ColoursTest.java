package oomharj1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ColoursTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Colours.init();
	}

	@Test
	void test() {
		System.out.print("This should be true: ");
		System.out.println(Colours.getColours().get(0).equals(Colours.getColours().get(0)));
		System.out.print("This should be false: ");
		System.out.println(Colours.getColours().get(0).equals(Colours.getColours().get(1)));
	}

}
