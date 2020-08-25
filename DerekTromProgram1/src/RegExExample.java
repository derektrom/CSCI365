import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegExExample {
    public static void main(String[] args) {
        String letter = "[a-zA-Z]";
        String word = "[a-zA-Z_0-9]";
        String digit = "[0123456789]";
        String lotsOfLetters = "[a-zA-Z_]";
        String lotsOfWords = "\\w+(\\s+\\w+)*";

        String fullName  = "first last";
        String fullName2 = "lastfirst";
        String fullName3 = "last first";

        System.out.println("Does " + fullName + "contain a letter? " + fullName.matches(letter));
        System.out.println("Does " + fullName + "contain lots of letter? " + fullName.matches(lotsOfLetters));
        System.out.println("Does " + fullName3 + "contain a lot of letter? " + fullName.matches(letter));

        String example = "If x = 12 average = total / number else average = 0 ";
        Pattern idPattern = Pattern.compile("[a-zA-Z_]\\w*");
        Pattern numPattern = Pattern.compile("(\\+|-)?\\d?(\\.\\d+)?");
        Matcher matcher;
        matcher = idPattern.matcher(example);
        while(matcher.find()){
            System.out.println("number starts at " + matcher.start());
            System.out.println("");
        }


    }
}
