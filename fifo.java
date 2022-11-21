public class fifo {
    public static void main(String[] args){
        // int[] pg={7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        int pg[]={5, 7, 5, 6, 7, 3};
        int pn = pg.length;
        int fn = 4;
        FirstPage(pg, pn, fn);
    }

    public static void FirstPage(int[] pg,int pn,int fn){
        int[] fr=new int[fn];
        int ind=0;
        int hit=0;
        int re=0;
        for(int i=0;i<pn;i++){
            if(ind<fn){
                boolean p=false;
                for(int j=0;j<=ind;j++){
                    if(fr[j]==pg[i]){
                        p=true;
                        break;
                    }
                }

                if(p==true){
                    hit++;
                }else{
                    fr[ind]=pg[i];
                    ind++;
                }
                
            }else{
                if (search(pg[i], fr)) {
                    hit++;
                }else{
                    fr[re]=pg[i];
                    re++;
                    re=re%fn;
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

    static boolean search(int key, int[] fr)
    {
        for (int i = 0; i < fr.length; i++)
            if (fr[i] == key)
                return true;
        return false;
    }
}
