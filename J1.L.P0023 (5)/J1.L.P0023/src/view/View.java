/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.Order;

/**
 *
 * @author kidzd
 */
public class View {

    Manage manage = new Manage();

    void createFruit() {
        while (true) {
            String id;
            int quantity;
            //enter attribute
            id = getIDInput();
//                if (manage.checkDuplicate(id)) {
//                    System.out.println("ID existed !!");
//                } else {
//                    break;
//                }
            if (manage.checkDuplicate(id)) {
                System.out.println("Id exsited, we will plus ....");
                //cong them so luong
                quantity = getQuantityInput();
                manage.getFruitByID(id).setQuantity(manage.getFruitByID(id).getQuantity() + quantity);
            } else {
                String name = getNameInput();
                double price = getPriceInput();
                quantity = getQuantityInput();
                String origin = getOriginInput();
                //create instance and add to list
                Fruit fruit = new Fruit(id, name, price, quantity, origin);
                manage.addFruit(fruit);
                System.out.println("Add successfull !!!");
            }
            if (!checkYesNo("continue")) {
                displayListFruit(manage.getListFruit());
                break;
            }
        }
    }

    /**
     * use to get ID from user
     *
     * @return id
     */
    private String getIDInput() {
        String id = GetInput.getString("Enter id: ", "It must letter or digit", GetInput.REGEX_STRING);
        return id;
    }

    /**
     * use to get name from user
     *
     * @return name
     */
    private String getNameInput() {
        String name = GetInput.getString("Enter name: ", "It must letter or digit", GetInput.REGEX_NAME);
        return name;
    }

    /**
     * use to get price from user
     *
     * @return price
     */
    private double getPriceInput() {
        double price = GetInput.getDouble("Enter price: ", "It must be real number", 0, Double.MAX_VALUE);
        return price;
    }

    /**
     * use to get quantity from user
     *
     * @return quantity
     */
    private int getQuantityInput() {
        int quantity = GetInput.getInt("Enter quantity: ", "It must be digit", 0, Integer.MAX_VALUE);
        return quantity;
    }

    /**
     * use to get origin from user
     *
     * @return origin
     */
    private String getOriginInput() {
        String origin = GetInput.getString("Enter origin: ", "It must letter or digit", GetInput.REGEX_STRING);
        return origin;
    }

    /**
     * check user want to yes or no
     *
     * @param message
     * @return true or false
     */
    private boolean checkYesNo(String message) {

        String choice = GetInput.getString("Do you want to " + message + " (y/n)?: ", "You must enter Y/y or N/n!", GetInput.REGEX_YES_NO);
        if (choice.equalsIgnoreCase("y")) {
            return true;
        }
        return false;

    }

    //shopping
    void shopping() {
        Order order = new Order();
        //code moi
        List<Fruit> listFruitTemp = new ArrayList<>();
        manage.addAllFruit(listFruitTemp, manage.getListFruit());

        //code moi
        if (listFruitTemp.isEmpty()) {
            System.out.println("List Fruit is empty !!");
            return;
        }

        while (true) {
            //Enter item and display name of item
            displayListFruit(listFruitTemp);
            Fruit fruitChoice;
            while (true) {
                String id = getIDInput();
                fruitChoice = manage.getFruitByID(id);
                if (fruitChoice == null) {
                    System.out.println("Enter again !!");
                } else {
                    System.out.println("You selected: " + fruitChoice.getName());
                    break;
                }

            }

            //input quantity
            int quantityOrder;
            while (true) {
                quantityOrder = getQuantityInput();
                if (quantityOrder > fruitChoice.getQuantity()) {
                    System.out.println("You must buy in range [1 - " + fruitChoice.getQuantity() + "]");
                } else {
                    break;
                }
            }

            //set quantity remaining
            fruitChoice.setQuantity(fruitChoice.getQuantity() - quantityOrder);
            if (fruitChoice.getQuantity() == 0) {
                manage.removeFruit(fruitChoice, listFruitTemp);
            }

            Fruit fruitOrder = new Fruit();
            fruitOrder.setId(fruitChoice.getId());
            fruitOrder.setName(fruitChoice.getName());
            fruitOrder.setOrigin(fruitChoice.getOrigin());
            fruitOrder.setQuantity(quantityOrder);
            fruitOrder.setPrice(fruitChoice.getPrice());

            order.addFruitToOrder(fruitOrder);
            //if false => order again
            //if true => break
            if (checkYesNo("Do you want to order now ?")) {
                break;
            }
            if (listFruitTemp.isEmpty()) {
                break;
            }
        }
        displayListFruitOrder(order.getListFruit());
        System.out.println("Total: " + order.getTotal() + "$");
        String customer = GetInput.getString("Input your name: ", "Wrong", GetInput.REGEX_STRING);
        order.setNameCustomer(customer);

        manage.addOrder(order);

    }
    //display list Fruit    

    private void displayListFruit(List<Fruit> listFruits) {
        System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s\n", "++Item++", "++Name++",
                "++Origin++", "++Quantity++", "++Price++");
        for (Fruit fruit : listFruits) {
            System.out.println(fruit);
        }
    }
    // display List Fruit Orders

    private void displayListFruitOrder(List<Fruit> listFruit) {
        System.out.printf("%-15s|%-15s|%-15s|%-15s\n", "Product", "Quantity", "Price", "Amount");
        for (int i = 1; i <= listFruit.size(); i++) {
            System.out.printf("%-15s|%-15s|%-15s|%-15s\n", listFruit.get(i - 1).getName(),
                    listFruit.get(i - 1).getQuantity(),
                    listFruit.get(i - 1).getPrice(),
                    listFruit.get(i - 1).getAmount());
        }
    }
    //view Order

    void viewOrder() {
        for (Order order : manage.getListOrders()) {
            System.out.println("Customer: " + order.getNameCustomer());
            displayListFruitOrder(order.getListFruit());
            System.out.printf("Total: %s$\n", order.getTotal());
            System.out.println();
        }
    }

}
