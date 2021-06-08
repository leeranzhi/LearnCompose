package com.example.layoutscodelab.MultithreadedLearning;

public class Race implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            if(Thread.currentThread().getName().equals("兔子")&&i%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (isGameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--》跑了" + i + "步");
        }
    }

    private static String winner;

    private boolean isGameOver(int steps) {
        if (winner != null) {
            return true;
        }
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
