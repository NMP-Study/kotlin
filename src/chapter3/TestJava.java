package chapter3;

import static chapter3.Chapter3_2Kt.*;

public class TestJava {
	public static void main(String[] args) {
		// `@JvmOverloads`
		taengtest();
		taengtest(1);
		taengtest(1, "A");
		taengtest(1, "A", true);

		// Top-level functions
		JoinKt.joinToString("hi");
	}
}
