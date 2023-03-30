package demo;

public class Consumer extends Thread{
    private CubbyHole cubbyHole;
    private int number;

    public Consumer(CubbyHole cubbyHole,int number){
        this.cubbyHole=cubbyHole;
        this.number=number;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++){
            cubbyHole.get();

        }
    }

}
