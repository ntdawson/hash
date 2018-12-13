package hashing.hash;

import java.util.ArrayList;

public class HashTable<K, V> {
	private ArrayList<HashNode<K, V>> bucketArray;
	private int numBuckets;
	private int size;

	public HashTable() {
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 1;
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
	 * Ugh casting. Is there a way to say 'K extends String', i.e: k has the
	 * .length() method? Java doesn't like final types being used as a bounded
	 * parameter
	 */
	public int hashCode(K key) {
		int hashVal = 0;
		for (int j = 0; j < ((String) key).length(); j++) {
			int letter = ((String) key).charAt(j) - 96; // get char code
			hashVal = (hashVal * 27 + letter) % size; // ?
		}
		return hashVal;
	}

	private int getBucketByKey(K key) {
		int hashCode = hashCode(key);
		int index = hashCode % numBuckets;
		return index;
	}

	public V get(K key) {
		int index = getBucketByKey(key);
		HashNode<K, V> head = bucketArray.get(index);
		while (head != null) {
			if (head.key.equals(key))
				return head.value;
			head = head.next;
		}
		return null;
	}

	public V remove(K key) {

		int index = getBucketByKey(key);
		HashNode<K, V> head = bucketArray.get(index);
		HashNode<K, V> prev = null;

		while (head != null) {
			if (head.key.equals(key))
				break;
			prev = head;
			head = head.next;
		}

		if (head == null)
			return null;

		size--;

		if (prev != null)
			prev.next = head.next;
		else
			bucketArray.set(index, head.next);

		return head.value;

	}

	public void add(K key, V value) {

		int index = getBucketByKey(key);
		System.out.println(index);
		HashNode<K, V> head = bucketArray.get(index);
		HashNode<K,V> toAdd = new HashNode<>();
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
		if ((1.0 * size) / numBuckets >= 0.7) {
			ArrayList<HashNode<K, V>> temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = numBuckets * 2;
			size = 0;
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
}
