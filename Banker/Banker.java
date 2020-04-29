/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banker;

import java.util.Scanner;


public class Banker
{
    private int  available[],max[][],need[][],allocation[][], noPro,noRes;
    private boolean finish[];
    
    public void entry(){
        Scanner x = new Scanner(System.in);
        System.out.println("enter no of processes");
        noPro=x.nextInt();
        System.out.println("enter no of rescources");
        noRes=x.nextInt();
        available=new int[noRes];
        max=new int[noPro][noRes];
        allocation=new int[noPro][noRes];
        need=new int[noPro][noRes];
        //enter max
        System.out.println("enter max matrix row by row");
        for (int i =0;i<noPro;i++)
        {
            for (int j =0; j< noRes;j++)
            {
                max[i][j]=x.nextInt();
            }
        }
        System.out.println("enter allocation matrix row by row");
        //enter allocated
         for (int i =0;i<noPro;i++)
        {
            for (int j =0; j< noRes;j++)
            {
                allocation[i][j]=x.nextInt();
            }
        }
         System.out.println("need  matrix is ");
         //claculate need
        for (int i =0;i<noPro;i++)
        {
            for (int j =0; j< noRes;j++)
            {
                need[i][j]=max[i][j]-allocation[i][j];
                System.out.print(need[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("enter available matrix ");
        for (int i=0;i<noRes;i++)
        {
            available[i]=x.nextInt();
        }
    }
    public boolean verify(int p){
        for(int i=0;i<noRes;i++){
            if (available[i]<need[p][i]){
                return false;
            }
                  }
         return true;
    }
    public boolean safe()
    {
     entry();   
     int comp=0;  
     finish=new boolean[noPro];
     while (comp<noPro)
     {
      boolean flag=false;
      for(int i =0;i<noPro;i++){
          if(!finish[i]&&verify(i))
          {
              for (int j=0;j<noRes;j++)
              {
               available[j]=available[j]-need[i][j];   
               allocation[i][j]=allocation[i][j]+need[i][j];
               available[j]=available[j]+allocation[i][j];  
              }
              comp++;
              System.out.println("Allocated process : "+i);
              finish[i]=flag=true;
          }
      }
      if (!flag){
          return false;
      }
       
    }
     return true;
    }
    public static void main(String[] args)
    {
     Banker x =new Banker();
     if(x.safe()){
         System.out.println("system safe");
     }
     else {
         System.out.print("system not safe");

     }
             
       
    }
    
}
