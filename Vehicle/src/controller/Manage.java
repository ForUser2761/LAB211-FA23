/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Vehicle;

/**
 *
 * @author ADMIN
 */
public class Manage {

    ArrayList<Vehicle> vehicleList;

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public Manage() {
        vehicleList = new ArrayList<>();
        // Thêm các đối tượng Vehicle vào vehicleList
        vehicleList.add(new Vehicle("V0001", "Car 1", "Red", 20000.0, "Toyota", "Sedan", 2020));
        vehicleList.add(new Vehicle("V0002", "Car 2", "Blue", 25000.0, "Honda", "SUV", 2021));
        vehicleList.add(new Vehicle("V0003", "Motorcycle 1", "Black", 5000.0, "Honda", "Sport", 2019));
        vehicleList.add(new Vehicle("V0004", "Truck 1", "White", 35000.0, "Ford", "Pickup", 2018));
    }

    /**
     * Hàm này sử dụng để check duplicate dựa trên id
     *
     * @param id
     * @return true: bị duplicate false: không bị duplicate
     */
    public boolean isDuplicateId(String id) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Hàm này sử dụng để add mới vehicle vào trong collections
     *
     * @param vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**
     * Hàm này sử dụng để tìm kiếm 1 vehicle dự trên id
     *
     * @param id
     * @return vehicle: vehicle được tìm thấy null: không tìm thấy
     */
    public Vehicle findById(String id) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * Xóa một vehicle bên trong danh sách
     *
     * @param vehicle
     */
    public void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    /**
     * find vehicle by name
     *
     * @param name
     * @return list vehicles
     */
    public ArrayList<Vehicle> findByName(String name) {
        ArrayList<Vehicle> list = new ArrayList<>();
        //lap qua tung phan tu
        for (Vehicle vehicle : vehicleList) {
            //check vehicle co name contain name parameter
            if (vehicle.getName().toUpperCase().contains(name.toUpperCase())) {
                list.add(vehicle);
            }
        }
        return list;
    }

    /**
     * tim ve 1 danh sach cac vehicle theo id
     *
     * @param id
     * @return
     */
    public ArrayList<Vehicle> findsById(String id) {
        ArrayList<Vehicle> list = new ArrayList<>();
        //lap qua tung phan tu
        for (Vehicle vehicle : vehicleList) {
            //check vehicle co id contain id parameter
            if (vehicle.getId().equalsIgnoreCase(id)) {
                list.add(vehicle);
            }
        }
        return list;
    }

    /**
     * sort a list by name descending
     *
     * @param list
     */
    public void sortNameDescendingList(ArrayList<Vehicle> list) {
        Collections.sort(list, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o2.getName().compareToIgnoreCase(o1.getName());
            }
        });
    }

    /**
     * Tìm kiếm những vehicle có price <= price input @param
     *
     * price
     * @param price
     * @return
     */
    public ArrayList<Vehicle> findVehiclesByPrice(double price) {
        ArrayList<Vehicle> list = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getPrice() <= price) {
                list.add(vehicle);
            }
        }
        return list;
    }
    
    /**
     * Sort vehicles descending theo price 
     * @param list 
     */
    public void sortPriceDescending(ArrayList<Vehicle> list) {
        Collections.sort(list, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
    }
    
    /**
     * tim ra toan bo vehicles co product year lon hon hoac bang voi product year nhap vao 
     * 
     * @param year
     * @return 
     */
    public ArrayList<Vehicle> findVehiclesByProductYear(int year) {
        ArrayList<Vehicle> list = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getProductYear()>= year) {
                list.add(vehicle);
            }
        }
        return list;
    }

    public void sortYearDescending(ArrayList<Vehicle> list) {
        Collections.sort(list, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o2.getProductYear() - o1.getProductYear();
            }
        });
    }

}
