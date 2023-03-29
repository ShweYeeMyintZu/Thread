package demo;

public class Main {

    public static void main(String[] args) {
        //add one key make to carry data from one obj

        TwoString obj=new TwoString();
        new MyThread("Hello","How is Your Day?",obj);
        new MyThread("Great,great","How about You?",obj);
        new MyThread("Well,Mate","The Country men!Coders",obj);
    }
}
