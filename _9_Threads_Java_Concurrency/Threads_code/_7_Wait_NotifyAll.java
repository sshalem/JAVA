package demo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

class HospitalRunnable implements Runnable {

    public int nextInLine = 1;

    private Queue<Integer> numberInLine;

    public HospitalRunnable() {
        this.numberInLine = new ArrayDeque<Integer>();
        for (int i = 1; i <= 100; i++) {
            this.numberInLine.add(i);
        }
    }

    private synchronized void doDoctortest(int currentPatientNumber, String patientNumber) throws InterruptedException {
        while (currentPatientNumber != nextInLine) {
            print(" at Doctor : " + patientNumber + "--> waiting");
            wait();
        }
        print(" at Doctor : " + patientNumber + ", finished ");
        nextInLine++;
        notifyAll();
    }

    private void bloodCheck() throws InterruptedException {

        Integer patientNumber = numberInLine.remove();
        print("at blood Check patient: " + patientNumber);

        Random random = new Random();
        int sleepTime = random.nextInt(3000);

        Thread.sleep(sleepTime);

        print("Finished Blood Checked, patient :" + patientNumber);

        doDoctortest(patientNumber, "patient number : " + patientNumber);

    }

    private void print(String message) {
        System.out.println(message);
    }

    @Override
    public void run() {
        try {
            bloodCheck();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class _7_Wait_NotifyAll {
    public static void main(String[] args) {

        HospitalRunnable hospitalRunnable = new HospitalRunnable();

        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(hospitalRunnable);
            thread.start();
        }
    }
}