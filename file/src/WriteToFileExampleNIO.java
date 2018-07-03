import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteToFileExampleNIO {

    public static void main(String[] args) {

    }

    public static void writeUsingPath() throws IOException {
        Path path = Paths.get("src/main/resources/question.txt");
        String question = "To be or not to be?";
        Files.write(path, question.getBytes());
    }

    public static void writeUsingBufferedWriter(){
        Path path = Paths.get("src/main/resources/shakespeare.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
            writer.write("To be, or not to be. That is the question.");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void copyFileUsingPath(){
        Path oldFile = Paths.get("src/main/resources/", "oldFile.txt");
        Path newFile = Paths.get("src/main/resources/", "newFile.txt");
        try (OutputStream os = new FileOutputStream(newFile.toFile())) {
            Files.copy(oldFile, os);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
