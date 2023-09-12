
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class ExceptionCar extends Exception {

    public ExceptionCar(String message) {
        super(message);
    }
}

enum Car {
    AUDI, MERCEDES, BMW;

    public List<Integer> getPrices() {
        List<Integer> prices = new ArrayList<>();
        switch (this) {
            case AUDI:
                prices.add(5500);
                prices.add(3000);
                prices.add(4500);
                break;
            case MERCEDES:
                prices.add(5000);
                prices.add(6000);
                prices.add(8500);
                break;
            case BMW:
                prices.add(2500);
                prices.add(3000);
                prices.add(3500);
                break;
        }
        return prices;
    }

    public List<String> getColors() {
        List<String> colors = new ArrayList<>();
        switch (this) {
            case AUDI:
                colors.add("WHITE");
                colors.add("YELLOW");
                colors.add("ORANGE");
                break;
            case MERCEDES:
                colors.add("GREEN");
                colors.add("BLUE");
                colors.add("PURPLE");
                break;
            case BMW:
                colors.add("PINK");
                colors.add("RED");
                colors.add("BROWN");
                break;
        }
        return colors;
    }

    public List<Day> getDaySells() {
        List<Day> days = new ArrayList<>();
        switch (this) {
            case AUDI:
                days.add(Day.FRIDAY);
                days.add(Day.SUNDAY);
                days.add(Day.MONDAY);
                break;
            case MERCEDES:
                days.add(Day.TUESDAY);
                days.add(Day.SATURDAY);
                days.add(Day.WEDNESDAY);
                break;
            case BMW:
                days.add(Day.MONDAY);
                days.add(Day.SUNDAY);
                days.add(Day.THURSDAY);
                break;
        }
        return days;
    }

    public static Car getCar(String car) throws ExceptionCar {
        try {
            return Car.valueOf(car.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ExceptionCar("Invalid car name");
        }
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public static Day getDay(String day) throws ExceptionCar {
        try {
            return Day.valueOf(day.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ExceptionCar("Invalid day");
        }
    }
}

enum Color {
    WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NO_COLOR;

    public static Color getColor(String color) throws ExceptionCar {
        try {
            return Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ExceptionCar("Invalid color");
        }
    }
}

public class Main {

    public static Car checkCar(Car car, Color color, Day day, String price) throws ExceptionCar {
        List<Integer> validPrices = car.getPrices();
        List<String> validColors = car.getColors();
        List<Day> validDays = car.getDaySells();

        int priceInt;
        try {
            priceInt = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new ExceptionCar("Invalid price");
        }

        if (!validPrices.contains(priceInt) || !validColors.contains(color) || !validDays.contains(day)) {
            throw new ExceptionCar("Invalid car information");
        }

        return car;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter car name: ");
        String inputCar = scanner.nextLine();

        System.out.print("Enter color: ");
        String inputColor = scanner.nextLine();

        System.out.print("Enter day: ");
        String inputDay = scanner.nextLine();

        System.out.print("Enter price: ");
        String inputPrice = scanner.nextLine();

        try {
            Car car = checkCar(Car.getCar(inputCar), Color.getColor(inputColor), Day.getDay(inputDay), inputPrice);
            System.out.println("Valid car: " + car);
        } catch (ExceptionCar e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
