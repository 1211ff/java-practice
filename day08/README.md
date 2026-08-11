# Day 8（8.11）异常体系 + try-catch-finally

## 今天学了什么

1. **什么是异常**
   - 程序运行时出的"意外状况"：数组越界、除数为 0、空指针、输入类型不匹配……
   - 异常也是个对象，Java 把它归到 `Throwable` 体系下：`Exception`（可处理）和 `Error`（严重错误，一般不管）

2. **try-catch-finally 执行顺序（重点！）**
   - 顺序是：`try` → `catch` → `finally`
   - `try`：放可能出错的代码
   - `catch`：出错后跳到这里处理；**没出错就不执行 catch**
   - `finally`：无论有没有异常**都会执行**，在 try/catch 之后
   - 常见误区：以为 finally 在 catch 之前（注释写反了😄）

3. **catch 要捕获具体的异常类型**
   - `catch (ArrayIndexOutOfBoundsException e)`、`catch (ArithmeticException e)` 比 `catch (Exception e)` 更精准
   - 多 catch 可以从上往下依次匹配（子类在前）

4. **怎么从异常对象里拿信息**
   - `e.getMessage()` —— 只拿错误描述（如 `/ by zero`）
   - `e.toString()` / 直接打印 `e` —— 异常类型 + 错误描述
   - `e.printStackTrace()` —— 完整错误栈，能看到异常发生在哪一行（真实开发最常用）

5. **catch 里不要"吞掉"异常**
   - `catch (Exception e) { throw new RuntimeException(...); }` 会把原始异常信息丢掉，程序还会崩
   - 真想包装再抛，要带上原始异常：`throw new RuntimeException("xxx", e);`
   - 初学者演示：先学会"接住 + 打印"，让程序继续跑

6. **finally 在 return 之前执行（面试经典题）**
   - try 里有 `return`，finally 照样执行，而且先于 return

7. **踩坑提醒**
   - `int result = 10 / 0;` 编译直接报错（常量除零）——得用变量 `a / b` 才在运行期抛异常

## 代码

- `src/com/liang/test8/TestDemo8.java` —— 三个演示：基本 try-catch-finally、异常信息获取、finally 与 return 的顺序

## 运行方式

IDEA 中直接打开 `TestDemo8.java`，点击 `main` 方法左边的绿色三角运行。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test8/TestDemo8.java
java -cp src com.liang.test8.TestDemo8
```
