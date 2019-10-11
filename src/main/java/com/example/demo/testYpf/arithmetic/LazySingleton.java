package com.example.demo.testYpf.arithmetic;

public class LazySingleton {
    private static volatile  LazySingleton lazySingleton;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getLazySingleton(){
        if (lazySingleton == null){
            lazySingleton =  new LazySingleton();
        }
        return lazySingleton;
    }
}
