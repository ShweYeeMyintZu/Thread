package demo;
//not thread safe but use of synchronized become thread safe
public class Main {
    public static void main(String[] args) {
        new MyThread("Hello","How is Your Day?");
        new MyThread("Great,great","How about You?");
        new MyThread("Well,Mate","The Country men!Coders");
    }
}
