import java.io.*;

public class ReadJavaFile
{
   public static void main (String[] args) throws Exception
   {
      String fileName = "RegExExample.java";
      BufferedReader inputStream = null;
      
      try {
         inputStream = new BufferedReader (new FileReader (fileName));
      }
      catch (Exception e)
      {
         System.out.println ("Error opening file");
         System.exit(0);
      }   
      String lineFromFile;
      try {
         lineFromFile = inputStream.readLine();
         while (lineFromFile != null) {
            System.out.println (lineFromFile);
            lineFromFile = inputStream.readLine();
         }
      }   
      catch (Exception e)
      {
         System.out.println ("Error reading file");
         System.out.println ("I have no idea how we would end up here.");
         System.exit(0);
      }   
      
   }
   
}
