import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class DataController {
    private String filePath;
    private List<String[]> dataList;
    private Scanner sc;

    public DataController(String filePath) {
        this.filePath = filePath;
        dataList = new LinkedList<>();
        try{
            sc = new Scanner(new File(filePath));
            while(sc.hasNextLine()){
                dataList.add(sc.nextLine().split(","));
            }
            sc.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public List<String[]> getDataList(){
        return dataList;
    }

    public void saveData(){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(filePath,false));
            for(String[] str : dataList){
                br.write(String.join(",", str));
                br.newLine();
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
