package org.ace58tech;

public class Main {
    public static void main(String[] args) {
        ProductRecord product = new ProductRecord("Samsung Galaxy S24", 26000.00, "mobile phone");
        ElectronicProduct electronicProduct = new ElectronicProduct("TCL Television", """
                \t\tAn android based TV.
                \t\tComes with Amazon Prime and Netflix
                \t\t
                \t\tA 4k resolution
                """, "Television", "5000");
        System.out.println("Product: " + product.name() + "\n\tPrice: " + product.price() + "\n\tCategory: " + product.category());
        System.out.println("Product: " + electronicProduct.getProductName() + "\n\tPrice: " + electronicProduct.getProductPrice() + "\n\tCategory: " + electronicProduct.getProductCategory() + "\n\tDescription: \n" + electronicProduct.getProductDescription());

    }
}