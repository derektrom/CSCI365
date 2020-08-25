import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample
{
  public static void main (String[] args)
  {
     String letter = "[a-zA-Z]";
     String word = "[a-zA-Z_0-9]";
     String digit = "[0123456789]";
     String lotsOfLetters = "[a-zA-Z_]+";
     String lotsOfWords = "\\w+(\\s+\\w+)*";  // \\d - digit   \\w - word   \\s - whitespace
     
     String fullName = "firstlast";
     String fullName2 = "lastfirst";
     String fullName3 = "last first";
     
     System.out.println ("Does " + fullName + "contain a letter? " + fullName.matches(letter));
     System.out.println ("Does " + fullName + "contain a lots of letter? " + fullName.matches(lotsOfLetters));
     System.out.println ("Does " + fullName3 + "contain a lots of letter? " + fullName.matches(letter));
     
     String example = "if           x=12 average=total / number else average = 0;";
     Pattern idPattern = Pattern.compile("[a-zA-Z_]\\w*");
     Pattern numPattern = Pattern.compile("(\\+|-)?\\d+(\\.\\d+)?");
     
     Matcher matcher;
     String lexeme, token;
     
     matcher = numPattern.matcher (example);
     while (matcher.find())
     {
        System.out.println ("number starts at " + matcher.start() );
        System.out.println ("number ends at   " + matcher.end() );
        System.out.println ("number lexeme    " + matcher.group() );
     }
     
     matcher = idPattern.matcher (example);
     while (matcher.find())
     {
        System.out.println ("id starts at " + matcher.start() );
        System.out.println ("id ends at   " + matcher.end() );
        System.out.println ("id lexeme    " + matcher.group() );
     }
     System.out.println ();
     lexeme = example.substring (0, 2);
     System.out.println ("First lexeme " + lexeme);
     example = example.substring (2).trim();
     System.out.println ("And now I can work with: >" + example + "<");
        
  }
}