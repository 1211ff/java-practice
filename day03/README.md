# Day 3（8.7）循环：for / while / 嵌套循环

## 今天学了什么

1. **for 循环**：`for (int i = 1; i <= 100; i++)`，知道循环三要素（初始化、条件、步进）
2. **while 循环**：猜数字游戏里用 `while(true)` + `break` 实现"猜到为止"
3. **嵌套循环**：99 乘法表，外层控制行、内层控制列（`j <= i` 输出左下三角）
4. **Random 随机数**：`new Random().nextInt(100) + 1` 生成 1-100 的随机数
5. **ArrayList 集合**：存质数列表，再统一遍历输出
6. **多类协作**：一个程序拆成 4 个类（求和/猜数字/乘法表/质数），`main` 里调用
7. **质数判断优化**：只需除到 `sqrt(n)`，发现能整除立即返回，比统计约数个数快

## 代码

```
src/com/liang/test3/
├── TestDemo3.java          main 入口，调用下面 4 个类
├── SumCalculator.java      1-100 偶数之和 / 奇数之和
├── GuessGame.java          猜数字游戏（Random + while + break）
├── MultiplicationTable.java  99 乘法表（嵌套 for）
└── PrimePrinter.java       0-100 质数（ArrayList + 优化判断）
```

## 运行方式

IDEA 中打开 `TestDemo3.java`，点击 `main` 方法左边的绿色三角运行。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test3/*.java
java -cp src com.liang.test3.TestDemo3
```

## 踩坑记录

- 建包时手滑建成了 `com.liang.test4`，已修正为 `com.liang.test3`，与 day01/day02 的命名保持一致
- `javax.swing` 没用到，已移除（没用的 import 会拖累编译速度）
