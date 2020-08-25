/*
    Derek Trom
    Program 2
    derek.trom@und.edu
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class DerekTromProgram2 {

    public static String readFile(String inputCode, String fileName) throws IOException {
        /*
            param inputCode = empty string to add all tokens
            param fileName = filename from args
         */
        try {
            FileReader in = new FileReader(fileName);
            int i;
            while ((i=in.read()) != -1){
                inputCode = inputCode + (char)i ; //create string

            }

        }
        catch (IOException e){
            System.out.println("Error opening file");
            System.exit(0);
        }
        inputCode = inputCode +"\n";
        return inputCode;
    }

    public static void main (String[] args) throws IOException
    {
        /*
        match the different types of lexemes and find occurrences
         */
        PrintStream fileOut = new PrintStream("/Users/derektrom/Desktop/CSCI365/DerekTromProgram4/test5.txt");
        System.setOut(fileOut);
        List<String> regexes = new ArrayList<String>();
        regexes.add("(?<input>(\\binput\\b))|"); //input regex
        regexes.add("(?<if>(\\bif\\b))|"); //if regex
        regexes.add("(?<else>(\\belse\\b))|"); //else regex
        regexes.add("(?<begin>(\\bbegin\\b))|"); //begin regex
        regexes.add("(?<end>(\\bend\\b))|"); //end regex
        regexes.add("(?<print>(\\bprint\\b))|"); //print regex
        regexes.add("(?<comment>(#.*(?=[\n|\r])))|"); //comment regex
        regexes.add("(?<id>(\\b([a-zA-Z]([a-zA-Z0-9]*)?)\\b))|"); //id regex
        regexes.add("(?<number>(\\b(\\+|-)?\\d+(\\.\\d+)?\\b))|"); //number regex
        regexes.add("((?<rel>(>|<|<=|>=|==|!=)+))|"); //relation operators
        regexes.add("(?<assignment>(=))|"); //assignment regex
        regexes.add("(?<space>(\\s))");

        String inputCode = ""; //initialize input string
        String regex = ""; //create empty string for HUGE regex
        //create huge regex from all regex
        for(String s: regexes){
            regex += s ;
        }

        inputCode = readFile(inputCode, args[0]); //get input
        Pattern pattern = Pattern.compile(regex); //compile large regex
        Matcher  matcher = pattern.matcher(inputCode);//create matcher
        String lexeme = ""; //initialize lexeme var
        while (inputCode.length() > 0) { //while not empty
            int location = 0;
            matcher = pattern.matcher(inputCode);
            matcher.find();
            if (matcher.start() != 0){
                //System.out.println(matcher.start() +"  "+ matcher.end());
                System.out.println("<error>, "+ inputCode.substring(0, matcher.start() ));
                System.exit(0);
            }

            //find first instance of matcher from regex
            /*
            within all branches the lexeme is extracted and trimmed
            then the inputcode is trimmed and the type is printed out
            the loop starts over with the matcher finding on new input
             */
            //relation


            if (matcher.group("rel")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<rel>, " + lexeme );

            }

            //number
            else if (matcher.group("number")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<number>, "+ lexeme );
            }
            //assignment
            else if (matcher.group("assignment")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<assign>, " + lexeme );
            }
            //input
            else if (matcher.group("input")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<input>, " + lexeme );
            }
            //comment
            else if (matcher.group("comment")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                continue;
                //System.out.println("<comment>, " +">"+ lexeme + "<");
            }
            //if
            else if (matcher.group("if")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<if>, "+ lexeme );

            }
            //else
            else if (matcher.group("else")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<else>, " + lexeme );
            }
            //begin
            else if (matcher.group("begin")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<begin>, " + lexeme );
            }
            //end
            else if (matcher.group("end")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<end>, "+ lexeme );
            }
            //print
            else if (matcher.group("print")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<print>, " + lexeme );
            }
            //identifier
            else if (matcher.group("id")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);
                System.out.println("<id>, "+ lexeme );
            }
            else if (matcher.group("space")!= null){
                location = matcher.end();
                lexeme = inputCode.substring(matcher.start(), location);
                lexeme = lexeme.trim();
                inputCode = inputCode.substring(location);

            }


        }
    }
}
