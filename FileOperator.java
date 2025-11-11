import java.io.*;
import java.util.*;

public class FileOperator {
    private File myFile;
    private Scanner fileReader;

    public FileOperator(String f){
        try {
            setFile(f);
        } catch (IOException e) {}
    }
    public void setFile(String f) throws IOException{
        myFile = new File(f);
        fileReader = new Scanner(myFile);
    }
    public String readline(){
        return fileReader.nextLine();
    }
}
