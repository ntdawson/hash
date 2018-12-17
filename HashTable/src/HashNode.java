public class HashNode<K,V> {
	 K key;
	 V value;
	
	HashNode<K,V> next;
	
	public HashNode(K key, V value){
		this.key = key;
		this.value = value;
	}
	public HashNode() {
		
	}
	public void displayNode() {
		System.out.println(key + " means: " + value);
	}
}