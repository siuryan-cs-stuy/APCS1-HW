//class Pig
//a Pig Latin translator
//SKELETON

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           9
     ,--.-'-,--.
     \  /-~-\  /
    / )' a a `( \
   ( (  ,---.  ) )
    \ `(_o_o_)' /
     \   `-'   /
      | |---| |     
      [_]   [_]
      PROTIP: Make this class compilable first, 
      then develop and test one method at a time.
      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class Pig 
{
    //Q: How does this initialization make your life easier?
    private static final String VOWELS = "aeiou";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") --> true  
      hasA("cat", "p") --> false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	// account for case differences
	w = w.toLowerCase();
	letter = letter.toLowerCase();

        return (w.indexOf(letter) != -1);
    }


    /*====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
        return hasA(VOWELS, letter);
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") --> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	// loops through w, adds 1 to ctr for each vowel
	int ctr = 0;
	for (int i = 0; i < w.length(); i += 1) {
	    if (isAVowel( w.substring(i,i+1) )) {
		ctr += 1;
	    }
	}
	return ctr;
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") --> true
      hasAVowel("zzz") --> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
        return (countVowels(w) > 0);
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") --> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	// loops through w, appends each vowel to retStr
	String retStr = "";
	for (int i = 0; i < w.length(); i += 1) {
	    String chr = w.substring(i,i+1);
	    if (isAVowel(chr)) {
		retStr += chr;
	    }
	}
	return retStr;
    }


    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel( String w ) 
    {
	// returns the first letter of all the vowels in w, "" if no vowels
        String v =  allVowels(w);
	if (!v.equals("")) {
	    return v.substring(0,1);
	}
	return "";
    }


    /*=====================================
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
    public static boolean beginsWithVowel( String w ) 
    {
	if (!w.equals("")) {
	    return isAVowel(w.substring(0,1));
	}
	return false;
    }


    /*=====================================
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      =====================================*/
    public static String engToPig( String w ) 
    {
	// case 1: begins with vowel
        if (beginsWithVowel(w)) {
	    return w + "way";
	}
	
	// case 2: begins with consanant
	else {
	    int posVowel = w.indexOf(firstVowel(w)); // pos of first vowel
	    return w.substring(posVowel) + w.substring(0,posVowel) + "ay";
	}
    }


    public static void main( String[] args ) {

	System.out.println( engToPig("apple") ); // "appleway"
	System.out.println( engToPig("strong") ); // "ongstray"
	System.out.println( engToPig("java") ); // "avajay"
	
	/*
        System.out.println( hasA("cat", "a") ); // true
	System.out.println( hasA("cat", "b") ); // false
	System.out.println( hasA("cat", "A") ); // true
	System.out.println( isAVowel("a") ); // true
	System.out.println( isAVowel("b") ); // false
	System.out.println( countVowels("abcde") ); // 2
	System.out.println( countVowels("dbc") ); // 0
	System.out.println( countVowels("abcdeaeiou") ); // 7
	System.out.println( hasAVowel("abc") ); // true
	System.out.println( hasAVowel("dgfhj") ); // false
	System.out.println( allVowels("abcde") ); // "ae"
	System.out.println( allVowels("bnt") ); // ""
	System.out.println( firstVowel("abcde") ); // "a"
	System.out.println( firstVowel("bnt") ); // ""
	System.out.println( beginsWithVowel("abc") ); // true
	System.out.println( beginsWithVowel("") ); // false
	System.out.println( beginsWithVowel("cba") ); // false
	*/
	
    }//end main()

}//end class Pig


