import org.junit.Test;

import io.vavr.Tuple1;

public class VavrPractice {

	@Test
	public void testTuples() {
	Tuple1<String> oneTuple = new Tuple1<String>("kiran");
	System.out.println(oneTuple._1());
	}

}
