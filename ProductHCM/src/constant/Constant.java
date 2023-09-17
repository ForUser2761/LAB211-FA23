/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author ADMIN
 */
public class Constant {

    public static final String FILE_NAME = "Product.dat";
    public static final int STATUS_AVAILABLE = 1;

    public static final int STATUS_NOT_AVAILABLE = 2;

    /**
     * REGEX_ALL_CHARACTER: (\\s|.){0,}
     */
    public static final String REGEX_ALL_CHARACTER = "(\\s|.){0,}";
    /**
     * REGEX_DOUBLE_NUMBER: \\d+[.]{0,1}\\d{0,}
     */
    public static final String REGEX_DOUBLE_NUMBER = "\\d+[.]{0,1}\\d{0,}";
    /**
     * REGEX_INTEGER_NUMBER: \\d+
     */
    public static final String REGEX_INTEGER_NUMBER = "\\d+";
    /**
     * REGEX_NAME: \\S{5,}
     */
    public static final String REGEX_NAME = "\\S{5,}";
    /**
     * REGEX_STATUS: 1|2
     */
    public static final String REGEX_STATUS = STATUS_AVAILABLE + "|" + STATUS_NOT_AVAILABLE;
}
