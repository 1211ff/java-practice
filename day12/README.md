# Day 12（8.17）字符流 + 缓冲流

## 今天学了什么

1. **字符流 vs 字节流（Day11 的升级）**
   - 字节流（FileInputStream/FileOutputStream）：一次读**一个字节**，啥文件都能处理（图片/视频/文本）
   - 字符流（FileReader/FileWriter）：一次读**一个字符**，专门处理文本——中文一个字符占多个字节，字符流不会读"半个字"乱码
   - 选型口诀：**文本用字符流，二进制用字节流**

2. **缓冲流：字符流的"加速器 + 增强包"**
   - `BufferedReader` / `BufferedWriter` 包在字符流外层（装饰器模式，先记住用法）
   - 两大好处：① 内部缓冲区减少底层读写次数，性能更好；② 多出便捷方法
   - **按行读取**：`readLine()` 一次读一行，读到末尾返回 `null`（这就是 while 循环能读完全部行的原因）
   - **按行写入**：`newLine()` 写一个**跨平台换行符**——比直接写 `"\n"` 规范（Windows 记事本对裸 `\n` 不换行）

3. **CSV 简单解析**（真实开发天天用）
   - 文件里存 `张三,85` 这种"逗号分隔"格式
   - 读取套路：`readLine()` 拿一行 → `split(",")` 拆开 → `Integer.parseInt(parts[1])` 转数字
   - ⚠️ **坑：`split` 后如果某行没有逗号，`parts[1]` 会数组越界**——解析前先判断 `parts.length`（防御性编程）

4. **try-with-resources 全面应用**
   - 昨天只用在复制文件，今天 4 个方法全用了：`try (BufferedReader br = new BufferedReader(new FileReader(path))) { ... }`
   - 括号里声明的流，**代码块结束自动 close()**，异常时也能关
   - ⚠️ **教训：昨天刚学的，今天 `readTest_txt` 又忘了 close**（流泄漏），这次全改成 try-with-resources 根治

5. **编码问题（FileReader/FileWriter 的坑）**
   - FileReader/FileWriter **不能指定编码**，用 JVM 平台默认编码
   - JDK 18 及以上默认 **UTF-8**（JEP 400），所以本机（JDK 21）不乱码
   - 但 JDK 17 及以下在 Windows 上默认是 **GBK**——换版本/换电脑就可能乱码
   - 要精确控制编码，改用字节流包装：`new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8)`

6. **平均分计算复习（Day7 的坑没再踩 👍）**
   - `(double) sum / scores.size()` 先转 double 再除，避免了整数除法把小数砍掉
   - `System.out.printf("平均分：%.2f\n", avg)` 保留两位小数

## 代码

- `src/com/liang/test12/TestDemo12.java` —— 4 个演示：写入静夜思（字符流）、写入成绩 CSV、按行读取、读取成绩统计总分/平均分
- `test.txt` / `test1.txt` —— 运行生成的文本文件（静夜思 / 学生成绩）

## 运行方式

IDEA 中直接打开 `TestDemo12.java`，点击 `main` 方法左边的绿色三角运行（工作目录是项目根，相对路径生效）。
命令行运行（需在项目根目录）：

```bash
javac -encoding UTF-8 src/com/liang/test12/*.java
java -cp src com.liang.test12.TestDemo12
```
