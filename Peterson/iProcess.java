package peterson;

public class iProcess extends Processes
{
    @Override
    public void run()
    {
        do{
        flag[i] = true; 
        turn = j; 
        while (flag[j] && turn == j); 
        System.out.println("I cs");
        for (int t=0;t<2;t++){
        check++;
        System.out.println("check is "+check);
        }
        
        counter++;
        System.out.println("counter is "+counter);
        flag[i] = false; 
        }while (counter<10);
    }

   
    
}
