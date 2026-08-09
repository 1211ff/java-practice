package com.liang.test6;

public class TestDemo6 {
    public static void main(String[] args) {
        // 1. 封装 + 构造器赋值 + toString 重写
        Student student = new Student("男", 18, "2026001", "小明", new int[]{88, 92, 76});
        System.out.println("总分：" + student.getTotalScore());
        System.out.println(student); // println 会自动调用重写后的 toString()

        // 2. 继承：子类直接使用父类的 say 字段（通过 getSay()）
        Teacher teacher = new Teacher("王老师", 35, 8000.0);
        teacher.say();

        // 3. 向上转型（多态）：父类引用指向子类对象，编译看左边，运行看右边
        Animals dog = new Dog("旺财", 3, "公");
        dog.show(); // 动态绑定：实际调用的是 Dog 重写后的 show()

        // 4. instanceof 判断真实类型，配合向下转型调用子类特有方法
        if (dog instanceof Dog) {
            Dog dog2 = (Dog) dog; // 向下转型：强制类型转换
            dog2.eat();           // eat() 是子类独有方法，父类引用调不了
        }
    }
}
