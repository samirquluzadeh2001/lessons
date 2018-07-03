import java.nio.file.*;

public class ReadFileNIO {

    public static String readFileAsString(String fileName)throws Exception
    {
        String data = new String(readFileAsByte(fileName));
        return data;
    }

    public static byte[] readFileAsByte(String fileName) throws Exception{
        Path path = Paths.get(fileName);
        return Files.readAllBytes(path);
    }


}
