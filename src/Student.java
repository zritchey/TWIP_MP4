import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zr162 on 4/12/17.
 */
public class Student {

    private int errors=0;
    private double points;
    private int scores;
    public final int id;
    private ArrayList<Double> grades;
    public Student(int n){
        id=n;
        grades=new ArrayList<>();
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
    public void update(double pts,int syn){
        points+=pts;
        errors+=syn;
        scores++;
    }
    grade
    private int calculate(){
        return (int)((points-(0.25*errors))/scores);
    }
    public static void match(ArrayList<Student> a, String file){
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()) {
                String[] name = sc.nextLine().split(",");

                try {
                   int i=Integer.parseInt(name[0]);
                    i=search(a,i);
                    if (i==-1)
                        System.out.println("Student"+name[1]+"does not exist in the files");
                    else {
                        System.out.println(name[1]+" earned "+a.get(i).calculate()+" points");
                    }
                }
                catch(NumberFormatException n) {
                    System.out.println(n + "could not parse Int");
                }
            }
        }
        catch(IOException i){
            System.out.println(i+"file did not match properly");
        }
    }

}
