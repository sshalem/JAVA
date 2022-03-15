package demo;

class PrintIndexLoop implements Runnable {

    public synchronized void printIndex() {
        for (int i = 0; i < 5; i++) {
            System.out.print(Thread.currentThread().getName() + ":" + i + " ,");
        }
        System.out.println();
    }

    @Override
    public void run() {
        printIndex();
    }
}

public class _6_Synchronized {

    public static void main(String[] args) {

        PrintIndexLoop printIndexLoop = new PrintIndexLoop();

        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(printIndexLoop, "[th-" + i + "]");
            thread.start();
        }
    }
}