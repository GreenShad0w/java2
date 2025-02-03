package Zadanie2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Figure figure = FigureReader.readFigureFromFile("C:/data.txt");
            System.out.println("Площадь: " + figure.area());
            System.out.println("Периметр: " + figure.perimeter());
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка в данных: " + e.getMessage());
        }
    }
}
