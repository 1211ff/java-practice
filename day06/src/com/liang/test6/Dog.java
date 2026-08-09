package com.liang.test6;

public class Dog extends Animals {

    public Dog() {
    }

    public Dog(String name, int age, String sex) {
        super(name, age, sex);
    }

    @Override
    public void show() {
        System.out.println("这是狗的类");
        super.show();
    }

    public void eat() {
        System.out.println("我吃骨头");
    }
}
