package org.example;

public class Main {
    public static void main(String[] args) {
       Shape circle = ShapeFactory.createShape("Circle");
       circle.draw();

       Shape rectangle = ShapeFactory.createShape("Rectangle");
       rectangle.draw();

       Shape square = ShapeFactory.createShape("Square");
       square.draw();

       Shape triangle = ShapeFactory.createShape("Triangle");
       triangle.draw();
    }
}