package int103;

import java.io.*;
import java.net.*;
import java.util.*;

public class Int103Scanner {

   public static void main(String[] args) {
      System.out.println("#### demo Scanner + read URL + read password ####");
      demo000ScannerMethods();
      demo101ScannerFromString();
      demo102ScannerFromFile();
      demo201ScannerSystemIn();
      demo301URLReader();
      demo401ConsoleReadPassword();
      System.out.println("Hello");
   } 
   public static void demo000ScannerMethods() {
      System.out.println("""
      java.util.Scanner
         constructor(System.in); // read from standard input (keyboard)
         constructor(InputStream); // System.in is an InputStream
         constructor(File file); // read from the content in the file 
         constructor(new File(String filename)); // same as the above
         constructor(String text); // read from the text

         .useDelimiter(String pattern); 
         // pattern used to split input into tokens 

         .reset() // reset delimiter to default (consecutive whitespaces)
         .close() // close the scanner to release resource
                         
         .hasNextTYPE() -> boolean
         // e.g., .hasNextBoolean() [matching a token of type boolean] 
         // e.g., .hasNext() [matching a token of type String]
         // e.g., .hasNext(String pattern) [matching a token that matches pattern]
         // NOT apply to .hasNextLine()
         // returns true if the token matches the type
         // returns false if the token does not match the type 
         //                  or the end of input (end of file/string) 
         // waits (blocked) if there is no token 
         //       (on System.in or the input that has not been closed)
        
         .nextTYPE() -> TYPE // returns the value of that TYPE 
                             // and advances to next token
         // e.g., .nextBoolean() -> boolean 
         // e.g., .next() -> String
         // e.g., .next(String pattern) -> String
         // NOT apply to .nextLine()
         // returns the value of that TYPE if the token matches the type.
         // throws an exception if the token does not match the type 
         //                        or the end of input (end of file/string). 
         // waits (blocked) if there is no token 
         //       (on System.in or the input that has not been closed).
         
         // use .hasNext???() before .next??? to avoid exceptions on .next???()
         // .hasNext??? : does not advance to next token
         // .next??? : advance to next token
         
         // .hasNextLine() and .nextLine() ignores the delimiters
         .hasNextLine() -> boolean // returns true if there is a newline
         .nextLine() -> String // reads the rest of the line""");
   }

