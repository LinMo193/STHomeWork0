package com.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> list;

    public StudentManager() {
        this.list=new ArrayList<>(20);
    }

    /**
     * 控制整体流程
     */
    public void App() {
        Scanner reader=new Scanner(System.in);
        while (true) {
            // 调用菜单
            easySout();
            switch (reader.nextInt()) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    queryStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    editStudent();
                    break;
                case 5:
                    queryAll();
                    break;
                case 6:
                    exit();
                    break;
            }
        }
    }

    public void easySout() {
        System.out.println("***********************************");
        System.out.println("*             1 插入               *");
        System.out.println("*             2 查找               *");
        System.out.println("*             3 删除               *");
        System.out.println("*             4 修改               *");
        System.out.println("*             5 输出               *");
        System.out.println("*             6 退出               *");
        System.out.println("***********************************");
        System.out.println("请输入你的操作数：");
    }

    /**
     * 插入学生信息
     * @return
     */
    public void addStudent() {
        System.out.println("欢迎来到插入界面！");
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入学生的学号：");
        int id=reader.nextInt();
        System.out.println("请输入学生的姓名：");
        String name=reader.next();
        System.out.println("请输入学生的出生日期：");
        String birDate=reader.next();
        System.out.println("请输入学生的性别（true表示男，false表示女)：");
        boolean gender=reader.nextBoolean();
        list.add(new Student(id,name,birDate,gender));
    }

    /**
     * 查找学生信息
     * @return
     */
    public void queryStudent() {
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入要查找的学生姓名：");
        String name=reader.nextLine();
        for (int i=0;i<list.size();i++) {
            if (name.equals(list.get(i).getName())) {
                System.out.println("已查找到学生信息");
                System.out.println("   学号      姓名    出生年月    性别");
                System.out.println(String.format("%-10d%-10s%-10s%-10b",list.get(i).getId(),list.get(i).getName(),list.get(i).getBirDate(),list.get(i).getGender()));
            }
        }
    }

    /**
     * 删除学生信息
     * @return
     */
    public void deleteStudent() {
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入要删除的学生姓名：");
        String name=reader.nextLine();
        for (int i=0;i<list.size();i++) {
            if (name.equals(list.get(i).getName())) {
                list.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("删除失败，请重新操作");
    }

    /**
     * 根据学生姓名修改学生信息
     * 可以修改年龄及出生日期等信息
     * @return
     */
    public void editStudent() {
        // 列表索引
        int i;
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入要修改的学生姓名：");
        String name=reader.nextLine();
        // 查询该学生的具体索引
        for (i=0;i<list.size();i++) {
            if (name.equals(list.get(i).getName())) {
                break;
            }
        }
        while (true) {
            System.out.println("***********************************");
            System.out.println("*          1 修改学生的年龄          *");
            System.out.println("*          2 修改学生的性别          *");
            System.out.println("*          3 退出修改               *");
            System.out.println("***********************************");
            System.out.println("请输入操作数：");
            switch (reader.nextInt()) {
                // 修改学生年龄
                case 1:
                    System.out.println("请输入相关数据");
                    list.get(i).setBirDate(reader.next());
                    break;
                // 修改学生性别
                case 2:
                    System.out.println("请输入相关数据（F/M）");
                    list.get(i).setGender(reader.nextBoolean());
                    break;
                case 3:
                    return;
            }
        }
    }

    /**
     * 输出所有学生信息
     * @return
     */
    public void queryAll() {
        System.out.println("以下是所有在籍学生信息：");
        for (int i=0;i<list.size();i++) {
            System.out.println("   学号      姓名    出生年月    性别");
            System.out.println(String.format("%-10d%-10s%-10s%-10b",list.get(i).getId(),list.get(i).getName(),list.get(i).getBirDate(),list.get(i).getGender()));
        }
    }

    /**
     * 退出程序
     */
    public void exit() {
        System.exit(0);
    }

}
