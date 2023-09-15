/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import constant.Constant;
import java.util.Date;

public class Product {

    private String code;
    private String name;
    private Date manufacturingDate;
    private Date expirationDate;
    private int quantity;
    private int type;

    // Constructor
    public Product(String code, String name, Date manufacturingDate, Date expirationDate, int quantity, int type) {
        this.code = code;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.type = type;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getType() {
        return type;
    }

    // Setter methods (if needed)
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeString(int type) {
        String result = null;
        switch (type) {
            //1
            case Constant.TYPE_PRODUCT_DAILY:
                result = "Daily";
                break;
            //2
            case Constant.TYPE_PRODUCT_LONG_SHELF_LIFE:
                result = "Long shelf life";
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Product{"
                + "code='" + code + '\''
                + ", name='" + name + '\''
                + ", manufacturingDate=" + manufacturingDate
                + ", expirationDate=" + expirationDate
                + ", quantity=" + quantity
                + ", type=" + getTypeString(type)
                + '}';
    }
}
