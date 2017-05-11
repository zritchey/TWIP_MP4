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

        construct(students,"rawDataU6.txt");
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

    public  static ArrayList <String> lines=new ArrayList<>();

    public static void construct(ArrayList <Student>a,String name){
        try {
            Scanner sc = new Scanner(new File(name));
            while (sc.hasNextLine())
                lines.add(sc.nextLine());
        }
        catch(IOException i){
            System.out.println(i+ "\n the file "+name+" had an error at line "+lines.size());
        }
        String[] split;
        int id=-1;
        for (int i=0;i<lines.size();i++){
            split=lines.get(i).split("\t");
            boolean next=false;
            try{
                id=Integer.parseInt( split[0]);
            }catch(Exception e){
                next=true;
            }
            if(!next){
                int indx=Student.search(a,id);
                if(indx==-1){
                    a.add(new Student(id));
                    indx=a.size()-1;
                }
                double pts=0;
                int syn=0;
                for (int j=1;j<split.length;j++){

                    if (split[j].contains("+")){
                        String[] s=split[j].split("\\+ ");
                        for (int r=1;r<s.length;r++) {
                            Scanner scan=new Scanner(s[r]);
                            try {
                                double d =Double.parseDouble(scan.next());
                                pts+=d;
                            }
                            catch(NumberFormatException n){

                            }
                        }
                    }
                    else{
                        try{
                            int f=Integer.parseInt(split[j].trim());
                            syn+=f;
                        }
                        catch(NumberFormatException n){
                        }
                    }
                }
                a.get(indx).grade(pts,syn);
            }
        }
    }
}