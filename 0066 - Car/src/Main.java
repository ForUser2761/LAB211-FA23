
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
        System.out.println("===== Showroom car program =====\n"
                + "Input Information of Car");
        while (true) {

            Car car = Car.inputCar("Car: ");
            Color color = Color.inputColor("Color: ");
            String priceInput = Input.getString("Price: ");
            Day day = Day.inputDay("Today: ");

            try {
                //check car matched
                checkCar(car, color, day, priceInput);
                System.out.println("Sell Car");
                if (!Input.isContinue()) {
                    break;
                }

            } catch (ExceptionCar ex) {
                System.err.println("Can't sell car");
                System.err.println(ex.getMessage());
                break;
            }
        }

    }

    private static void checkCar(Car car, Color color, Day day, String priceInput) throws ExceptionCar {
        try {
            //if car not exist
            if (car == null) {
                throw new ExceptionCar("Car break");
            }

            List<Color> listColorAvailable = car.getColors();
            List<Day> listDayAvailable = car.getDaySells();
            List<Integer> listPriceAvailable = car.getPrices();

            int price;

            price = Integer.parseInt(priceInput);
            if (price < 0) {
                throw new ExceptionCar("Price greater than zero");
            }
            if (!listColorAvailable.contains(color)) {
                throw new ExceptionCar("Color Car does not exist");
            }

            if (!listDayAvailable.contains(day)) {
                throw new ExceptionCar("Car can't sell today");
            }

            if (listPriceAvailable.contains(price)
                    || (listPriceAvailable.contains(price + 100) && color == Color.NO_COLOR)) {
            } else {
                throw new ExceptionCar("Price is not true");
            }
        } catch (NumberFormatException e) {
            throw new ExceptionCar("Price is digit");
        }

    }

}
