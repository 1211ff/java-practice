package com.liang.test12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Day12 字符流 + 缓冲流
 * FileReader / FileWriter：按字符读写，专门处理中文等文本
 * BufferedReader / BufferedWriter：包在字符流外层，提供按行读写
 */
public class TestDemo12 {

    /** 路径基准：IDEA 运行工作目录 = 项目根目录（day12 的上一级） */
    private static final String POEM_FILE = "day12/test.txt";
    private static final String SCORE_FILE = "day12/test1.txt";

    public static void main(String[] args) {
        System.out.println("===== 1. 字符流写入：静夜思 =====");
        writePoem();
        System.out.println("===== 2. 字符流写入：学生成绩 =====");
        writeScores();
        System.out.println("===== 3. 缓冲流按行读取 =====");
        readFile(POEM_FILE);
        System.out.println("===== 4. 读取成绩并统计 =====");
        List<Integer> scores = readScores();

        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        System.out.println("学生人数：" + scores.size());
        System.out.println("总分为：" + sum);
        System.out.printf("平均分：%.2f\n", (double) sum / scores.size());
    }

    /** 写一首诗（FileWriter + BufferedWriter） */
    private static void writePoem() {
        // try-with-resources：无论成功失败都会自动 close，防止流泄漏
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(POEM_FILE))) {
            bw.write("静夜思");
            bw.newLine();   // 跨平台换行符，比直接写 "\n" 更规范
            bw.write("唐・李白");
            bw.newLine();
            bw.write("床前明月光，疑是地上霜。");
            bw.newLine();
            bw.write("举头望明月，低头思故乡。");
            System.out.println("写入完成");
        } catch (IOException e) {
            System.err.println("写入失败：" + e.getMessage());
        }
    }

    /** 写学生成绩 CSV（姓名,分数） */
    private static void writeScores() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SCORE_FILE))) {
            bw.write("张三,85");
            bw.newLine();
            bw.write("李四,92");
            bw.newLine();
            bw.write("王五,78");
            bw.newLine();
            bw.write("赵六,96");
            bw.newLine();
            bw.write("钱七,88");
            bw.newLine();
            bw.write("孙八,80");
            System.out.println("写入完成");
        } catch (IOException e) {
            System.err.println("写入失败：" + e.getMessage());
        }
    }

    /** 按行读取文本文件并打印 */
    private static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            // readLine() 读到文件末尾返回 null
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("读取失败：" + e.getMessage());
        }
    }

    /** 读取成绩文件，返回所有分数（int 列表） */
    private static List<Integer> readScores() {
        List<Integer> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // 防御：如果某行没有逗号，跳过它，避免数组越界崩溃
                if (parts.length < 2) {
                    continue;
                }
                scores.add(Integer.parseInt(parts[1].trim()));
            }
        } catch (IOException e) {
            System.err.println("读取成绩失败：" + e.getMessage());
        }
        return scores;
    }
}
