/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public enum Color {
    WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NO_COLOR;
    
    public static Color getColor(String color) {
        try {
            if (color.equalsIgnoreCase("no color")) {
                return NO_COLOR;
            }
            return Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    static Color inputColor(String color_) {
        String color = Input.getString(color_);
        return getColor(color);
    }

    
}
