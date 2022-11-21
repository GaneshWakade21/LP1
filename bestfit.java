public class bestfit{
    public static void main(String[] args){
        int[] memory={200,400,130,500,600};
        int[] process={130,700,80,200,70,550,450};

        fit(memory,process);
    }

    public static void fit(int[] memory,int[] process){

        int[] allocation=new int[process.length];
        int index= Integer.MAX_VALUE;
        int empty= Integer.MAX_VALUE;

        for(int i=0;i<process.length;i++){
            index= Integer.MAX_VALUE;
            empty= Integer.MAX_VALUE;
            for(int j=0;j<memory.length;j++){
                if(process[i]<=memory[j]){
                    if(memory[j]<empty){
                        empty=memory[j];
                        index=j;
                    }   
                }
            }

            if(index!=Integer.MAX_VALUE){
                memory[index]=memory[index]- process[i];
                allocation[i] = index+1;
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