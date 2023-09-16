package view;

import constant.Constant;
import controller.Manage;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vehicle;

public class ViewVehicle {

    Manage manage = new Manage();

    void input() {
        try {
            //load data tu file vao
            manage.loadDataFromFile();
        } catch (Exception ex) {
            System.err.println("Failed at read from file: " + ex.getMessage());
            return;
        }
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
        try {
            //ghi du lieu vao trong file
            manage.saveDataToFile();
        } catch (IOException ex) {
            System.err.println("Failed at save data to file: " + ex.getMessage());
            return;
        }
        //display status
        System.out.println("Add successful !!");
    }

    void delete() {
        //input id vehicle
        String idToDelete = Utility.inputId();
        //search
        Vehicle vehicle = manage.findById(idToDelete);
        //not found
        if (vehicle == null) {
            System.err.println("Not found");
            System.err.println("Delete failed");
        } else {
            //found
            manage.removeVehicle(vehicle);
            try {
                manage.saveDataToFile();
            } catch (IOException ex) {
                System.err.println("Failed at save data to file: " + ex.getMessage());
                return;
            }
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
        } else {
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
        } else {
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
        } else {
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
        } else {
            //sort descending
            manage.sortYearDescending(list);
            //display
            for (Vehicle vehicle : list) {
                System.out.println(vehicle);
            }
        }
    }

    void saveDataToFile() {
        try {
            manage.saveDataToFile();
            System.out.println("Save data to file successful !!");
        } catch (IOException e) {
            System.err.println("Save data to file failed");
        }
    }

    void checkExistVehicle() {
        //input id
        String id = Utility.inputId();
        try {
            //load data form file
            manage.loadDataFromFile();
            //check id exist in collections
            Vehicle vehicle = manage.findById(id);
            if (vehicle == null) {
                System.err.println("No Vehicle Found!");
            } else {
                System.out.println("Existed Vehicle");
            }
            //display
        } catch (Exception ex) {
            System.err.println("Failed at read from file: " + ex.getMessage());
        }
    }

    void updateVehicle() {
        //input id
        String id = Utility.inputId();

        //tim ra vehicle dua tren id
        Vehicle vehicle = manage.findById(id);
        //check vehicle null => not found
        if (vehicle == null) {
            System.err.println("Not found");
        } else {
            //update information
            String newName = Utility.inputName();
            if (!newName.isEmpty()) {
                vehicle.setName(newName);
            }
            String newColor = Utility.inputColor();
            if (!newColor.isEmpty()) {
                vehicle.setColor(newColor);
            }
            while (true) {    
                String newPrice = Utility.getString("Enter price: ", "Error",
                            Constant.REGEX_ALL_CHARACTER);
                //kiểm tra xem người dùng có nhập hay không
                if (!newPrice.isEmpty()) {
                    ////có nhập => đấy có phải là số hay không
                    if (newPrice.matches(Constant.REGEX_DOUBLE_NUMBER)) {
                        if (Double.parseDouble(newPrice) >= 0) {
                            vehicle.setPrice(Double.parseDouble(newPrice));
                            break;
                        }
                        else {
                            System.err.println("Must be greater equal than 0");
                        }
                    }else {
                        System.err.println("It not's a number");
                    }
                } else {
                    break;
                }
                
            }
            String newBrand = Utility.inputBrand();
            if (!newBrand.isEmpty()) {
                vehicle.setBrand(newBrand);
            }
            String newType = Utility.inputType();
            // Update vehicle information only if input is not blank
            if (!newType.isEmpty()) {
                vehicle.setType(newType);
            }
            while (true) {                
                String newProductYear = Utility.getString("Enter new product year: ",
                        "Error", Constant.REGEX_ALL_CHARACTER);
                //kiểm tra xem người dùng có nhập hay không
                if (!newProductYear.isEmpty()) {
                    //có nhập => đấy có phải là số hay không
                    if (newProductYear.matches(Constant.REGEX_INTEGER_NUMBER)) {
                        int productYear = Integer.parseInt(newProductYear);
                        if (productYear > 0) {
                            vehicle.setProductYear(productYear);
                            break;
                        }else {
                            System.err.println("Must be greater than 0");
                        }
                    }else {
                        //nếu như không phải là số
                        System.err.println("Must be number");
                    }
                    
                }else {
                    break;
                }
                
            }
            System.out.println("Vehicle information updated successfully.");

            try {
                //ghi du lieu vao trong file
                manage.saveDataToFile();
            } catch (IOException ex) {
                System.err.println("Failed at save data to file: " + ex.getMessage());
                return;
            }
        }

    }

}
