package Lesson5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }


    public static void firstMethod(){
        int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime + " ms."));
    }



    public static void secondMethod() throws InterruptedException {
        int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        long startTime = System.currentTimeMillis();

        //Создаем 2 массива из исходного
        float[] arr1 = new float[size/2];
        float[] arr2 = new float[size/2];
        System.arraycopy(arr, 0, arr1, 0, size/2);
        System.arraycopy(arr, size/2, arr2, 0, size/2);


        //Передаем новые массивы в разные потоки
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
                }
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + size/2) /5) * Math.cos(0.2f + (i + size/2) /5) * Math.cos(0.4f + (i + size/2) /2));
                }
            }
        });

//      Запускаем потоки на расчет
        t1.start();
        t2.start();
        t1.join();
        t2.join();

//      Склеиваем массивы обратно в один
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, size/2, arr2.length);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime + " ms."));
    }

}
