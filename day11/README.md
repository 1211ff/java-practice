# Day 11（8.15）IO 流入门：File 类 + 字节流

## 今天学了什么

1. **File 类：文件和文件夹的"名片"**
   - **File 对象只是路径的抽象，不代表真实存在**——`exists()` 才知道它存不存在
   - 创建目录用 `mkdirs()`（自动创建所有不存在的父目录，推荐），`createNewFile()` 只能建文件
   - 判断三件套：`isFile()` / `isDirectory()` / `exists()`
   - 遍历目录：`listFiles()` 返回 File 对象数组（比 `list()` 返回字符串数组更常用）
   - 常用属性：`getName()` / `getAbsolutePath()` / `length()`（字节数）
   - ⚠️ **坑：不要对"文件"调用 mkdirs/listFiles**——一个路径要么是文件要么是目录，不能既是又立（昨天代码里就踩了这个）

2. **FileInputStream：文件字节输入流（读）**
   - 构造：`new FileInputStream(File/String)`，文件不存在抛 `FileNotFoundException`
   - `read(byte[] b)` 批量读取，返回**本次实际读到的字节数**，读到末尾返回 `-1`
   - ⚠️ **坑：`new String(buffer)` 会把整个数组转字符串**（含残留脏字节），必须用 `new String(buffer, 0, len)` 只取本次读到的部分

3. **FileOutputStream：文件字节输出流（写）**
   - 构造：`new FileOutputStream(File)` **覆盖写入**；第二个参数 `true` 是追加
   - 文件不存在**自动创建**，但上级文件夹不存在会报错
   - ⚠️ **坑：`write(buffer)` 会把整个数组写进去，必须用 `write(buffer, 0, len)` 读多少写多少**

4. **复制文件的正确姿势（重点纠正）**
   - ❌ 错误：字节 → 字符串拼接 → 再转回字节。`new String(bytes)` 会按编码解码，非文本文件（图片/视频）**直接损坏**，文本也可能因为编码不一致乱码
   - ✅ 正确：`read(buffer)` + `write(buffer, 0, len)` 字节**原样搬运**，不管什么文件都安全

5. **try-with-resources：自动关流**
   - `try (FileInputStream fis = new FileInputStream(...)) { ... }`
   - 括号里声明的资源，**代码块结束自动 close()**，不用手动关，也不用 finally
   - 多个资源写在一个 try 里：`try (A; B) { ... }`（复制文件就这么干）
   - 好处：万一中间抛异常，流也能被关闭——手动 close 做不到这一点

6. **编码问题**
   - 写中文要指定编码：`getBytes(StandardCharsets.UTF_8)` 和 `new String(bytes, 0, len, StandardCharsets.UTF_8)`
   - 不指定会走系统默认编码，换台电脑可能就乱码了

7. **路径统一用相对路径**
   - 昨天代码里绝对路径（`C:\Users\...`）和相对路径（`day11/test/...`）混用
   - 换电脑/换目录绝对路径就废了；相对路径只要基准（项目根）对就行——IDEA 运行工作目录默认就是项目根，所以用相对路径最稳

## 代码

- `src/com/liang/test11/TestDemo11.java` —— 4 个演示：File 类基本操作、写入（输出流）、读取（输入流）、复制文件（字节原样搬运）
- `test.txt` —— File 类 + 字节流常用 API 笔记（自学的，继续积累）
- `test/hello.txt` / `test/hellocopy.txt` —— 运行生成的演示文件

## 运行方式

IDEA 中直接打开 `TestDemo11.java`，点击 `main` 方法左边的绿色三角运行（工作目录是项目根，相对路径生效）。
命令行运行（需在项目根目录）：

```bash
javac -encoding UTF-8 src/com/liang/test11/*.java
java -cp src com.liang.test11.TestDemo11
```
