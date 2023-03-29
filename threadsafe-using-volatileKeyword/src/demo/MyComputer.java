package demo;

public class MyComputer extends Thread{
    //for seeing in threads changes
    //share without problem
    //main thread change so second thread see the change
     private volatile boolean isRunning=true;
     private int count=1;

     @Override
     public void run() {
        while(isRunning){
            count++;
            System.out.println("Count:" +count+" Yes Your Computer is Running");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
     }
     public void stopRunning(){
         isRunning=false;
     }


 }
