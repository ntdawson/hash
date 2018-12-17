
public class Hash {
	public static void main(String[] args) {
		HashTable<String, String> table = new HashTable<>();
		table.add("testing", "1st testing");
		System.out.println("Testing: -13%64 = " + Integer.toString( -13%64));
		//debug
		System.out.println("Value of testing is " + table.get("testing"));
		System.out.println("hashcode of testing is: " + table.hashCode("testing"));
		System.out.println("table size is: " + table.size() + System.lineSeparator() + "adding 2nd testing to table");
		table.add("tasting", "value of testing2");
		System.out.println("Value of tasting is: " + table.get("tasting"));
		System.out.println("hashcode of tasting is: " + table.hashCode("tasting"));
		System.out.println("table size is: " + table.size());
		table.add("tosting", "value of tosting");
		//endDEBUG
		
		table.add("tasting", "value of tasting");
		table.add("testing", "value of testing3");
		table.add("Twice", "Not Once");
		table.add("Turtle", "Shelled lizard");
		table.add("Space", "Mountain");
		table.add("Gorilla", "Jungle turtle");
		table.add("Lion", "Fast Turtle");
		table.add("Word", "Definition");


		System.out.println("hashcode of testing is:" + table.hashCode("testing"));
		System.out.println("table size is:" + table.size());
		System.out.println(table.get("testing"));

		System.out.println("Value of testing is " + table.get("testing"));
		System.out.println("hashcode of testing is: " + table.hashCode("testing"));
		System.out.println("Value of testing is " + table.get("testing"));
		System.out.println("hashcode of testing is: " + table.hashCode("testing"));
		System.out.println("Value of testing is " + table.get("testing"));
		System.out.println("hashcode of testing is: " + table.hashCode("testing"));
		System.out.println("Value of testing is " + table.get("testing"));
		System.out.println("hashcode of testing is: " + table.hashCode("testing"));

	}
}