package Zadanie2;

public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) throws IllegalArgumentException {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота прямоугольника должны быть положительными.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}
