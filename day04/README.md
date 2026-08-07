# Day 4（8.8）数组与排序

## 今天学了什么

1. **数组的定义与遍历**
   - `int[] arr = new int[5]` 定义数组
   - 普通 for 循环、增强 for（`for (int i : arr)`）
   - 函数式遍历：`Arrays.stream(arr).forEach(...)`

2. **Arrays 工具类**
   - `Arrays.toString()`：数组转字符串，打印神器
   - `Arrays.sort()`：升序排序（直接修改原数组）
   - `copyOf` / `copyOfRange` / `fill` / `equals` 等

3. **手动实现反转和排序**
   - 数组反转：首尾元素两两交换（`arr.length / 2` 次）
   - 冒泡排序：每轮把最大元素"冒"到最后，双重循环

4. **引用类型传参（重点）**
   - 数组是引用类型：方法里修改会直接影响原数组
   - 和基本类型传参的本质区别——Day4 亲手验证过了

## 代码

- `src/com/liang/test4/TestDemo4.java` —— main 入口
- `src/com/liang/test4/ArrayReverser.java` —— 数组反转
- `src/com/liang/test4/BubbleSort.java` —— 冒泡排序

## 运行方式

IDEA 中打开 `TestDemo4.java` 运行，按提示依次输入 5 个整数。
