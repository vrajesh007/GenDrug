package com.newproject.gendrug.Model;

public class Cart {

    String CartID,ProductID,ProductName,ProductDescription,ProductImage,ProductQty,productUnitPrice,ProductAmount;

    public Cart(String cartID, String productID, String productName, String productDescription, String productImage, String productQty, String productUnitPrice, String productAmount) {
        CartID = cartID;
        ProductID = productID;
        ProductName = productName;
        ProductDescription = productDescription;
        ProductImage = productImage;
        ProductQty = productQty;
        this.productUnitPrice = productUnitPrice;
        ProductAmount = productAmount;
    }

    public Cart() {
    }

    public String getCartID() {
        return CartID;
    }

    public void setCartID(String cartID) {
        CartID = cartID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }

    public String getProductQty() {
        return ProductQty;
    }

    public void setProductQty(String productQty) {
        ProductQty = productQty;
    }

    public String getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public String getProductAmount() {
        return ProductAmount;
    }

    public void setProductAmount(String productAmount) {
        ProductAmount = productAmount;
    }
}
