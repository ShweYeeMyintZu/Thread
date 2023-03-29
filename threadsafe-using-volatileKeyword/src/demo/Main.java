package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyComputer myComputer=new MyComputer();
        myComputer.start();
//        System.out.println("Press any key to stop");
        Scanner sc=new Scanner(System.in);
        sc.next();
        myComputer.stopRunning();
    }
}