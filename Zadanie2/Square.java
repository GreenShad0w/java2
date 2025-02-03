package Zadanie2;

public class Square implements Figure {
    private double side;

    public Square(double side) throws IllegalArgumentException {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительной.");
        }
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }
}