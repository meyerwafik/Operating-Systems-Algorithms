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
 public class process1 extends Processes {
   int c1=0;
        process1(semaph s,int name){
       super(s);
       this.name=name;
        }
        @Override
        public void run(){
            while(c1 <2){
                c1++;
            System.out.println("Process 1 is working");
        try {
            sem.waits(this);
            
        } catch (InterruptedException ex) {
            System.out.println("wrong output");
             
        }  
            increment(numglobal);
            
            System.out.println("Process 1 incremented the global number by 1");
            sem.signals();
            }      
                } 
        public void increment(int num){
          System.out.println("Process 1 entered critical section ");
          numglobal= ++num;
        
          System.out.println("Process 1 made the global number =" + numglobal);
           System.out.println("Process 1 exited critical section ");
        }
    
    }
