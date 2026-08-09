# Day 6（8.10）面向对象：封装 / 继承 / 多态

## 今天学了什么

1. **封装**
   - 字段都用 `private` 私有化，外部通过 `getXxx()` / `setXxx()` 访问
   - 构造器重载：无参构造 + 全参构造，用 `this.xxx = xxx` 区分同名参数

2. **继承（extends）**
   - `class Dog extends Animals`：子类拥有父类所有非私有成员
   - 子类构造器第一行必须调用父类构造器：`super(name, age, sex)`
   - 子类可以直接调用父类的方法（如 `getSay()`）

3. **方法重写（@Override）**
   - 子类重写父类方法，方法签名必须完全一致
   - 重写后可以用 `super.show()` 在子类方法里调用父类版本

4. **多态（向上转型）**
   - `Animals dog = new Dog()`：父类引用指向子类对象
   - 编译看左边（只能调 Animals 里有的方法），运行看右边（动态绑定，调 Dog 重写后的方法）
   - 向上转型的引用**调不了子类独有方法**（如 `eat()`）

5. **向下转型（强制类型转换）**
   - `Dog dog2 = (Dog) dog`：把父类引用强制转回子类，才能调子类独有方法
   - 转型前用 `dog instanceof Dog` 判断真实类型，避免 ClassCastException

6. **重写 toString()**
   - `println(student)` 会自动调用 `toString()`，把对象信息拼成字符串打印
   - IDEA 快捷键：右键 → Generate → toString()

7. **字段隐藏（踩坑）**
   - 子类声明和父类**同名字段**会"遮蔽"父类字段（如 `say`），两个值互不相干
   - 正确做法：子类不要重复声明，直接用父类的 getter

## 代码

- `src/com/liang/test6/TestDemo6.java` —— main 入口：封装、继承、多态、向上/向下转型、instanceof
- `src/com/liang/test6/Animals.java` —— 父类：name / age / sex + show()
- `src/com/liang/test6/Dog.java` —— 继承 Animals，重写 show()，独有 eat()
- `src/com/liang/test6/Person.java` —— 父类：name / age + say 字段
- `src/com/liang/test6/Teacher.java` —— 继承 Person，独有 salary
- `src/com/liang/test6/Student.java` —— 封装 + 数组分数 + getTotalScore() + toString()

## 运行方式

IDEA 中直接打开 `TestDemo6.java`，点击 `main` 方法左边的绿色三角运行。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test6/*.java
java -cp src com.liang.test6.TestDemo6
```
