/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Car;
import java.util.ArrayList;
import utils.Utility;

/**
 *
 * @author ADMIN
 */
public class ManageCar {

    ArrayList<Car> lc = new ArrayList<>();

    public void addCar() {
        String[] listColorAudi = {"White", "Yellow", "Orange"};
        int[] listPriceAudi = {5500, 3000, 4500};
        String[] listSoldDayAudi = {"Friday", "Sunday", "Monday"};
        lc.add(new Car("Audi", listColorAudi, listPriceAudi, listSoldDayAudi));

        String[] listColorMercedes = {"Green", "Blue", "Purple"};
        int[] listPriceMercedes = {5000, 6000, 8500};
        String[] listSoldDayMercedes = {"TueDay", "Saturday", "Wednesday"};
        lc.add(new Car("Mercedes", listColorMercedes, listPriceMercedes,
                listSoldDayMercedes));

        String[] listColorBMW = {"Pink", "Red", "Brown"};
        int[] listPriceBMW = {2500, 3000, 3500};
        String[] listSoldDayBMW = {"Monday", "Sunday", "Thurday"};
        lc.add(new Car("BMW", listColorBMW, listPriceBMW, listSoldDayBMW));
    }

    public boolean checkNameCar(String name, String color, int price, String today) throws ExceptionCar {
        boolean check = false;
        for (int i = 0; i < lc.size(); i++) {
            if (name.equalsIgnoreCase(lc.get(i).getNameCar())) {
                if (checkCarExist(lc.get(i), color, price, today)) {
                    System.out.println("Sell Car");
                    System.out.print("Do you want find more?(Y/N): ");
                    if (!Utility.checkYN()) {
                        return false;
                    }
                } else {
                    System.out.println("Car break");
                }
                check = true;
                break;
            }
        }
        if (check == false) {
            throw new ExceptionCar("Can't find car.");
        }
        return true;
    }

    private boolean checkCarExist(Car car, String color, int price, String today) throws ExceptionCar {
        boolean check = false;
        String[] listColor = car.getColer();
        int[] listPrice = car.getPrice();
        String[] listSold = car.getSoldOn();
        if (!color.equalsIgnoreCase("no color")) {
            for (int i = 0; i < listColor.length; i++) {
                if (color.equalsIgnoreCase(listColor[i])) {
                    check = true;
                    break;
                }
            }
        } else {
            check = true;
        }
        if (check == false) {
            throw new ExceptionCar("Color Car does not exist");
        }
        check = false;
        for (int i = 0; i < listPrice.length; i++) {
            if (price == listPrice[i] - 100) {
                check = true;
            }
        }
        if (check == false) {
            throw new ExceptionCar("Price Car does not exist");
        }
        check = false;
        for (int i = 0; i < listSold.length; i++) {
            if (today.equalsIgnoreCase(listSold[i])) {
                check = true;
            }
        }
        if (check == false) {
            throw new ExceptionCar("Car can't sell today");
        }
        return true;
    }
}
