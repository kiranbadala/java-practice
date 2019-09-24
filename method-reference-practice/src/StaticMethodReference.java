import java.util.function.Function;

public class StaticMethodReference {

	public static void main(String[] args) {
		// Without Lambda
		String one = funMethod(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return new StringBuilder(t).reverse().toString();
			}
		});
		System.out.println("One : " + one);
		// With lambda expression
		String two = funMethod((str) -> {
			return new StringBuilder(str).reverse().toString();
		});
		System.out.println("Two : " + two);
		// With method reference
		String three = funMethod(String::toUpperCase);
		System.out.println("Three : " + three);
	}

	public static String funMethod(Function<String, String> function) {
		return function.apply("Hi.");
	}
}
