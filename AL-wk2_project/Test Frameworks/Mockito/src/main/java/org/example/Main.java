package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static class StudentService{
        private final List<String> list;

        public StudentService(List<String> list) {
            this.list = list;
        }

        public List<String> getList() {
            return this.list;
        }

        public String getStudent(int index){
            return this.list.get(index);
        }

        public void addStudent(String student){
            this.list.add(student);
        }

        public void setStudent(int index, String student){
            this.list.set(index, student);
        }
    }
}