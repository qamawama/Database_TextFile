import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileLoader {

    // File loader attributes
    private String filename;
    private ArrayList<String> dataList;

    // constructor
    public FileLoader(String filename){
        this.filename = filename;
    }

    // Method load and read file
    public void load(){
        ArrayList<String> dataList = new ArrayList<String>();

        try{
            File myFile = new File(this.filename);
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                dataList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occured. ");
            e.printStackTrace();
        }
        this.dataList = dataList;
    }

    public void display(){
        System.out.println("Displaying text file data...");
        for (int i = 0; i < dataList.size(); i++){
            System.out.println(dataList.get(i));
        }
    }
}
