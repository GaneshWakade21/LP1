import java.io.*;
import java.util.*;
 
public class OptimalPR {
    static boolean search(int key, int[] fr)
    {
        for (int i = 0; i < fr.length; i++)
            if (fr[i] == key)
                return true;
        return false;
    }

    //pg=paage   fr=frame    pn= pg.length     index=next ind of current page to be repalced
    static int predict(int pg[], int[] fr, int pn,int index)   
    {
        int res = -1, farthest = index;
        for (int i = 0; i < fr.length; i++) {
            int j;
            for (j = index; j < pn; j++) {
                if (fr[i] == pg[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }

            if (j == pn)
                return i;
        }
 
        if(res==-1){
            return 0;
        }else{
            return res;
        }
    }
 
    static void optimalPage(int pg[], int pn, int fn)
    {
        int[] fr = new int[fn];
 
        int hit = 0;
        int index = 0;
        for (int i = 0; i < pn; i++) {
            if (index < fn){
                fr[index] = pg[i];
                index++;
            }
            else {
                if (search(pg[i], fr)) {
                    hit++;
                }else{
                    int j = predict(pg, fr, pn, i + 1);
                    fr[j] = pg[i];
                }
            }

            System.out.print("Frame \t" );
            for(int j=0;j<fr.length;j++){
                System.out.print(fr[j]+"\t");
            }
            System.out.println();
            System.out.println("Hits :"+hit);

        }
        System.out.println();
        System.out.println("No. of hits = " + hit);
        System.out.println("No. of misses = " + (pn - hit));
    }
 
    public static void main(String[] args)
    {
 
        // int pg[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        // int pg[] = { 7, 4, 1, 2, 2, 3, 5, 4, 2, 3, 3, 3, 2 };
        int[] pg={7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        int pn = pg.length;
        int fn = 4;
        optimalPage(pg, pn, fn);
    }
}