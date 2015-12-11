/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Matthew
 */
public class TrackingThread implements Runnable {
public static int ThreadUsedCount = 0;



    public void run() {
        System.out.println("Debug mode!");
        while(true) {
                    try 
                    {
                        Thread.sleep(10000);
                        //logic here
                    }
                    catch (InterruptedException e) {
                    }
                }
            }
       
    
    
    public static void main(String args[]) {
        (new Thread(new TrackingThread())).start();
    }
                    
    }
    

