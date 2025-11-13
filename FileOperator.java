import java.io.*;
import java.net.*;
import java.util.*;

public class FileOperator {
    private File myFile;
    private Scanner fileReader;
    private URL url;

    public FileOperator(String f){
        try {
            setFile(f);
        } catch (IOException e) {}
    }
    public FileOperator(String url, boolean isOnline) throws Exception{
        if (isOnline){
            setUrl(url);
        }
        else {
            setFile(url);
        }
    }
    public void setUrl(String f) throws Exception{
        url = new URI(f).toURL();
        fileReader = new Scanner(url.openStream());

    }
    public void setFile(String f) throws IOException{
        myFile = new File(f);
        fileReader = new Scanner(myFile);
    }
    public String readline(){
        if (fileReader.hasNextLine()){
            return fileReader.nextLine();
        }
        return null;
    }

    public static void main(String[] args) {
        FileOperator online = new FileOperator("null");
        String line = online.readline();
        while (line!=null){
            System.out.println(line);
            line = online.readline();
        }
    }
}
