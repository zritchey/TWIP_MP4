import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zr162 on 4/12/17.
 */
public class Student {

    public final int id;
    private double  points;
    private int ptnum;
    private int errors;
    public Student(int n){
        id=n;
        points=0;
        ptnum=0;
        errors=0;
    }
    public static int search(ArrayList<Student>a,int student){
        int indx=-1;
        for (int i=0;i<a.size();i++)
            if(a.get(i).id==student){
                indx=i;
                break;
            }
        return indx;
    }
    public void grade (double pts,int syn){
      points=points+pts;
       errors+=syn;
        ptnum++;
    }
    public double syntax(){
        return errors/(double)ptnum;
    }

    private double calculate(){return ((points-(0.25*errors))/ptnum);}

    public static void match(ArrayList<Student> a, String file){
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()) {
                String[] name = sc.nextLine().split("\\s+");

                try {
                   int i=Integer.parseInt(name[0]);
                    i=search(a,i);
                    if (i==-1)
                        System.out.println("Student "+name[1]+" does not exist in the files");
                    else {
                        System.out.println(name[1]+" earned "+a.get(i).calculate()+" points");
                        System.out.println("Average Syntax Errors: "+(a.get(i).syntax())+"\n");
                    }
                }
                catch(NumberFormatException n) {
                    System.out.println(n + "\n could not parse Int"+name[0]);
                }
            }
        }
        catch(IOException i){
            System.out.println(i+"\n\n file did not match properly");
        }
    }
}
