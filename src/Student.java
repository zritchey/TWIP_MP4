import java.util.ArrayList;

/**
 * Created by zr162 on 4/12/17.
 */
public class Student {

    private final int id;
    public Student(int n){
        id=n;
    }
    public boolean identify(int i){
        return this.id==i;
    }
    public void add (int score,int syntax){//    /    //?

    }
    public static int search(ArrayList<Student>a,int student){
        int indx=-1;
        for (int i=0;i<a.size();i++)
            if(a.get(i).identify(student)){
                indx=i;
                break;
            }
        return indx;
    }

}
