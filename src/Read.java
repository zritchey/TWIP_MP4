import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
///////////////////////////////////     "rawDataU6.txt"
/**
 * Created by zr162 on 4/12/17.
 */
public class Read {
    private  ArrayList <String> lines=new ArrayList<>();
    public Read(String name){
        imports(name);
    }

    public   void imports(String s){
        try {
            Scanner sc = new Scanner(new File(s));
            while (sc.hasNextLine())
                lines.add(sc.nextLine());
        }
        catch(IOException i){
            System.out.println(i+ "\n the file "+s+" had an error");
            System.out.println(Arrays.toString(lines.toArray()));
        }
    }
    public void construct(){

    }
}
