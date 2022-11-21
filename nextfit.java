public class nextfit{
    public static void main(String[] args){
        int[] memory={5,10,20};
        int[] process={10,20,25,4};

        fit(memory,process);
    }

    public static void fit(int[] memory,int[] process){

        int[] allocation=new int[process.length];
        int count=0;
        int j=0;
        for(int i=0;i<process.length;i++){
            
            while(true){
                if(process[i]<=memory[j]){
                    memory[j]=memory[j] - process[i];
                    allocation[i]=j+1;
                    count=0;
                    break;
                }
                count++;

                if(count==memory.length){
                    break;
                }
                j=(j+1) % memory.length;
                
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