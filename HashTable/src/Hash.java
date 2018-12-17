
public class Hash {
	public static void main(String[] args) {
		HashTable<String, String> table = new HashTable<>();

		table.add("tasting", "value of tasting");
		table.add("testing", "value of testing3");
		table.add("Twice", "Not Once");
		table.add("Turtle", "Shelled lizard");
		table.add("Space", "Mountain");
		table.add("Gorilla", "Jungle turtle");
		table.add("Lion", "Fast Turtle");
		table.add("Word", "Definition");
		System.out.println("");
		table.displayList();
		System.out.println("Hold onto your boots!");
		for(int i =0;i<50;i++) {
			table.add("test"+i, "test"+i);
		}
		System.out.println("Let go of your boots" + System.lineSeparator());


		table.displayList();
	}
}