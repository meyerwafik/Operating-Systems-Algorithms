/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/**
 *
 * @author meyer
 */
public class semaph {   
     private static Lock x = new ReentrantLock();
   static int value=1;
ArrayList<Processes> arrli = new ArrayList<>();
public  void waits(Processes p) throws InterruptedException {
    synchronized(this)
    {
        
       value--;
    
        System.out.println("process " +p.name +" entered  waits function   ");
         System.out.println("value is " +value);
        if (value<0)
        {
           
          for (int i=0;i<arrli.size();i++)
          {
             System.out.print("Processes in list "+ arrli.get(i).name);
          }
           if (arrli.size()!=0){
     System.out.println();
    }
          arrli.add(p);
          synchronized(p)
          {
              
                p.wait();
          }
            
        }
    }
}
        
  public  void signals()
  { 
    x.lock();
    value++;
    x.unlock();
    System.out.println("value is " +value );
    for (int i=0;i<arrli.size();i++)
    {
        System.out.print("Processes in list before signal "+ arrli.get(i).name);
    }
    if (arrli.size()!=0){
     System.out.println();
    }
     System.out.println("Signal" );
     if ((value<=0) && (arrli.size()!=0))
       {
       Processes p = this.arrli.get(0);    
       arrli.remove(0);
       for (int i=0;i<arrli.size();i++)
       {
           System.out.print("Processes in list after signal "+ arrli.get(i).name);
       }
        if (arrli.size()!=0){
     System.out.println();
    }
      
       synchronized(p)
       {
           p.notify();
       }
       }
    }
}





