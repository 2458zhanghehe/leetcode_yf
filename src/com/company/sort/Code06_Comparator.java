package com.company.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Code06_Comparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IDAscendingComparator implements Comparator<Student> {
//        返回负数时，第一个参数排在前面
//        返回正数时，第二个参数排在前面

        @Override
        public int compare(Student st1, Student st2) {
            return st1.id - st2.id;
        }
    }

    public static class IDDescendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student st1, Student st2) {
            return st2.id - st1.id;
        }
    }

    public static class AgeAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    public static class AgeDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    // 先按照id排序，id小的，放前面；
    // id一样，age大的，前面；
    public static class AgeShengIdSheng implements Comparator<Student> {
        @Override
        public int compare(Student st1, Student st2) {
            return st1.id != st2.id ? (st1.id - st2.id) : (st1.age - st2.age);
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name:" + student.name + " Id:" + student.id + " Age:" + student.age);
        }
    }

    public static class AComp implements Comparator<Integer> {
        @Override
        public int compare(Integer arg0, Integer arg1) {
            return arg1 - arg0;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 7, 9, 1, 0};
        Arrays.sort(arr, new AComp());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("======================================");

        Student student1 = new Student("张三", 2, 20);
        Student student2 = new Student("李四", 1, 21);
        Student student3 = new Student("王五", 3, 22);

        Student[] students = new Student[]{student1, student2, student3};

        Arrays.sort(students, new IDAscendingComparator());
        printStudents(students);
        System.out.println("======================================");

        Arrays.sort(students, new IDDescendingComparator());
        printStudents(students);
        System.out.println("======================================");

        Arrays.sort(students, new AgeShengIdSheng());
        printStudents(students);
        System.out.println("======================================");


        PriorityQueue<Student> minHeapBaseId = new PriorityQueue<>(new AgeAscendingComparator());    //默认小顶堆，改成大顶堆需要添加比较器
        minHeapBaseId.add(student1);
        minHeapBaseId.add(student2);
        minHeapBaseId.add(student3);
        while (!minHeapBaseId.isEmpty()) {
            Student student = minHeapBaseId.poll();
            System.out.println("Name:" + student.name + " Id:" + student.id + " Age:" + student.age);
        }
        System.out.println("======================================");

        TreeSet<Student> treeAgeDescending = new TreeSet<>(new AgeDescendingComparator());
        treeAgeDescending.add(student1);
        treeAgeDescending.add(student2);
        treeAgeDescending.add(student3);

        Student studentFirst = treeAgeDescending.first();
        System.out.println("Name:" + studentFirst.name + " Id:" + studentFirst.id + " Age:" + studentFirst.age);

        Student studentLast = treeAgeDescending.last();
        System.out.println("Name:" + studentLast.name + " Id:" + studentLast.id + " Age:" + studentLast.age);
    }


}
