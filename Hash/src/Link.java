// hashChain.java
	// demonstrates hash table with separate chaining
	// to run this program: C:>java HashChainApp
	import java.io.*;
public class Link {
	
	////////////////////////////////////////////////////////////////
	                                   // (could be other items)
	   private String key; 
	   private String definition;      // string definition 
	   public Link next;                   // next link in list
	// -------------------------------------------------------------
	   public Link(String key, String definition)                 // constructor
	      { this.key = key;
	        this.definition = definition;
	      }
	// -------------------------------------------------------------
	   public String getKey()
	      { return key; }
	// -------------------------------------------------------------
	   public void displayLink()           // display this link
	      { System.out.print(key + ": " + definition); }
	   }  // end class Link


