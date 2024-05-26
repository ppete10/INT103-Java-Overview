package int103;

import Entities.Cat;
import MyException.Checked119;
import MyException.Unchecked119;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static String PATH = "/Users/peerapansatitwiparawong/Documents/Assignment/INT103/int103tew/src/main/java/";

    public static void main(String[] args) throws Exception{


        //fileIOStream();
        //fileBuffered();
        //obj();
        //writerReader();
        writeFromScannerTofile();
    }

    private static void writeFromScannerTofile() {

        Scanner scanner = new Scanner(System.in);

        String name = null, gender = null;
        int age = 0;
        System.out.print("Enter name: ");
        name = scanner.nextLine();

        while (true) {
            System.out.print("Enter age: ");
            if(scanner.hasNextInt() ) {
                age = scanner.nextInt();
                if(age > 0) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Age must be greater than 0");
                    scanner.nextLine();
                    continue;
                }
            }
            System.out.println("Please enter a valid number");
            scanner.nextLine();
        }
        System.out.println("Age: " + age);


        while (true) {
            System.out.print("Enter Gender: ");
            if (scanner.hasNext()) {
                gender = scanner.next();
                if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                    break;
                }
            }
            System.out.println("Gender can only be [Male/Female]");
            scanner.nextLine();
        }

        // Write the input from scanner into file using BufferedOutputStream
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/user.txt");
             BufferedOutputStream writer = new BufferedOutputStream(fileOutputStream)) {
            writer.write(name.getBytes());
            writer.write("\n".getBytes());
            writer.write(String.valueOf(age).getBytes());
            writer.write("\n".getBytes());
            writer.write(gender.getBytes());
        } catch (IOException e) {
            System.out.println("Error while wring files");
        }
        // Close Scanner
        scanner.close();

        // Print data from file using BufferReader
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/user.txt");) {
            Scanner fileScanner = new Scanner(fileInputStream);
            fileScanner.useDelimiter( "");

            while (fileScanner.hasNext()) {
                System.out.println(fileScanner.next());
            }

        } catch (IOException e) {
            System.out.println("File not found");;
        }
    }

    private static void writerReader() throws Exception{
        String filename = PATH + "output.txt";

        String[] names = {"Moo","noi","pong"};

        FileWriter fw = new FileWriter(filename);
        try {
            fw.write("Epong");
            fw.write("\nNahee");

            for (String n: names){
                fw.write("\n" + n);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            fw.close();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void obj() {
        String filename = PATH + "obj.dat";
        Cat c1 = new Cat("black","p",5);
        Cat c2 = new Cat("white","n",2);

        try (
        FileOutputStream fo = new FileOutputStream(filename);
        BufferedOutputStream bo = new BufferedOutputStream(fo,1024);
        ObjectOutputStream oo = new ObjectOutputStream(bo)){
            oo.writeObject(c1);
            oo.writeObject(c2);
        }catch (Exception e){

        }
        try (FileInputStream fi = new FileInputStream(filename);
        BufferedInputStream bi = new BufferedInputStream(fi,1024);
        ObjectInputStream oi = new ObjectInputStream(bi)){
            Cat c = (Cat) oi.readObject();
            System.out.println(c);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void fileBuffered() throws Exception{

        String filename = PATH + "Emoo.dat";
        String filename2 = PATH + "Emoo2.dat";


        FileOutputStream fo = new FileOutputStream(filename);
        BufferedOutputStream bo = new BufferedOutputStream(fo,1024);
        try {
            bo.write(100);
            bo.write(new byte[] {68,69,70});
            bo.flush();
            bo.write(77);

        } catch (IOException e){

        } finally{
            bo.close();
        }

        try (FileInputStream fi = new FileInputStream(filename);
             BufferedInputStream bi = new BufferedInputStream(fi,1024)){
            int len = bi.available();
            System.out.println("len= " + len);
            byte[] out = bi.readNBytes(len);
            System.out.println(Arrays.toString(out));

        }catch (Exception e){

        }
    }










    private static void fileIOStream() {
        String filename = PATH + "epong.dat";

        System.out.println(filename);
        try {
            FileOutputStream fo = new FileOutputStream(filename);
            fo.write(65);
            fo.write(new byte[] {66,67,68,69,70});

        } catch (IOException e){

        }

        try {
            FileInputStream fi = new FileInputStream(filename);
            int len = fi.available();
            System.out.println("len= " + len);
            byte[] out = fi.readNBytes(len);
            System.out.println(Arrays.toString(out));

        } catch (IOException e) {
            System.out.println("EPONG ");
        }

    }


}