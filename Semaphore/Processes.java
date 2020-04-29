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
public abstract class Processes extends Thread 
{
    public static int numglobal=10;
    int name;
    semaph sem;
    Processes(semaph sem)
    {
    this.sem=sem;
    }
    
   
 @Override
    public abstract void run() ;
}
