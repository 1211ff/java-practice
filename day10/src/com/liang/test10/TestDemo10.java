package com.liang.test10;

import java.util.*;

/**
 * Day10：集合框架综合练习
 * Collection（List / Set）+ Map + 泛型 + Lambda
 */
public class TestDemo10 {

    // 测试数据：故意带重复数字，方便观察去重效果
    private static final int[] REPEATED_ARR = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 4, 5, 6, 7, 3, 4, 5, 6, 7, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        System.out.println("===== 1. Map：统计字符出现次数 =====");
        wordCount("aaasssssdddddddfffffffff");

        System.out.println("\n===== 2. Set：去重三兄弟对比 =====");
        testSetDemo();

        System.out.println("\n===== 3. List：排序 =====");
        testSortDemo();

        System.out.println("\n===== 4. Map 遍历：entrySet / forEach =====");
        testMapForEach();
    }

    /**
     * 统计字符串中每个字符出现的次数（Map 经典应用）
     * getOrDefault：取不到 key 时返回默认值 0（Java8 高频方法）
     */
    private static void wordCount(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
    }

    /**
     * Set 三种实现对比：都能去重，但顺序规则不同
     * HashSet        —— 无序（哈希表，快）
     * LinkedHashSet  —— 保持插入顺序
     * TreeSet        —— 自然排序（升序）
     */
    private static void testSetDemo() {
        // 插入顺序故意打乱 + 带重复，方便观察三种 Set 的排序规则差异
        int[] arr = {5, 3, 9, 1, 7, 2, 8, 4, 6, 9, 3, 1, 5, 7};

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i : arr) {
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
        }

        System.out.println("HashSet        = " + hashSet);
        System.out.println("LinkedHashSet  = " + linkedHashSet);
        System.out.println("TreeSet        = " + treeSet);

        // TreeSet 独有：取最大 / 最小元素（method.txt 里记过，现在落地）
        System.out.println("TreeSet 最小元素 first() = " + treeSet.first());
        System.out.println("TreeSet 最大元素 last()  = " + treeSet.last());
    }

    /**
     * List 排序两种写法：
     * 1. list.sort(Lambda)        —— 自己写比较规则
     * 2. Collections.sort(list)   —— 默认升序（注释里提到的 API，现在演示）
     */
    private static void testSortDemo() {
        List<Integer> list = new ArrayList<>();
        for (int i : REPEATED_ARR) {
            list.add(i);
        }

        // 方式一：Lambda 降序（o2 - o1 表示"后面的比前面大"则换位 → 降序）
        list.sort((o1, o2) -> o2 - o1);
        System.out.println("Lambda 降序:       " + list);

        // 方式二：Collections.sort 升序
        Collections.sort(list);
        System.out.println("Collections.sort:  " + list);
    }

    /**
     * Map 遍历的两种主流写法（method.txt 里标了 entrySet 是遍历首选）
     */
    private static void testMapForEach() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 100);
        map.put("Python", 90);
        map.put("C++", 80);

        // 方式一：entrySet 拿到每一对键值
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("entrySet: " + entry.getKey() + " = " + entry.getValue());
        }

        // 方式二：forEach(BiConsumer)，Java8 Lambda 写法
        map.forEach((key, value) -> System.out.println("forEach:  " + key + " = " + value));
    }
}
