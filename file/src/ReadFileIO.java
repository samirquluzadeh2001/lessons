import beans.User;

import java.io.*;
import java.util.Scanner;

public class ReadFileIO {
    private static final String FILENAME = "test";

    public static void main(String[] args) throws Exception {
        readFileUsingByte();
    }

    public static void readUsingBufferedReader(){
        BufferedReader br = null;
        FileReader fr = null;

        try {
            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    public static void readUsingFileReader() throws Exception {
        // pass the path to the file as a parameter
        FileReader fr =  new FileReader(FILENAME);

        int i;
        while ((i=fr.read()) != -1) {
            System.out.println("symbol index:" + i);
            System.out.print((char) i);
        }
    }

    public static void readUsingScanner() throws Exception{
        // pass the path to the file as a parameter
        File file = new File(FILENAME);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }

    public static void readUsingBufferedReaderAutoCloseable(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileUsingInputStream(){
        try (InputStream in = new FileInputStream(FILENAME);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public static void readFileUsingByte() throws Exception{
        // getBytes from anyWhere
        // I'm getting byte array from File
        File file = null;
        FileInputStream fileStream = new FileInputStream(file = new File("Sarkhan Rasullu.jpg"));

        // Instantiate array
        byte[] arr = new byte[(int) file.length()];//
        System.out.println("file.length()="+file.length());
        // read All bytes of File stream
        fileStream.read(arr, 0, arr.length);

        for (byte x : arr) {
            System.out.println(x);
            System.out.print((char) x);
        }
    }

    public static Object readFileDeserialize(String name){
        Object obj=null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))){
            obj = in.readObject();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            return obj;
        }
    }
}
