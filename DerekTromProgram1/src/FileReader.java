import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.lang.System.*;

public class FileReader{
    public static void main(String[] args0) throws FileNotFoundException {
        String fileName = "RegExExample.java";
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new java.io.FileReader(fileName));
        } catch(FileNotFoundException e ){
            System.out.println("Could not find file" + e + "\n");
            System.exit(1);
            }
        }
    }


