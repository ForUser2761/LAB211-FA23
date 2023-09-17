/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    
    // Method to get a Day enum from a String
    public static Day getDay(String day) {
        try {
            return Day.valueOf(day.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    static Day inputDay(String price_) {
        String day = Input.getString(price_);
        return getDay(day);
    }
}
