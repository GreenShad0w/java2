package main;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Добавление студентов
        students.add(new Student("Иван", 20, "Мужской"));
        students.add(new Student("Мария", 22, "Женский"));
        students.add(new Student("Алексей", 23, "Мужской"));

        // Добавление студента с помощью билдера
        Student student = new Student.StudentBuilder()
                .setName("Елена")
                .setAge(21)
                .setGender("Женский")
                .build();
        students.add(student);

        // Запись студентов в файл
        writeStudentsToFile(students, "students.dat");

        // Чтение студентов из файла и вывод студентов одного пола
        List<Student> loadedStudents = readStudentsFromFile("students.dat");
        printStudentsByGender(loadedStudents, "Мужской");
    }

    // Метод для записи студентов
    private static void writeStudentsToFile(List<Student> students, String filename) {
        try (java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(new java.io.FileOutputStream(filename))) {
            out.writeObject(students);
            System.out.println("Студенты записаны в файл.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения студентов из файла
    private static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.FileInputStream(filename))) {
            students = (List<Student>) in.readObject();
            System.out.println("Студенты прочитаны из файла.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    // Метод для вывода студентов одного пола
    private static void printStudentsByGender(List<Student> students, String gender) {
        for (Student student : students) {
            if (student.getGender().equals(gender)) {
                System.out.println("Имя: " + student.getName() + ", Возраст: " + student.getAge() + ", Пол: " + student.getGender());
            }
        }
    }
}
