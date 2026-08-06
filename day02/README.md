# Day 2（8.6）运算符 + 分支结构 + switch

## 今天学了什么

1. **算术运算符**
   - `+` 加、`-` 减、`*` 乘、`/` 除、`%` 取余（模）
   - 整数除法结果会**截断小数**（如 `7 / 2 = 3`），`%` 取余数（如 `7 % 2 = 1`）
   - ⚠️ 除数为 0 会报错崩溃（`ArithmeticException`），代码里要提前判断

2. **if / else if 分支**
   - 成绩等级：`>=90` 优秀、`>=60` 合格、否则不及格
   - 先判断非法输入（`<0` 或 `>100`）再分级

3. **switch 多分支选择**
   - 简易菜单：1=打印、2=保存、3=退出
   - `default` 处理不在 case 里的输入
   - 每个 `case` 结尾记得 `break`，否则会"穿透"继续执行下一个 case

4. **逻辑运算符**
   - `&&`（与）、`||`（或）
   - 闰年判断：`(year % 4 == 0 && year % 100 != 0) || year % 400 == 0`

5. **面向对象初体验**：把运算封装成 `Calculator` 类、成绩判断封装成 `ScorePrinter` 类

## 代码

- `src/com/liang/test2/TestDemo2.java` —— 今天的练习代码（包含 Calculator、ScorePrinter 两个辅助类）

## 运行方式

IDEA 中直接打开 `TestDemo2.java`，点击 `main` 方法左边的绿色三角运行。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test2/TestDemo2.java
java -cp src com.liang.test2.TestDemo2
```