   // this demo100 method is for demo101 and demo102 to call
   public static void demo100Scanner(Scanner sc, String indent) {
      System.out.print(indent);
      System.out.println("Output: ===================");
      while (sc.hasNextLine()) { // while there are an available input
         if (sc.hasNextBoolean()) { // can the token be treated as a boolean?
            boolean b = sc.nextBoolean(); // convert the String token to boolean
            System.out.printf("%sboolean: [%b]%n",indent,b);
         } else if (sc.hasNextInt(2)) { // can the token be treated as an int in binary format?
            String bin = sc.next();
            Scanner s = new Scanner(bin);
            int i = s.nextInt(2); // convert the String token to int
            System.out.printf("%sint: [%s] (in binary) = [%d] (in decimal)%n",indent,bin,i);
         } else if (sc.hasNextInt()) { // can the token be treated as an int?
            int i = sc.nextInt();
            System.out.printf("%sint: [%d]%n",indent,i);
         } else if (sc.hasNextLong()) { // can the token be treated as a long?
            long g = sc.nextLong();
            System.out.printf("%slong: [%d]%n",indent,g);
         } else if (sc.hasNextDouble()) { // can the token be treated as a double?
            double d = sc.nextDouble();
            System.out.print(indent);
            System.out.print("double: [");
            System.out.print(d);
            System.out.println("]");
            System.out.printf("%s  (%%f): [%f]%n",indent,d);
            System.out.printf("%s  (%%e): [%e]%n",indent,d);
            System.out.printf("%s  (%%g): [%g]%n",indent,d);
         } else if (sc.hasNext("\\b.\\b")) { // can the token be treated as a char
            String s = sc.next();
            System.out.printf("%schar: [%s]%n",indent,s);
         } else if (sc.hasNext()) { // can the token be treated as a String?
            String s = sc.next();
            System.out.printf("%sString: [%s]%n",indent,s);
         } else if (sc.hasNextLine()) { // what is the token, then?
            String s = sc.nextLine();
            System.out.printf("%sNextLine: [%s]%n",indent,s);
            System.out.println("*** This line should not be reachable. ***");
         }
      }
      System.out.print(indent);
      System.out.println("The end of output.");      
   }
   public static void demo101ScannerFromString() {
      System.out.println("#### demo101 Scanner from String ####");
      String input = """
         a b 12.345   true  -1101\n+54321
         "a quoted string doesn't work." 
         543245465364656768756476465
         1234567890987 \n\t    \n     5e2  \t  
           y z""";
      Scanner sc = new Scanner(input);
      String indent = "  ";
      System.out.print(indent);
      System.out.println("Scanning from an input string: =================");
      System.out.println(input.indent(4));
      demo100Scanner(sc, indent);
   }
   public static void demo102ScannerFromFile() {
      System.out.println("#### demo102 Scanner from File ####");

      // write the following content to a file 
      String input = """
         a b 12.345   true  -1101\n+54321
         "a quoted string doesn't work." 
         543245465364656768756476465
         1234567890987 \n\t    \n     5e2  \t  
           y z""";
      final String path = "C:\\Users\\KriengkraiPorkaew\\Documents\\";
      final String filename = path + "forScanner.txt";
      try (PrintWriter fw = new PrintWriter(filename)) {
         fw.print(input);
      } catch (Exception e) {
         e.printStackTrace();
      }

      // use a scanner to scan the content of the file
      try (Scanner sc = new Scanner(new File(filename))) {
         String indent = "  ";
         System.out.print(indent);
         System.out.println("Scanning from a file:");
         System.out.print(indent);
         System.out.print(indent);
         System.out.println(filename);
         System.out.print(indent);
         System.out.println("The content of the file: =================");
         System.out.println(input.indent(4));
         demo100Scanner(sc, indent);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public static void demo201ScannerSystemIn() {
      System.out.println("#### demo201 Scanner from standard input (System.in) ####");
      Scanner sc = new Scanner(System.in);
      String indent = "  ";
      String prompt = indent + "Type any datatype in (Q or q to quit): ";
      System.out.print(prompt);
      while (sc.hasNextLine()) { // while there are an available input
         String line = sc.nextLine();
         if (line.isBlank()) {
            System.out.print(prompt);
            continue;
         }
         var s = new Scanner(line);
         s.useDelimiter("\\n");
         if (s.hasNext("[Q|q]")) { // Quit
            System.out.print(indent);
            System.out.println("Quit: [" + s.next() + "]");
            System.out.print(indent);
            System.out.println("Good Bye.");
            break;
         } else if (s.hasNextBoolean()) { // can the token be treated as a boolean?
            System.out.print(indent);
            System.out.println("boolean: [" + s.nextBoolean() + "]");
         } else if (s.hasNextInt()) { // can the token be treated as an int?
            System.out.print(indent);
            System.out.println("int: [" + s.nextInt() + "]");
         } else if (s.hasNextLong()) { // can the token be treated as a long?
            System.out.print(indent);
            System.out.println("long: [" + s.nextLong() + "]");
         } else if (s.hasNextDouble()) { // can the token be treated as a double?
            System.out.print(indent);
            System.out.println("double: [" + s.nextDouble() + "]");
         } else { // if (s.hasNext()) { // can the token be treated as a String?
            System.out.print(indent);
            System.out.println("String: [" + s.next() + "]");
         }
         System.out.print(prompt);
      }
      System.out.print(indent);
      System.out.println("Have a nice day.");
   }
   public static void demo301URLReader() {
      System.out.println("#### demo301 Read from URL (not related to Scannner) ####");
      URL url;
      try {
         url = new URL("https://www.google.com");
      } catch (MalformedURLException e) {
         System.out.println("Invalid URL");
         e.printStackTrace();
         return;
      }
      try (var ir = new InputStreamReader(url.openStream());
         var br = new BufferedReader(ir)) {
         String line;
         int maxLines = 5;
         int i = 0;
         while (++i <= maxLines && (line = br.readLine()) != null) {
            System.out.printf("LINE[%d] %s%n", i, line);
         }
         System.out.printf("The End: %d lines have been read.%n", --i);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   public static void demo401ConsoleReadPassword() {
      System.out.println("#### demo401 Use Console to read Password secretely. ####");
      String password;
      Scanner s = new Scanner(System.in);
      Console c = System.console();
      if (c != null) {
         System.out.println("You have a real console.");
         System.out.println("So, your password will not appear while typing.");
         System.out.print("Please type your password: ");
         password = new String(c.readPassword());
      } else {
         System.out.println("You do not have a real console.");
         System.out.println("So, your password will appear while typing.");
         System.out.print("Please type your password: ");
         password = s.nextLine();
      }
      System.out.print("Do you want to see what you have just typed in [y/n]: ");
      if (s.nextLine().equals("y")) {
         System.out.printf("You type: [%s]%n", password);
      }
      System.out.println("Good Bye.");
   }
}
