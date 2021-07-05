package com.example.layoutscodelab.testhashcode;

public class TestJavaHashCode {

    public static void test111() {
        int code = 0;
        for (int i = 0; i < 5; i++) {

            int newCode = ((Runnable) () -> {

            }).hashCode();

            newCode = ((Runnable) () -> {

            }).hashCode();

            int newCodeqq = ((Runnable) () -> {

            }).hashCode();

            int newCode2 = (new Runnable() {
                @Override
                public void run() {

                }
            }).hashCode();

            int newCode3 = ((Runnable) () -> {
                System.out.println(code);
            }).hashCode();

            int newCode4=(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).hashCode();

            int newCode5=((Runnable) () -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).hashCode();

            System.out.println(newCode);
            System.out.println(newCode2);
            System.out.println(newCode3);
            System.out.println(newCode4);
            System.out.println(newCode5);
            System.out.println(newCodeqq);
        }
    }

    public static void main(String[] args) {
        test111();
    }
}
