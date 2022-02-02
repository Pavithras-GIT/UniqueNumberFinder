package com.example.demo;

public class UniqueNumberRequest {

    private int [] array;
    private int sum;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public UniqueNumberRequest(int[] array, int sum) {
        this.array = array;
        this.sum = sum;
    }
}
