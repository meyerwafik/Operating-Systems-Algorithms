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
public class process3 extends Processes {
            int c3=0;
           process3(semaph s,int name){
       super(s);
       this.name=name;
        } 
        @Override
        public void run() {
           while(c3 <2)
           {
                c3++;
                System.out.println("Process 3 is working");
            try {
            sem.waits(this);
        } catch (InterruptedException ex) {
            System.out.println("wrong output");
        }
        incrementby50(numglobal);
       
        System.out.println("Process 3 incremented number by 50");
                   sem.signals();
           }
        }
        public void incrementby50(int num)
        {
          System.out.println("Process 3 entered critical section3");
          numglobal= num+50;
          System.out.println("Process 3 made the global number =" + numglobal);
          System.out.println("Process 3 exited critical section3");
        }
    }
