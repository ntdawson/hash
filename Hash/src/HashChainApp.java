import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashChainApp {

	
		   public static void main(String[] args) throws IOException
		      {
		      int key;
		      Link aDataItem;
		      int size, n, keysPerCell = 100;
		                                     // get sizes
		      System.out.print("Enter size of hash table: ");
		      size = getInt();
		     
		      readTestData("hello");
		   
		   
		      }  // end main()
		   
		   
		   
		   
		   
		   
		   static void readTestData(String theTable) {
			 //open a file
			   BufferedReader reader;
			
		        try {
		            File theFile = new File("c:/testfile/testfile.txt");
		            FileReader fileReader = new FileReader(theFile);

		            reader = new BufferedReader(fileReader);
		            String line = reader.readLine();
		            while (line != null) {
		                System.out.println(line);
		                // read next line
		                line = reader.readLine();
		            }
		            reader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		
			   // read two lines from the file
			   
			   // create a link object
			   
			   // put data into object
			   
			   // until the file is null
			   
			   
			   
			   
			   
		   
		   
		   
		   
		   
		//--------------------------------------------------------------
		   public static String getString() throws IOException
		      {
		      InputStreamReader isr = new InputStreamReader(System.in);
		      BufferedReader br = new BufferedReader(isr);
		      String s = br.readLine();
		      return s;
		      }
		//-------------------------------------------------------------
		   public static char getChar() throws IOException
		      {
		      String s = getString();
		      return s.charAt(0);
		      }
		//-------------------------------------------------------------
		   public static int getInt() throws IOException
		      {
		      String s = getString();
		      return Integer.parseInt(s);
		      }
		//--------------------------------------------------------------
		    // end class HashChainApp

	}


