package com.example.layoutscodelab.MultithreadedLearning;

//生产者消费者模型--》信号灯法，标志位
public class TestPC2 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Actor(tv).start();
        new Audience(tv).start();
    }
}

//生产者-》演员
class Actor extends Thread {
    Tv tv;

    public Actor(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                tv.play("综艺节目");
            } else {
                tv.play("抖音");
            }
        }
    }
}

//消费者-》观众
class Audience extends Thread {
    Tv tv;

    public Audience(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品-》节目
class Tv {
    //演员表演，观众等待 T
    //观众观看，演员等待 F
    String voice; //表演的节目
    boolean isPlayReady = true;

    public synchronized void play(String voice) {
        if (!isPlayReady) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("演员表演了" + voice);
        //通知观众观看
        this.notifyAll();//通知唤醒

        this.voice = voice;
        this.isPlayReady = !this.isPlayReady;
    }

    public synchronized void watch() {
        if (isPlayReady) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了" + voice);
        //通知演员表演
        this.notifyAll();
        this.isPlayReady = !this.isPlayReady;
    }
}
