package com.example.layoutscodelab.MultithreadedLearning;

//生产者消费者模型--》利用缓冲区解决：管程法
//生产者，消费者，产品，缓冲区
public class TestPC {
    public static void main(String[] args) {
        SyncContainer syncContainer = new SyncContainer();
        Producer producer = new Producer(syncContainer);
        Consumer consumer = new Consumer(syncContainer);
        producer.start();
        consumer.start();
    }
}

//生产者
class Producer extends Thread {
    private final SyncContainer container;

    public Producer(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + i + "只chicken");
            container.put(new Chicken(i));
        }
    }
}

//消费者
class Consumer extends Thread {
    private final SyncContainer container;

    public Consumer(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费--》" + container.pop().id + "只chicken");
        }
    }
}

//产品
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SyncContainer {
    //缓冲区大小
    Chicken[] chickens = new Chicken[10];
    //缓冲区计数器
    int count = 0;

    //生产者放入产品
    public synchronized void put(Chicken chicken) {
        //如果缓冲区满了，就需要等待消费者取走产品，否则放入产品
        if (count == chickens.length) {
            //通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        chickens[count++] = chicken;
        //通知消费者可以消费了
        this.notifyAll();
    }

    //消费者取出产品
    public synchronized Chicken pop() {
        //判断能否消费
        if (count == 0) {
            //等待生产者生产，消费等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        Chicken chicken = chickens[--count];

        //通知生产者消费
        this.notifyAll();

        return chicken;
    }

}
