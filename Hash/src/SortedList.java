
public class SortedList {
	private Link first;               // ref to first list item
	// -------------------------------------------------------------
	   public void SortedList()          // constructor
	      { first = null; }
	// -------------------------------------------------------------
	   public void insert(Link theLink)  
	   
	   
	      {
	      String key = theLink.getKey();
	      Link previous = null;          // start at first
	      Link current = first;
	                                    
	      // find the position to insert
	      while(current != null && compare(key,current) < 0) 
	         {                          
	         previous = current;
	         current = current.next;     // go to next item
	         }
	      // if first is null, then insert theLink to the first
	      if(previous==null)             // if beginning of list,
	      first = theLink;            //    first --> new link
	      
	      else                           // not at beginning,
	         previous.next = current;    //    previous --> current
	      current.next = theLink;        // new link --> current.next
	    
	      
	      }  // end insert()
	// -------------------------------------------------------------
	   public void delete(String key)       // delete link
	      {                              // (assumes non-empty list)
	      Link previous = null;          // start at first
	      Link current = first;
	                                     // until end of list,
	      while( current != null && key != current.getKey() )
	         {                           
	         previous = current;
	         current = current.next;     // go to next link
	         }
	                                     // disconnect link
	      if(previous==null)             //   if beginning of list
	         first = first.next;         //      delete first link
	      else                           //   not at beginning
	         previous.next = current.next; //    delete current link
	      }  // end delete()
	// -------------------------------------------------------------
	   public Link find(String key)         // find link
	      {
	      Link current = first;          // start at first
	                                     // until end of list,
	      while(current != null && compare(key, current) <= 0)
	         {                           
	         if (current.getKey() == key) {
	        	 return current;          // found it
	         }
	    	  current = current.next;     // go to next item
	         }
	      return null;                   // did not find it
	      }  // end find()
	// -------------------------------------------------------------
	   public void displayList()
	      {
	      System.out.print("List (first-->last): ");
	      Link current = first;       // start at beginning of list
	      while(current != null)      // until end of list,
	         {
	         current.displayLink();   // print data
	         current = current.next;  // move to next link
	         }
	      System.out.println("");
	      }
	   
	   
	   
	   
	  public int compare (String key, Link current) {
		  String tempKey = key.toString();
			String currentKey = current.getKey();

			if (tempKey.length() != currentKey.length()) {
				fixString(tempKey, currentKey);

			}
			int result = tempKey.compareTo(currentKey);

			return result;
		   
		   
	   }
	   
	  public void fixString(String word1, String word2) {
			int min;
			String tempWord1 = word1.toString();
			String tempWord2 = word2.toString();
			if (tempWord1.length() < tempWord2.length()) {
				min = tempWord1.length();
				for (int i = min; i <= tempWord2.length() - tempWord1.length(); i++) {
					tempWord1 = tempWord1 + " ";
				}
			}

			if (tempWord2.length() < tempWord1.length()) {
				min = tempWord2.length();
				for (int i = min; i <= tempWord1.length() - tempWord2.length(); i++) {
					tempWord2 = tempWord2 + " ";
				}
			}

		}
	   
	   
	   }  // end class SortedList


