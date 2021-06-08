package com.example.layoutscodelab.MultithreadedLearning;


import java.util.concurrent.locks.LockSupport;

public class Test {

    public static void main(String[] args) {

//        ARunnable aRunnable = new ARunnable();
//        Thread thread = new Thread(aRunnable);
//        thread.setDaemon(true);
////        aRunnable.unparkThread = Thread.currentThread();
//
//        thread.start();
        //阻塞自己
//        LockSupport.park();
//        System.out.println(2);
        //xXXXX
        //xXXXX


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(111);
                }
            }
        }).start();
    }

    static class ARunnable implements Runnable {
//        public Thread unparkThread;

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true){
                //xXXXX
                System.out.println(1);
//            LockSupport.unpark(unparkThread);
//            //xXXXX
                System.out.println(3);
            }
        }
    }
}
