package peterson;

import static peterson.Processes.j;

public class jProcess extends Processes {    
    @Override
    public void run()
    {
       do{
        
        flag[j] = true; 
        turn = i; 
        while (flag[i] && turn == i); 
        System.out.println("J cs");
        check--; 
        System.out.println("check is "+check);
        counter++; 
        System.out.println("counter is "+counter);
        flag[j] = false; 
        } while (counter<10);
    }
     }

