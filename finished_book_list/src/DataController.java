import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DataController {
    public final String dataFilePath = "C:\\Users\\dkswj\\Desktop\\피니시드북스_프로젝트\\finished_book_list\\src\\data.csv";
    private List<BookData> bookList;

    public DataController(){
        bookList = new LinkedList<>();
        try{
            Scanner sc = new Scanner(new File(dataFilePath));
            while(sc.hasNextLine()){
                bookList.add(new BookData(sc.nextLine()));
            }
            sc.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public List<BookData> getBookList(){
        return bookList;
    }

    public void saveData(){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(dataFilePath,false));
            for(BookData bookData : bookList){
                br.write(bookData.toString());
                br.newLine();
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
