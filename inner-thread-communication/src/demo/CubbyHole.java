package demo;

public class CubbyHole {
    private int content;
    private boolean avaliable=false;

    public synchronized int get(){

        while(avaliable==false){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        avaliable=false;
        System.out.println(String.format("Customer got: %d",content));
        notifyAll();
        return content;
    }
    public synchronized  void put(int data){
        while(avaliable==true) {

            try {
                wait();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        this.content=data;
        avaliable=true;
        System.out.println("Producer put::%d".formatted(data));
        notifyAll();
    }
}
