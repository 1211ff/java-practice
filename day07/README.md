# Day 7（8.10）学生成绩登记 v0.1

## 今天学了什么

1. **增强 for 循环**
   - `for (int j : score)` 遍历数组，不需要下标，简洁安全
   - 适合只读不修改的场景；需要下标时还得用传统 `for i`

2. **BigDecimal 精确计算（避开 double 的坑）**
   - double 在内存里是二进制存储，`71.2` 实际是 `71.1999999999999957...`
   - 金额、平均分这类要精确的场景，用 `BigDecimal`
   - 正确姿势：`new BigDecimal(sumScore).divide(BigDecimal.valueOf(score.length), 2, RoundingMode.HALF_UP)`
   - `divide` 三个参数：被除数对象、保留位数、舍入方式（HALF_UP = 四舍五入）

3. **整数除法陷阱（又踩了一次）**
   - `sumScore / score.length` 两个 int 相除，结果还是 int，小数直接丢掉
   - 转 double 再除，或用 BigDecimal 全程运算

4. **Random 随机数**
   - `random.nextInt(100) + 1` → 生成 1~100 的随机整数
   - 注意 `nextInt(100)` 是 0~99，`+1` 才是 1~100

5. **对象数组隔离**
   - 三个学生不能共用一个 `int[] score`，否则改一个全变
   - 每个对象自己 `new int[5]`，互不干扰（引用类型指向各自的堆内存）

6. **构造器带参创建**
   - `new Student("小明", 5)`：构造器里直接初始化 name 和数组，比 `setXxx()` 更简洁
   - 方法职责单一：生成成绩、算总分、算平均分、打印各管各的

## 代码

- `src/com/liang/test7/Student.java` —— 学生类：name / score 封装，createRandomScore() / sumScore() / aveScore()
- `src/com/liang/test7/TestDemo7.java` —— main 入口：创建 3 个学生，随机成绩 + 打印总分平均分

## 运行方式

IDEA 中直接打开 `TestDemo7.java`，点击 `main` 方法左边的绿色三角运行。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test7/*.java
java -cp src com.liang.test7.TestDemo7
```
