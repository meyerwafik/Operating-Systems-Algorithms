/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Detection;

import java.util.Scanner;


public class Detection
{

    /**
     * @param args the command line arguments
     */
    private int  available[],max[][],need[][],allocation[][],maxR[], req[][], noPro,noRes;
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
         req=new int[noPro][noRes];
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
    public int maxR()
    {    
    int maximum=0;
    int index=0;
    maxR=new int[noPro];
    for (int i=0;i<noPro;i++)
    {

        for (int j=0;j<noRes;j++)
        {
           maxR[i]= allocation[i][j]+maxR[i];
        }
     }

    for (int t=0;t<noPro;t++)
    {
        if (maxR[t]>maximum){
            maximum=maxR[t];
            index=t;
        }
    }
    return index;
    }
    public void detection()
    {
     entry();   
     int comp=0;  
     int term=0;
     finish=new boolean[noPro];
     while (comp+term<noPro)
     {
      boolean flag=false;
      for(int i =0;i<noPro;i++)
      {
          if(!finish[i]&&verify(i))
          {
              for (int j=0;j<noRes;j++)
              {

               
            available[j]=available[j]+allocation[i][j];
            allocation[i][j]=0;
              }
              
              comp++;
              System.out.println("Allocated process : "+i);
              finish[i]=flag=true;
          }
      }
      
      if (!flag)
      {
           System.out.print("Deadlock detected in processes:");
         for (int i=0;i<noPro;i++)
         {
             if (finish[i]==false){
                 System.out.print(" "+ i);
             }
             
         }
         System.out.println();
          for (int i=0;i<noPro;i++)
         {
             if ((finish[i]==false) && (i==maxR()))
             {                 
               int d=i;
               for (int t=0;t<noRes;t++){
                   
               available[t]=available[t]+allocation[d][t];
               need[d][t]=req[d][t]=0;
        
                 }
               finish[d]=true;
               System.out.println("Process " +d+ "is terminated");
               term++;
               break;
             }
         }
         
      }
       
    }
     
    }
    public static void main(String[] args)
    {
     Detection x =new Detection();
     x.detection();

     }
             
       
    }
    

