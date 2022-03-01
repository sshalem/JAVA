package demo;

import java.time.LocalTime;

class MyRunnableThread implements Runnable {
    @Override
    public void run() {

        long startTime = LocalTime.now().toSecondOfDay();

        try {
            Thread.sleep(2000);
            System.out.println(" ---> Thread Name : " + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = LocalTime.now().toSecondOfDay();
        long time = endTime - startTime;

        System.out.println("Thread Sleep " + time + " sec");
        System.out.println("Thread " + Thread.currentThread().getName() + " Execution is finished");
    }
}

public class _4_Sleep {
    public static void main(String[] args) {

        MyRunnableThread myRunnable = new MyRunnableThread();

        Thread t1 = new Thread(myRunnable, "<first>");

        // activate the Trace
        t1.start();

        System.out.println("Main Thread is finished : " + Thread.currentThread().getName());
    }
}
