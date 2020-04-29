/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem;



/**
 *
 * @author meyer
 */
public class Sem 
{

    public static void main(String[] args) 
    {
        // TODO code application logic here
        semaph s = new semaph();
        process1 x1=new process1(s,1);
        process2 x2=new process2(s,2);
        process3 x3=new process3(s,3);
        x1.start();
        x2.start();
        x3.start();
    }
    
}
