package Zadanie2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FigureReader {
    public static Figure readFigureFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        if (line == null) {
            throw new IllegalArgumentException("Файл пуст.");
        }
        String[] parts = line.split(",");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Недостаточно данных в файле.");
        }
        String figureType = parts[0].trim().toLowerCase();
        switch (figureType) {
            case "circle":
                double radius = Double.parseDouble(parts[1]);
                return new Circle(radius);
            case "square":
                double side = Double.parseDouble(parts[1]);
                return new Square(side);
            case "rectangle":
                if (parts.length < 3) {
                    throw new IllegalArgumentException("Недостаточно данных для прямоугольника.");
                }
                double width = Double.parseDouble(parts[1]);
                double height = Double.parseDouble(parts[2]);
                return new Rectangle(width, height);
            default:
                throw new IllegalArgumentException("Неизвестный тип фигуры.");
        }
    }
}
