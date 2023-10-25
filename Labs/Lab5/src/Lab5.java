/*
 * Author: Derin Ergul
 * Date: 10/3/23
 * CSC1351 Lauren Pace
 * Description: This program makes use of an abstract class to calculate various properties of shapes.
 */

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input and create shape objects
        Rectangle rectangle1 = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
        Rectangle rectangle2 = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
        Square square1 = new Square(scanner.nextDouble());
        Square square2 = new Square(scanner.nextDouble());
        Circle circle1 = new Circle(scanner.nextDouble());
        Circle circle2 = new Circle(scanner.nextDouble());

        // Print rectangle area and perimeter calculations
        System.out.printf("Area of first rectangle: %.4f%n", rectangle1.calculateArea());
        System.out.printf("Perimeter of first rectangle: %.4f%n", rectangle1.calculatePerimeter());
        System.out.printf("Area of second rectangle: %.4f%n", rectangle2.calculateArea());
        System.out.printf("Perimeter of second rectangle: %.4f%n", rectangle2.calculatePerimeter());

        // Check if the areas of the rectangles are equal
        boolean equalRectangles = equalArea(rectangle1, rectangle2);
        System.out.println("The two objects have the same area: " + equalRectangles);

        // Print square area and perimeter calculations
        System.out.printf("Area of first square: %.4f%n", square1.calculateArea());
        System.out.printf("Perimeter of first square: %.4f%n", square1.calculatePerimeter());
        System.out.printf("Area of second square: %.4f%n", square2.calculateArea());
        System.out.printf("Perimeter of second square: %.4f%n", square2.calculatePerimeter());

        // Check if the areas of the squares are equal
        boolean equalSquares = equalArea(square1, square2);
        System.out.println("The two objects have the same area: " + equalSquares);

        // Print circle area and circumference calculations
        System.out.printf("Area of first circle: %.4f%n", circle1.calculateArea());
        System.out.printf("Circumference of first circle: %.4f%n", circle1.calculatePerimeter());
        System.out.printf("Area of second circle: %.4f%n", circle2.calculateArea());
        System.out.printf("Circumference of second circle: %.4f%n", circle2.calculatePerimeter());

        // Check if the areas of the circles are equal
        boolean equalCircles = equalArea(circle1, circle2);
        System.out.println("The two objects have the same area: " + equalCircles);
    }

    public static boolean equalArea(Shape shape1, Shape shape2) {
        return shape1.calculateArea() == shape2.calculateArea();
    }
}

abstract class Shape {
    protected double height;

    public Shape(double height) {
            this.height = height;
    }

    public abstract double calculateArea();
    // lab problem desc says abstract double calculateArea twice, assuming that was a typo
    public abstract double calculatePerimeter();
}

class Rectangle extends Shape {
    private double width;

    public Rectangle(double width, double height) {
        super(height);
        this.width = width;
    }

    public double calculateArea() {
            return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

class Circle extends Shape {
    public Circle(double height) {
        super(height);
    }

    public double calculateArea() {
        double radius = height / 2;
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        double radius = height / 2;
        return 2 * Math.PI * radius;
    }
}