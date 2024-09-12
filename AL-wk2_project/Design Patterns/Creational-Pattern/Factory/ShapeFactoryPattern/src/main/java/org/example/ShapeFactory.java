package org.example;

public class ShapeFactory {
    static Shape createShape(String shapeName) {
        switch (shapeName) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            default:
                throw new IllegalArgumentException("Shape " + shapeName + " not supported");
        }
    }
}
