package demo;

public class MyThread implements Runnable{

    private String s1,s2;
    public MyThread(String s1,String s2){
        this.s1=s1;
        this.s2=s2;

        Thread t=new Thread(this);
        t.start();
    }
    @Override
    public void run() {
    TwoString.print(s1,s2);
    }
}
