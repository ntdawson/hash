
public class HashTable {

	   private SortedList[] hashArray;   // array of lists
	   private int arraySize;
	// -------------------------------------------------------------
	   public HashTable(int size)        // constructor
	      {
	      arraySize = size;
	      hashArray = new SortedList[arraySize];  // create array
	      for(int j=0; j<arraySize; j++)          // fill array
	         hashArray[j] = new SortedList();     // with lists
	      }
	// -------------------------------------------------------------
	   public void displayTable()
	      {
	      for(int j=0; j<arraySize; j++) 
	         {
	         System.out.println(j + ". "); 
	         hashArray[j].displayList(); // display list
	         }
	      }
	// -------------------------------------------------------------
	   public int hashFunc(String key)      // hash function
	      {
		   int hashVal = 0;
		   for (int j=0; j<key.length();j++) {
			  int letter = key.charAt(j) - 96; // get char code
			  hashVal = (hashVal * 27 + letter) % arraySize; // ?
		   }
		   return hashVal;
	      }
	// -------------------------------------------------------------
	   public void insert(Link theLink)  // insert a link
	      {
	      String key = theLink.getKey();
	      int hashVal = hashFunc(key);   // hash the key
	      hashArray[hashVal].insert(theLink);; // insert at hashVal
	      }  // end insert()
	// -------------------------------------------------------------
	   public void delete(String key)       // delete a link
	      {
	      int hashVal = hashFunc(key);   // hash the key
	      hashArray[hashVal].delete(key); // delete link
	      }  // end delete()
	// -------------------------------------------------------------
	   public Link find(String key)         // find link
	      {
	      int hashVal = hashFunc(key);   // hash the key
	      Link theLink = hashArray[hashVal].find(key);  // get link
	      return theLink;                // return link
	      }
	// -------------------------------------------------------------
	   }  // end class HashTable
	
	  


