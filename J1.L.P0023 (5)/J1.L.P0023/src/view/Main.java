/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author kidzd
 */
public class Main {

    public static void main(String[] args) {
        View view = new View();
        //data gia

        //data gia
        while (true) {
            displayMenu();
            int option = GetInput.getInt("Enter option: ", "It must be digit", 1, 4);
            switch (option) {
                case 1:
                    //create fruit 
                    view.createFruit();
                    break;
                case 2:
                    //view order
                    view.viewOrder();
                    break;
                case 3:
                    //shopping 
                    view.shopping();
                    break;
                case 4:
                    //exit
                    System.exit(0);
                    break;

            }
        }
    }

    private static void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1.	Create Fruit\n"
                + "2.	View orders\n"
                + "3.	Shopping (for buyer)\n"
                + "4.	Exit");
    }

}
