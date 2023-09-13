package view;

import controller.Manage;
import model.Vehicle;

public class ViewVehicle {

    Manage manage = new Manage();

    void input() {
        //input information
        String id;
        while (true) {
            id = Utility.getString("Enter Vehicle ID: ",
                    "Invalid ID format.", "[A-Za-z0-9]+");
            if (manage.isDuplicateId(id)) {
                System.out.println("Duplicate id !!");
            } else {
                break;
            }
        }
        String name = Utility.getString("Enter Vehicle Name: ",
                "Invalid name.", ".+");
        String color = Utility.getString("Enter Vehicle Color: ",
                "Invalid color.", ".+");
        double price = Utility.getDouble("Enter Vehicle Price: ",
                "Invalid price.", 0.0, Double.MAX_VALUE);
        String brand = Utility.getString("Enter Vehicle Brand: ",
                "Invalid brand.", ".+");
        String type = Utility.getString("Enter Vehicle Type: ",
                "Invalid type.", ".+");
        int productYear = Utility.getInteger("Enter Vehicle Production Year: ",
                "Invalid year.", 0, 9999);

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

}
