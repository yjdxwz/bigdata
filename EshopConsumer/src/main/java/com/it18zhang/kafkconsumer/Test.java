package com.it18zhang.kafkconsumer;
public  class Test{
    public Test(){
        String name="123";
        change(name);
        System.out.println(name);
    }
    public void change(String name){
        name ="abc";
    }
    public static void main(String[] args) {
        new Test();
    }
}
