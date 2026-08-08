# Day 5（8.9）方法：参数 / 返回值 / 递归 / 数组平均分

## 今天学了什么

1. **方法封装**
   - 把一段逻辑抽成方法：`方法名(参数)` 传入数据，`return` 返回结果
   - 静态方法（`static`）可以直接在 main 里调用；实例方法（如 `factorial.fact(n)`）需要先 new 对象

2. **参数校验**
   - 非法输入要在方法入口就拦截：负数抛异常、空数组抛异常
   - `IllegalArgumentException`：参数非法时专用的异常类型

3. **递归**
   - 自己调用自己，两个要素缺一不可：
     - **终止条件**：`n <= 1` 时返回 1（注意 **0! = 1**，这是最容易踩的坑）
     - **递归公式**：`n! = n * (n-1)!`
   - `long` 最大支持 20!，21! 会溢出

4. **整数除法陷阱**
   - `sum / arr.length` 是整数除法，小数直接丢掉
   - 要写成 `(double) sum / arr.length`，先转 double 再除

## 代码

- `src/com/liang/test5/TestDemo5.java` —— main 入口：阶乘 + 平均分
- `src/com/liang/test5/Factorial.java` —— 递归阶乘（含参数校验）

## 运行方式

IDEA 中直接打开 `TestDemo5.java`，点击 `main` 方法左边的绿色三角运行。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test5/*.java
java -cp src com.liang.test5.TestDemo5
```
