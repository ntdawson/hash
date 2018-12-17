
import java.util.ArrayList;

public class HashTable<K, V> {
	ArrayList<HashNode<K, V>> bucketArray = new ArrayList<>();
	int numBuckets = 27; /*
							 * seems like the closer size is to numBuckets, the higher rate of collisions?
							 * It would be interesting to study how collision rate relates to array size, or
							 * likeness of data.
							 */
	int size;

	public HashTable() {
		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * Is there a way to accomplish this without casting? I can't say K extends
	 * String, how else can I say K has the .length() method?
	 */
	public int hashCode(K key) {
		int hashVal = 0;
		for (int j = 0; j < ((String) key).length(); j++) {
			int letter = ((String) key).charAt(j) - 96; // get char code

			/*
			 * Apparently Java's modulo operator takes the sign of the dividend. I was
			 * getting negative results from this hash function!
			 * 
			 * fixed it: (a % b + b) is necessarily positive and lower than b. If a is
			 * already positive, that statement is larger than b. So (a % b + b) % b = A
			 * necessarily positive value smaller than b
			 */
			hashVal = ((hashVal * 27 + letter) % numBuckets + numBuckets) % numBuckets;
		}
		return hashVal;
	}

	private int getBucketIndex(K key) {
		int hashCode = hashCode(key);
		return hashCode % numBuckets;
	}

	public V get(K key) {
		int index = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(index);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public V remove(K key) {

		int index = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(index);

		if (head == null)
			return null;

		if (head.key.equals(key)) {
			V val = head.value;
			head = head.next;
			bucketArray.set(index, head);
			size--;
			return val;
		} else {
			HashNode<K, V> prev = null;
			while (head != null) {
				if (head.key.equals(key)) {
					prev.next = head.next;
					size--;
					return head.value;
				}
				prev = head;
				head = head.next;
			}
			size--;
			return null;
		}

	}

	public void add(K key, V value) {

		int index = getBucketIndex(key);
		System.out.println("Adding " + key + " to: " + index);
		HashNode<K, V> head = bucketArray.get(index);
		HashNode<K, V> toAdd = new HashNode<>();
		toAdd.key = key;
		toAdd.value = value;
		if (head == null) {
			bucketArray.set(index, toAdd);
			size++;

		} else {
			while (head != null) {
				if (head.key.equals(key)) {
					head.value = value;
					size++;
					break;
				}
				head = head.next;
			}
			if (head == null) {
				head = bucketArray.get(index);
				toAdd.next = head;
				bucketArray.set(index, toAdd);
				size++;
			}
		}
		// resize the array if our load factor is 0.7 or greater
		if ((1.0 * size) / numBuckets > 0.7) {
			System.out.println("Increasing table size!" + System.lineSeparator());
			ArrayList<HashNode<K, V>> temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = numBuckets * 2;
			for (int i = 0; i < numBuckets; i++)
				bucketArray.add(null);

			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}

		}
	}

	public void displayList() {
		System.out.println("List (first-->last): ");
		HashNode<K, V> head = bucketArray.get(0);
		for (int i = 0; i < numBuckets; i++) {
			while (head != null) {
				head.displayNode();
				head = head.next;
			}
			head = bucketArray.get(i);
		}
		System.out.println("done!" + System.lineSeparator());

	}

}