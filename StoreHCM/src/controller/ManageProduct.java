/*
 * This class represents a product management system.
 * It implements the IProduct interface to manage a list of products.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 * The ManageProduct class is responsible for managing products.
 */
public class ManageProduct implements IProduct {

    // A list to store products
    private List<Product> listProduct;

    /**
     * Constructor for the ManageProduct class. Initializes the list of products
     * as an empty ArrayList.
     */
    public ManageProduct() {
        listProduct = new ArrayList<>();
    }

    /**
     * Get the list of products.
     *
     * @return The list of products.
     */
    public List<Product> getListProduct() {
        return listProduct;
    }

    /**
     * Set the list of products.
     *
     * @param listProduct The list of products to set.
     */
    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    /**
     * Adds a product to the list of products.
     *
     * @param product The product to add.
     */
    @Override
    public void addProduct(Product product) {
        listProduct.add(product);
    }

    /**
     * Finds a product by its code.
     *
     * @param code The code of the product to find.
     * @return The found product or null if not found.
     */
    @Override
    public Product findByCode(String code) {
        // Loop through the list of products
        for (Product product : listProduct) {
            // Check if the code of the current product matches the given code
            if (product.getCode().equalsIgnoreCase(code)) {
                // If a matching product is found, return it
                return product;
            }
        }
        // If no matching product is found, return null
        return null;
    }

}
