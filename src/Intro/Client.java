package Intro;

public class Client {
    public static void doStuff(){
        System.out.println("Function called from mainmethod executed by: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Print executed by: " + Thread.currentThread().getName());
        doStuff();
    }
}
