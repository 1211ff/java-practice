# JavaPractice · 8 月 Java 全栈地基训练营

> 主攻方向：Java 基础 → 全栈开发（SSM → SpringBoot → Vue3）
> 作者：1211ff（GitHub: https://github.com/1211ff）

每天敲代码，先默写再对照，不靠 AI 也要能写出来。**每天一个 commit，让 GitHub 绿格子见证坚持。**

## 📅 27 天打卡总表

| Day | 日期 | 主题 | 完成 |
|-----|------|------|------|
| Day 1 | 8.5 | 变量 + 数据类型 + Scanner 输入 | ☐ |
| Day 2 | 8.6 | 运算符 + if / switch 流程控制 | ☐ |
| Day 3 | 8.7 | 循环：for / while / 嵌套循环 | ☐ |
| Day 4 | 8.8 | 数组 | ☐ |
| Day 5 | 8.9 | 方法：参数 / 返回值 / 重载 / 递归 | ☐ |
| Day 6 | 8.10 | 面向对象四件套（类/封装/继承/多态） | ☐ |
| Day 7 | 8.11 | **总验收：学生成绩登记 v0.1**（不靠 AI） | ☐ |
| Day 8 | 8.12 | 异常体系 + try-catch-finally | ☐ |
| Day 9 | 8.13 | 异常实战 + 自定义异常 | ☐ |
| Day 10 | 8.14 | 集合 + 泛型综合复习 | ☐ |
| Day 11 | 8.15 | IO 流入门：File + 字节流 | ☐ |
| Day 12 | 8.16 | 字符流 + 缓冲流 | ☐ |
| Day 13 | 8.17 | 对象序列化 | ☐ |
| Day 14 | 8.18 | **复盘：文件版成绩管理** | ☐ |
| Day 15 | 8.19 | 线程创建：Thread + Runnable | ☐ |
| Day 16 | 8.20 | 线程安全 + synchronized（卖票） | ☐ |
| Day 17 | 8.21 | 线程通信：wait / notify（生产者消费者） | ☐ |
| Day 18 | 8.22 | 线程池 + Callable | ☐ |
| Day 19 | 8.23 | **自测：线程综合题**（不靠 AI） | ☐ |
| Day 20 | 8.24 | 网络编程：Socket 入门 | ☐ |
| Day 21 | 8.25 | **复盘 + Git 首次提交** | ☐ |
| Day 22 | 8.26 | MySQL 安装 + 建库建表 | ☐ |
| Day 23 | 8.27 | SQL 增删改查进阶（WHERE/LIKE/排序/聚合） | ☐ |
| Day 24 | 8.28 | JDBC 入门（Java 连 MySQL） | ☐ |
| Day 25 | 8.29 | JDBC 查询 + 事务 + CRUD 自测 | ☐ |
| Day 26 | 8.30 | 连接池 Druid + 三层架构 | ☐ |
| Day 27 | 8.31 | **总自测 + 9 月项目预告** | ☐ |

## 📁 目录结构

```
JavaPractice/
├── day01 ~ day27/   # 每天一个目录，放当天的 .java 练习代码
├── notes/           # 报错笔记：报错信息 → 原因 → 解决
├── 8月Java学习计划.html  # 每日打卡页面（励志弹窗 + 进度条）
├── .gitignore       # 忽略编译产物 / IDE 配置
└── README.md
```

## 🚀 每日标准流程（3 步）

```bash
# 1. 在对应 day 目录里写代码（如 day01/Hello.java）

# 2. 提交
git add .
git commit -m "Day 1 变量+数据类型+Scanner"

# 3. 推送（有网就推，别攒着）
git push
```

> ⚠️ 第 1 天、第 7 天、第 19 天、第 25 天是「不靠 AI 自测日」，先自己写，写不出来再问 AI，问完把答案默写一遍。

## 🎯 9 月预告

- **9.1-9.7**：学生信息管理系统 v1.0（完整项目，单独仓库 `student-info-system`）
- **9 月**：SSM（Spring + SpringMVC + MyBatis）——8 月把 JDBC 练透，开学听课=复习
- **10 月底**：止损检查点——不行就转测开/上位机，不恋战

## 🔐 提醒

- 练习代码里 **不要提交真实密码**（MySQL 密码、API Key），用占位符
- 提交前 `git status` 看一眼，确认没有误提交敏感文件
