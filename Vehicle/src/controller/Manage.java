/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Vehicle;

/**
 *
 * @author ADMIN
 */
public class Manage {

    ArrayList<Vehicle> vehicleList;

    public Manage() {
        vehicleList = new ArrayList<>();
    }
    /**
     * Hàm này sử dụng để check duplicate dựa trên id
     * @param id
     * @return 
     * true: bị duplicate
     * false: không bị duplicate
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
     * @param vehicle 
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }
    
    /**
     * Hàm này sử dụng để tìm kiếm 1 vehicle dự trên id
     * @param id
     * @return 
     * vehicle: vehicle được tìm thấy
     * null: không tìm thấy
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
     * @param vehicle 
     */
    public void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

}
