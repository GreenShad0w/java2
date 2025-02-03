package main;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private String gender;

    //Конструктор
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
    }

    // Конструктор с параметрами
    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Билдер
    public static class StudentBuilder {
        private String name;
        private int age;
        private String gender;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            return new Student(name, age, gender);
        }
    }
}
