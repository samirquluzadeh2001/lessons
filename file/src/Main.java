import beans.User;
import beans.UserWrapper;

public class Main {
//salam
    public static void main(String[] args) {
        User[] arr = new User[2];
        arr[0] = new User("Sarkhan","Rasullu",25,"122343");
        arr[1] = new User("Sarkhan2","Rasullu",25,"122343");

        UserWrapper uw = new UserWrapper();
        uw.setCompetitors(arr);
        WriteToFileExampleIO.writeObjectToFile(uw,"uw");

        UserWrapper user = (UserWrapper) ReadFileIO.readFileDeserialize("uw");

      for(int i=0;i<user.getCompetitors().length;i++){
          System.out.println(user.getCompetitors()[i].getName());
      }
    }

}
