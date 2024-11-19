package org.ace58tech;

public class SwitchCase {
    public String determineProduct(Product product) {
        return switch (product){
            case ElectronicProduct electronicProduct -> "Processing electronics: " + "$ " + electronicProduct.getProductName() + "-> price: $" + electronicProduct.getProductPrice();
            case SkinCareProduct skinCareProduct -> "Processing electronics: " + "$ " + skinCareProduct.getProductName() + "-> price: $" + skinCareProduct.getProductPrice();
            default -> "Error: Invalid product";
        };
    }
}
