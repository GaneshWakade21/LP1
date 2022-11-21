public class SJF {
    public static void main(String[] args){
        int[] bt={5,3,6,5};
        int[] at={1,1,2,3};

        SJF(at,bt,bt.length);
    }
    public static void SJF(int[] at,int[] bt,int n){
        int[] wt=new int[n];
        int[] tat=new int[n];
        int[] ct=new int[n];

        waitingtime(at,bt,wt,ct);


        for(int i=0;i<wt.length;i++){
            tat[i]=wt[i]+bt[i];
        }

        float totalwt=0;
        float totaltat=0;

        System.out.println("at \t bt \t wt \t tat \t ct");
        for(int i=0;i<at.length;i++){
            System.out.println(at[i]+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]+"\t"+ct[i]);
            totalwt+=wt[i];
            totaltat+=tat[i];
        }
        System.out.println("Average wating time : " + (totalwt / wt.length));
        System.out.println("Average turn around time : "+ (totaltat / wt.length));
    }

    public static void waitingtime(int[] at,int[] bt,int[] wt,int[] ct){

        int[] tempbt=new int[100];
        tempbt[99]=1000;
        for(int i=0;i<bt.length;i++){
            tempbt[i]=bt[i];
        }

        int count=0;

        for(int i=0;count<bt.length;i++){
            
            int smallest=99;
            for(int j=0;j<bt.length;j++){
                if(at[j]<=i && tempbt[j]<tempbt[smallest] && tempbt[j]>0 ){
                    smallest=j;
                }
            }

            tempbt[smallest]--;

            if(tempbt[smallest]==0){
                ct[smallest]=i+1;
                count++;
            }

        }

        for(int i=0;i<wt.length;i++){
            wt[i]=ct[i]-at[i]-bt[i];
        }



    }
}
