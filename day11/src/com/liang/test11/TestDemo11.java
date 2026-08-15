package com.liang.test11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Day 11 练习：File 类 + 字节流（FileInputStream / FileOutputStream）
 *
 * 演示路线：
 *   1. File 类：目录创建、文件创建、判断、遍历
 *   2. 字节输出流：往文件写内容
 *   3. 字节输入流：把内容读回来
 *   4. 字节流复制文件：字节原样搬运（不经过 String，避免乱码/损坏数据）
 *
 * 注意：路径统一使用相对路径，基准是项目根目录（IDEA 中直接运行即可，
 *       IDEA 的运行工作目录默认就是项目根目录）。
 */
public class TestDemo11 {

    /** 演示目录：项目根目录下的 day11/test */
    private static final String DIR = "day11" + File.separator + "test";
    /** 源文件 */
    private static final File SRC_FILE = new File(DIR, "hello.txt");
    /** 复制目标文件 */
    private static final File DEST_FILE = new File(DIR, "hellocopy.txt");

    public static void main(String[] args) {
        // ===== 1. File 类基本操作 =====
        fileDemo();

        // ===== 2. 写入文件（字节输出流）=====
        writeDemo();

        // ===== 3. 读取文件（字节输入流）=====
        readDemo();

        // ===== 4. 复制文件（字节流）=====
        copyDemo();
    }

    /** 1. File 类：目录创建、文件创建、判断、遍历 */
    private static void fileDemo() {
        System.out.println("===== 1. File 类基本操作 =====");

        // ① 创建多级目录：mkdirs() 会自动创建所有不存在的父目录，推荐使用
        File dir = new File(DIR);
        System.out.println("创建目录 day11/test：" + dir.mkdirs());
        System.out.println("是否文件夹：" + dir.isDirectory());

        // ② 创建文件：createNewFile() 只能创建文件，不能创建目录
        //    文件已存在时返回 false，且不会报错
        try {
            System.out.println("创建文件 hello.txt：" + SRC_FILE.createNewFile());
        } catch (IOException e) {
            System.out.println("创建文件失败：" + e.getMessage());
        }
        System.out.println("是否文件：" + SRC_FILE.isFile());
        System.out.println("文件是否存在：" + SRC_FILE.exists());
        System.out.println("文件名：" + SRC_FILE.getName());
        System.out.println("绝对路径：" + SRC_FILE.getAbsolutePath());

        // ③ 遍历目录：listFiles() 返回 File 对象数组（比 list() 更常用）
        File[] files = dir.listFiles();
        if (files != null) {
            System.out.print("day11/test 下的文件：");
            for (File f : files) {
                System.out.print(f.getName() + "  ");
            }
            System.out.println();
        }
    }

    /** 2. 字节输出流：把内容写入 hello.txt */
    private static void writeDemo() {
        System.out.println("===== 2. 写入文件（FileOutputStream）=====");

        // 也可以改成从键盘输入，这里为了演示清晰直接给默认内容
        System.out.print("请输入要写入的内容（直接回车用默认内容）：");
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine().trim();
        sc.close();
        if (content.isEmpty()) {
            content = "Hello, Java IO! 你好，字节流！";
            System.out.println("未输入，使用默认内容");
        }

        // try-with-resources：try(资源) 结束自动 close，不用手动关流
        try (FileOutputStream fos = new FileOutputStream(SRC_FILE)) {
            // 指定 UTF-8 编码，避免中文乱码
            fos.write(content.getBytes(StandardCharsets.UTF_8));
            System.out.println("写入成功：" + content);
        } catch (IOException e) {
            System.out.println("写入失败：" + e.getMessage());
        }
    }

    /** 3. 字节输入流：把 hello.txt 的内容读出来 */
    private static void readDemo() {
        System.out.println("===== 3. 读取文件（FileInputStream）=====");

        try (FileInputStream fis = new FileInputStream(SRC_FILE)) {
            byte[] buffer = new byte[1024];
            int len;
            // 每次读一批字节到数组，len 是本次实际读到的字节数；读到末尾返回 -1
            // 注意：必须用 new String(buffer, 0, len)，而不是 new String(buffer)
            //       否则会把数组里上次残留的脏字节也一起打印出来
            while ((len = fis.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len, StandardCharsets.UTF_8));
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("读取失败：" + e.getMessage());
        }
    }

    /** 4. 复制文件：字节原样搬运，不经过 String 转换 */
    private static void copyDemo() {
        System.out.println("===== 4. 复制文件（字节流）=====");

        // 输入流 + 输出流可以写在一个 try 里，一起自动关闭
        try (FileInputStream fis = new FileInputStream(SRC_FILE);
             FileOutputStream fos = new FileOutputStream(DEST_FILE)) {

            byte[] buffer = new byte[1024];
            int len;
            // 核心：读多少就写多少 -> write(buffer, 0, len)
            // 绝对不能用 write(buffer)：它会把整个 1024 字节的数组全写进去（含残留脏数据）
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("复制完成：" + SRC_FILE.getName() + " → " + DEST_FILE.getName());
        } catch (IOException e) {
            System.out.println("复制失败：" + e.getMessage());
        }

        // 验证：两个文件大小应该一致
        if (SRC_FILE.length() == DEST_FILE.length()) {
            System.out.println("验证通过：两个文件大小一致（" + SRC_FILE.length() + " 字节）");
        } else {
            System.out.println("验证失败：文件大小不一致");
        }
    }
}
