
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class FileLoader2 {
    private String filename;

    public FileLoader2(String filename) {
        this.filename = filename;
    }

    public String[] load() {
        // generic class
        ArrayList<String> store = new ArrayList<String>();

        try { // try block
            File myObj = new File(this.filename);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                store.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // ONLY FOR DEBUGGING        
        System.out.println("What read: ");
        for (int i=0; i<store.size(); i++) {
            System.out.println(store.get(i));
        }

        return (String[]) store.toArray(new String[store.size()]);

    }



}