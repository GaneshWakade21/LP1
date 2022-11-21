class FCFS{
    static void findWaitingTime(int arrivaltime[], int n,int bt[], int wt[]) {
        wt[0] = 0;
        int servicetime=0;

        for (int i = 1; i < n; i++) {
            servicetime+=bt[i-1];
            wt[i] = servicetime - arrivaltime[i];
        }
    }
 
    static void findTurnAroundTime(int arrivaltime[], int n,int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    static void findavgTime(int arrivaltime[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
    
        findWaitingTime(arrivaltime, n, bt, wt);
      
        findTurnAroundTime(arrivaltime, n, bt, wt, tat);
        
        System.out.println("Process"+"\t\t"+"ArrivalTime"+"\t"+"Burst_Time"+"\t"+"WaitingTime"+"\t"+"TurnAroundTime");

        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            int p=i+1;
            System.out.println("P"+p+"\t\t"+arrivaltime[i]+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
        }
        System.out.println();
        float s = (float)total_wt /(float) n;
        int t = total_tat / n;
        System.out.println("Average waiting time = "+ s);
        System.out.println("Average turn around time = "+ t);
    }
 
    
    public static void main(String[] args) throws Exception {
       
        // int arrivaltime[] = {1, 2, 3};
        int arrivaltime[] = {0, 3, 6};
        int n = arrivaltime.length;
 
        // int burst_time[] = {10, 5, 8};
        int burst_time[] = {5, 9, 6};

        findavgTime(arrivaltime, n, burst_time);
    }
}

