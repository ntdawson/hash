package hashing.hash;

public class Hash {
	public static void main(String[] args) {
		HashTable<String, String> table = new HashTable<>();
		table.add("testing", "2");
		table.add("testing", "3");
		System.out.println(table.remove("testing"));
		
	}
}