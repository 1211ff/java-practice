# Day 10（8.14）集合框架 + 泛型 + Lambda

## 今天学了什么

1. **集合体系总览（method.txt 笔记的骨架）**
   - `Collection` 是顶层接口，两大分支：
     - **List**：有序、可重复、有下标 → `ArrayList`（数组，查快增删慢）/ `LinkedList`（双链表，增删快查慢）
     - **Set**：无序、不可重复、无下标 → `HashSet` / `LinkedHashSet` / `TreeSet`
   - **Map<K,V>**：键值对集合，**不继承 Collection**，key 不可重复、value 可重复

2. **Set 三兄弟的区别（这次补齐了代码演示）**
   - `HashSet`：无序（哈希表，查询最快）——小整数恰好按值排序，换复杂对象顺序就乱了
   - `LinkedHashSet`：**保持插入顺序**（链表+哈希）——演示里插入 5,3,9,1... 输出就是 5,3,9,1...
   - `TreeSet`：**自然排序升序**，独有 `first()` / `last()` 取最大最小元素
   - 三者都能去重，只是顺序规则不同——用同一个重复数组喂给三个 Set，输出对比一目了然

3. **Map 统计字符出现次数（经典应用）**
   - `map.getOrDefault(key, 0) + 1` 是计数标准写法：取不到就默认 0，再 +1
   - key 用 `char`（Character）更干净，不需要 `c + ""` 转字符串

4. **Map 遍历的两种主流写法**
   - `entrySet()`：拿到每一对 `Map.Entry`，用 `getKey()` / `getValue()` —— **遍历首选**
   - `forEach((k, v) -> ...)`：Java8 Lambda 写法，代码最短

5. **List 排序两种方式**
   - `list.sort((o1, o2) -> o2 - o1)`：Lambda 自定义规则，`o2 - o1` 是降序
   - `Collections.sort(list)`：默认升序（昨天注释里写的 API，今天真正用上了）

6. **踩坑：命名拼写**
   - `worldCount`（世界计数）→ 应为 `wordCount`（单词计数）；`textSortDemo`（文本排序）→ 应为 `testSortDemo`（测试排序）
   - 今天一次错了 3 个名字，方法名拼写错了 IDE 不会报错，但看代码的人会懵——写完花 10 秒检查一眼拼写

## 代码

- `src/com/liang/test10/TestDemo10.java` —— 4 个演示：Map 字符统计、Set 三兄弟对比、List 排序（Lambda + Collections.sort）、Map 遍历（entrySet + forEach）
- `src/com/liang/test10/method.txt` —— Collection / List / Set / Map 常用 API 笔记（自学的，建议继续积累）

## 运行方式

IDEA 中直接打开 `TestDemo10.java`，点击 `main` 方法左边的绿色三角运行。
命令行运行：

```bash
javac -encoding UTF-8 src/com/liang/test10/*.java
java -cp src com.liang.test10.TestDemo10
```
