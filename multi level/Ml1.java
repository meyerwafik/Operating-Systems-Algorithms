/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ml1;

import java.util.Random;
import java.util.Scanner;

public class Ml1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
    Ml1 x= new Ml1();
    System.out.println("Enter number of processes from 1 to 500: ");
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    int []p=new int[n];
    System.out.println("Enter Q1:");
    int q1=s.nextInt();
    System.out.println("Enter Q2:");
    int q2=s.nextInt();
        x.rrfcfs(p,n,q1,q2);
    
    }
    
    public  void rrfcfs(int[]p,int n,int q1,int q2){
    int [] arrivaltime=new int[n];//time of arrival
    for (int i = 0; i < n; i++) {
        p[i]= (int) ((i+1)*3);//process's burst time
    }
        for (int i = 0; i < n; i++) {
            arrivaltime[i]= i;//Arrival time
        }
    int[] rt=new int[n];//remaining time
    for (int i = 0; i < n; i++) {
        rt[i]=p[i];
    }
    int[] tc=new int[n];//Time of completion
    for (int i = 0; i < n; i++) {
        tc[i]=0;
    }
    int t=0;
    for (int i = 0; i < n; i++) {
        if (rt[i]<=q1 && rt[i]!=0 ) {
            t=t+rt[i];
            rt[i]=0;
            tc[i]=t;
        }else{
        rt[i]=rt[i]-q1;
        t=t+q1;
        }
    }
    for (int i = 0; i < n; i++) {
        if(rt[i]==0){
        
        }else if (rt[i]<=q2 && rt[i]>0) {
            t=t+rt[i];
            rt[i]=0;
            tc[i]=t;
        }else{
        rt[i]=rt[i]-q2;
        t=t+q2;
        }
    }
    
    for (int i = 0; i < n; i++) {
        if (rt[i]!=0) {
            t=t+rt[i];
            rt[i]=0;
            tc[i]=t;
        }
    }
    
    int[] tw=new int[n];//waiting time
    for (int i = 0; i < n; i++) {
        tw[i]=tc[i]-p[i]-arrivaltime[i];
    }
    int [] ta=new int[n];//turnaround time
        for (int i = 0; i < n; i++) {
            ta[i]=tc[i]-arrivaltime[i];
        }
    System.out.println("CPU time: ");
    for (int i = 0; i < n; i++) {
        System.out.print(" "+p[i]);
    }
    System.out.println();
    System.out.println("Arrival time: ");
    for (int i = 0; i < n; i++) {
        System.out.print(" "+arrivaltime[i]);
    }
    System.out.println();
    System.out.println("waiting time: ");
    for (int i = 0; i < n; i++) {
        System.out.println("waiting time for process " + i +" is " +tw[i]);
    }
    System.out.println("Turnaround time: ");
    for (int i = 0; i < n; i++) {
        System.out.println("turnaround time for process " + i +" is " +ta[i]);
    }
}
    
}
