import java.util.Arrays;

public class InstanceMethodReference {

	public static void main(String[] args) {
		PersonComparisonProvider comparisonProvider = new PersonComparisonProvider();
		Person one = new Person();
		one.setName("1");
		one.setAge(20);
		Person two = new Person();
		two.setName("2");
		two.setAge(10);
		Arrays.sort(new Person[] {one,two},comparisonProvider::compareByAge );
		Arrays.sort(new Person[] {one,two},comparisonProvider::compareByName );
	}

}

class PersonComparisonProvider {
	public int compareByName(Person one, Person two) {
		return one.getName().compareTo(two.getName());
	}
	public int compareByAge(Person one, Person two) {
		return one.getAge().compareTo(two.getAge());
	}
}

class Person {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
