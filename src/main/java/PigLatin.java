import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
       String[] words = {"a","e","i","o","u"};
int count = -1;
 for(int i = 0; i < sWord.length(); i++){
   if(sWord.substring(i,i+1).equals(words[0]) || sWord.substring(i,i+1).equals(words[1]) || sWord.substring(i,i+1).equals(words[2]) || sWord.substring(i,i+1).equals(words[3]) || sWord.substring(i,i+1).equals(words[4])){
     count = i;
     break;
   }
 }
        return count;
    
    }

    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
        // more code should go here
	    if(findFirstVowel(sWord) == -1)
  {
    return sWord + "ay";
  }
  else if(findFirstVowel(sWord) == 0)
  {
    return sWord + "way";
  }
  else if(findFirstVowel(sWord) == 1 && sWord.substring(0,1).equals("q"))
  {
    return sWord.substring(2,sWord.length()) + "quay";
  }
  else if(findFirstVowel(sWord) >= 1)
  {
    return sWord.substring(findFirstVowel(sWord), sWord.length()) + sWord.substring(0,findFirstVowel(sWord)) + "ay";
  }
  else
  {
    return "error";
  }
    }
}//end PigLatin class
