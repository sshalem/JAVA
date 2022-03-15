package demo;

class MyThread implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " is running");
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Finished running");
    }
}

class MyCalculate implements Runnable {

    MyThread myThread = new MyThread();

    private void printMessage(String msg) {
        System.out.println(Thread.currentThread().getName() + msg);
    }

    @Override
    public void run() {
        printMessage(" is running");
        try {
            Thread thread = new Thread(myThread, "MyThread-run");
            thread.start();
            printMessage(" invoked MyThread");
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printMessage(" Finished Running");
    }
}

public class _8_Join {
    public static void main(String[] args) {

        MyCalculate myCalc = new MyCalculate();
        Thread tCalc = new Thread(myCalc, "Calculate-thread");

        tCalc.start();
    }
}