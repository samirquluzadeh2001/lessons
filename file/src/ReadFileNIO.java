import java.nio.file.*;

public class ReadFileNIO {

    public static String readFileAsString(String fileName)throws Exception
    {
        byte[] data= readFileAsByte(fileName);
        String dataStr = new String(data);
        return dataStr;
    }

    public static byte[] readFileAsByte(String fileName) throws Exception{
        Path path = Paths.get(fileName);
        return Files.readAllBytes(path);
    }


}
