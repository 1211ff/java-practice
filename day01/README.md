# Day 1（8.5）变量 + 数据类型 + Scanner 输入

## 今天学了什么

1. **8 种基本数据类型及其占用空间**
   - `byte` 1B | `short` 2B | `int` 4B | `long` 8B
   - `float` 4B | `double` 8B | `char` 2B | `boolean`（JVM 中一般按 1B 处理）
   - 注意：`String` 是**引用类型**，不是基本数据类型

2. **键盘输入**：`Scanner` 的使用（`nextInt()` 读取整数）

3. **类型转换**
   - 小范围 → 大范围：**自动转换**（隐式），如 `int` → `double`
   - 大范围 → 小范围：**必须强转**（显式），如 `double` → `int`，会丢失精度（小数部分被截断）

## 代码

- `src/com/liang/test1/TestDemo1.java` —— 今天的练习代码

## 运行方式

IDEA 中直接打开 `TestDemo1.java`，点击 `main` 方法左边的绿色三角运行。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test1/TestDemo1.java
java -cp src com.liang.test1.TestDemo1
```
