/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import model.Product;

/**
 *
 * @author ADMIN
 */
public interface IProduct {
    void addProduct(Product product);
    
    Product findByCode(String code);
}
