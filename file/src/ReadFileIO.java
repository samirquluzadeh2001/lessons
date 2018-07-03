import java.io.*;
import java.util.Scanner;

public class ReadFileIO {
    private static final String FILENAME = "E:\\test\\filename.txt";

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

    public static void readUsingFileReader() throws Exception {
        // pass the path to the file as a parameter
        FileReader fr =  new FileReader("C:\\Users\\pankaj\\Desktop\\test.txt");

        int i;
        while ((i=fr.read()) != -1)
            System.out.print((char) i);
    }

    public static void readUsingScanner() throws Exception{
        // pass the path to the file as a parameter
        File file =
                new File("C:\\Users\\pankaj\\Desktop\\test.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
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
        byte[] arr = new byte[(int) file.length()];

        // read All bytes of File stream
        fileStream.read(arr, 0, arr.length);

        for (int x : arr) {
            System.out.print((char) x);
        }
    }
}
