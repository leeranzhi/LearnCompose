package com.example.layoutscodelab;

public class LibLoad {

    public static native String getLocalKey();


    static {
        System.loadLibrary("libKey.so");
    }
}
