public class firstfit{
    public static void main(String[] args){
        int[] memory={200,400,120,500,600};
        int[] process={130,700,80,200,70,550,450};

        fit(memory,process);
    }

    public static void fit(int[] memory,int[] process){

        int[] allocation=new int[process.length];

        for(int i=0;i<process.length;i++){
            for(int j=0;j<memory.length;j++){
                if(process[i]<=memory[j]){
                    memory[j]=memory[j] - process[i];
                    allocation[i]=j+1;
                    break;
                }
                allocation[i]=0;
            }
        }

        System.out.println("Process \t AllocatedSlot");
        for(int i=0;i<process.length;i++){
            if(allocation[i]==0){
                System.out.println(process[i] +"\t \t"+ "Not Allocated" );
            }else{
                System.out.println(process[i] +"\t \t"+ allocation[i] );
            }  
        }
    }
}