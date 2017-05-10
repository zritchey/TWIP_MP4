import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zr162 on 4/12/17.
 */
public class Main {


    public static ArrayList<Student> students=new ArrayList<>();
    public static void main (String args[]){
        Read data=new Read("rawDataU6.txt");
        data.construct(students);
        Scanner sc=new Scanner(System.in);
        System.out.print("Place your file of ids and names in the root folder.\nThen input your file name here: ");
        String s="";
        boolean f=true;
        while (f){
            s=sc.nextLine();
            System.out.println();
            try{
                Scanner n=new Scanner(new File(s));
                n.nextLine();
                n.close();
                f=false;
            }
            catch(IOException i) {
                System.out.print("That's not a valid file name. Try again: ");
            }
        }
        Student.match(students,s);



    }
}
