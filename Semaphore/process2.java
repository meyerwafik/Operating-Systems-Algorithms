/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem;
//import static javaapplication20.Process.numglobal;




/**
 *
 * @author meyer
 */
public class process2 extends Processes {
         int c2=0;
        process2(semaph s,int name){
       super(s);
       this.name=name;
        }
        @Override
        public void run() 
        {
         while(c2 <2)
            {
                c2++;
                 System.out.println("Process 2 is working");
                try {
                      sem.waits(this);
                } catch (InterruptedException ex) {
                   System.out.println("wrong output");
                }
                 decrement(numglobal);
            
        System.out.println("Process 2 decremented number by 1");
                 
                    sem.signals();
        }
        }     
        public void decrement(int num){
           System.out.println("Process 1 entered critical section ");
          numglobal= --num;
        
          System.out.println("Process 2 made the global number =" + numglobal);
           System.out.println("Process 1 exited critical section ");
        }
    
    }
