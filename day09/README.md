# Day 9（8.13）自定义异常 + throw/throws

## 今天学了什么

1. **什么是自定义异常**
   - 系统自带的异常不够用时，自己写一个异常类：继承 `RuntimeException` 或 `Exception` 即可
   - 自定义异常 = 一个类 + 几个构造器（无参、带 message、带 message+cause），够用了

2. **运行时异常 vs 受检异常（重点！）**
   - 继承 `RuntimeException` → 运行时异常：**编译不报错**，运行到 `throw` 才抛出，不强制处理
   - 继承 `Exception` → 受检异常：**编译期强制处理**，调用方必须 `try-catch` 或 `throws`，否则编译不过
   - 练习里：`ScoreException` / `AgeException` 继承 RuntimeException；`UnderAgeException` 继承 Exception，两者对比着看区别

3. **throw 和 throws 的区别（面试常考）**
   - `throw`：**在方法体内**主动抛出异常对象，如 `throw new ScoreException("...")`
   - `throws`：**在方法声明处**告知调用方"我可能抛什么异常"，如 `void register(...) throws UnderAgeException`
   - 一句话：throw 是"扔"，throws 是"声明会扔"

4. **业务错误码的设计**
   - 异常对象里可以带 `code` 字段，调用方根据 code 做不同处理
   - 错误码要有语义：400 = 客户端参数错误（HTTP 风格），500 = 服务端错误；**404 是"资源未找到"，别拿来当参数错误用**
   - 第一次写成了 404，注释写 000，代码写 404，三者不一致 —— 已统一为 400

5. **输入校验重试的标准姿势**
   - `while(true) { try { 输入; 校验; break; } catch (异常) { 提示重输; } }` —— 合法才 break 退出
   - 校验逻辑封装成 `checkScore(int)` / `checkAge(int)` 方法，`throw` 放在方法里，main 只负责 try-catch

6. **踩坑：Scanner 输入字母会崩（InputMismatchException）**
   - `sc.nextInt()` 遇到字母抛 `InputMismatchException`，它不是你的自定义异常，**单独 catch 处理**，否则程序直接崩
   - catch 里要 `sc.nextLine()` 清掉残留的非法输入，否则会无限循环
   - 这个坑演示1、演示2 都踩了，已补上处理

## 代码

- `src/com/liang/test9/AgeException.java` —— 带业务错误码（400）的运行时异常
- `src/com/liang/test9/ScoreException.java` —— 不带错误码的运行时异常（对比用）
- `src/com/liang/test9/UnderAgeException.java` —— 受检异常（继承 Exception），演示 throws
- `src/com/liang/test9/TestDemo9.java` —— 三个演示：分数校验重试、年龄校验重试（带错误码）、受检异常注册

## 运行方式

IDEA 中直接打开 `TestDemo9.java`，点击 `main` 方法左边的绿色三角运行（程序会等键盘输入，在控制台输入分数/年龄即可）。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test9/*.java
java -cp src com.liang.test9.TestDemo9
```

输入几个非法值试试：分数输 `101`、字母 `abc`、年龄输 `200`，看异常怎么被接住。
