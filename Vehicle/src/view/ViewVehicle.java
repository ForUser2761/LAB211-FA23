package view;

import controller.Manage;
import java.util.ArrayList;
import model.Vehicle;

public class ViewVehicle {

    Manage manage = new Manage();

    void input() {
        //input information
        String id;
        while (true) {
            id = Utility.inputId();
            if (manage.isDuplicateId(id)) {
                System.out.println("Duplicate id !!");
            } else {
                break;
            }
        }
        String name = Utility.inputName();
        String color = Utility.inputColor();
        double price = Utility.inputPrice();
        String brand = Utility.inputBrand();
        String type = Utility.inputType();
        int productYear = Utility.inputProductYear();

        //add collections
        Vehicle vehicle = new Vehicle(id, name, color, price, brand, type, productYear);

        manage.addVehicle(vehicle);
        //display status
        System.out.println("Add successful !!");
    }

    void delete() {
        //input id vehicle
        String idToDelete = Utility.getString("Enter Vehicle ID to Delete: ",
                "Invalid ID format.", "[A-Za-z0-9]+");
        //search
        Vehicle vehicle = manage.findById(idToDelete);
        //not found
        if (vehicle == null) {
            System.err.println("Not found");
            System.err.println("Delete failed");
        }else {
            //found
            manage.removeVehicle(vehicle);
        }
        
    }

    void searchByName() {
        //input name
        String name = Utility.inputName();
        //search
        ArrayList<Vehicle> list = manage.findByName(name);
        //list empty <=> not found
        if (list.isEmpty()) {
            System.err.println("NOT FOUND !!");
        }else {
            //sort descending
            manage.sortNameDescendingList(list);
            
            //display
            for (Vehicle vehicle : list) {
                System.out.println(vehicle);
            }
        }
        
    }

    void searchById() {
        //input name
        String id = Utility.inputId();
        //search
        ArrayList<Vehicle> list = manage.findsById(id);
        //list empty <=> not found
        if (list.isEmpty()) {
            System.err.println("NOT FOUND !!");
        }else {
            //display
            for (Vehicle vehicle : list) {
                System.out.println(vehicle);
            }
        }
    }

    void showAllVehicles() {
        //display
            for (Vehicle vehicle : manage.getVehicleList()) {
                System.out.println(vehicle);
            }
    }

    void showAllByPrice() {
        //input price
        double price = Utility.inputPrice();
        //search all vehicle by price <= price input
        ArrayList<Vehicle> list = manage.findVehiclesByPrice(price);
        if (list.isEmpty()) {
            System.err.println("NOT FOUND");
        }else {
            //sort descending
            manage.sortPriceDescending(list);
            //display
            for (Vehicle vehicle : list) {
                System.out.println(vehicle);
            }
        }
        
        
    }

    void printAllVehiclesByYear() {
        //input year
        int year = Utility.inputProductYear();
        
        //search vehicles's product year = year input
        ArrayList<Vehicle> list = manage.findVehiclesByProductYear(year);
        //check list empty
        if (list.isEmpty()) {
            System.err.println("NOT FOUND !!");
        }else {
            //sort descending
            manage.sortYearDescending(list);
            //display
            for (Vehicle vehicle : list) {
                System.out.println(vehicle);
            }
        }
    }

}
