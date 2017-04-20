import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
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

    private   void imports(String s){
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
    public void construct(ArrayList <Student>a){
       String[] split;
        for (int i=0;i<lines.size();i++){
            split=lines.get(i).split("\t");
            //System.out.println(Arrays.toString(split));
            int id=-1;
            boolean next=false;
            try{
               id=Integer.parseInt( split[0]);
            }catch(InputMismatchException e){
                //System.out.println(e+"\n\nThat's a String, not a number");
                next=true;
            }
            catch(NumberFormatException n){
                //System.out.println(n+"\n\nThat's a String, not a number");
                next=true;
            }
            if(!next){
                int indx=Student.search(a,id);
                if(indx==-1){
                    a.add(new Student(id));
                    indx=a.size()-1;
                }
                int pts=0;
                int syn=0;
                for (int j=1;j<split.length;j++){

                    if (split[j].contains("\"")){
                        String[] s=split[j].split("\\+ ");

                        for (int r=1;r<s.length;r++) {
                            Scanner scan=new Scanner(s[r]);
                            try {
                                double d =Double.parseDouble(scan.next());
                                pts+=d;
                            }
                            catch(NumberFormatException n){
                                //System.out.println(n+"\n that was not a double");
                            }
                        }
                    }
                    else{
                        try{
                            int f=Integer.parseInt(split[j].trim());
                            syn+=f;
                        }
                        catch(NumberFormatException n){
                           //System.out.println(n);
                        }
                    }
                }
                a.get(indx).update(pts,syn);

            }
        }
    }
    ///
}
