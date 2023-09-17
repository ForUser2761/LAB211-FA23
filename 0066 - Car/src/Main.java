
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        //input information

        Car car = Car.inputCar("Car: ");
        Color color = Color.inputColor("Color: ");
        Day day = Day.inputDay("Price: ");
        String priceInput = Input.getString("Price: ");

        try {
            //check car matched
            checkCar(car, color, day, priceInput);
            System.out.println("Sell Car");
            
        } catch (ExceptionCar ex) {
            System.err.println("Can't sell car");
            System.err.println(ex.getMessage());
        }

    }

    private static void checkCar(Car car, Color color, Day day, String priceInput) throws ExceptionCar {
        List<Color> listColorAvailable = car.getColors();
        List<Day> listDayAvailable = car.getDaySells();
        List<Integer> listPriceAvailable = car.getPrices();

        int price;
        try {
            price = Integer.parseInt(priceInput);
            if (price < 0) {
                throw new ExceptionCar("Price greater than zero");
            }
        } catch (NumberFormatException e) {
            throw new ExceptionCar("Price is digit");
        } 
        
        if (!listColorAvailable.contains(color)) {
            throw new ExceptionCar("Color Car does not exist");
        }
        
        if (!listDayAvailable.contains(day)) {
            throw new ExceptionCar("Car can't sell today");
        }
        
        if (listPriceAvailable.contains(price) 
                || (listPriceAvailable.contains(price + 100) && color == Color.NO_COLOR)) {
        }else {
            throw new ExceptionCar("Price is not true");
        }
        
    }

}
