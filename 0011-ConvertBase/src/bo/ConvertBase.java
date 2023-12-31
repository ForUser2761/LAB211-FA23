package bo;

import java.math.BigInteger;

/**
 *
 * @author ADMIN
 */
public class ConvertBase {

    public void convertValue(int baseInput, int baseOutput, String value) {
        String result = null;
        boolean isNegative = false;

        // Xử lý số nguyên âm
        if (value.startsWith("-")) {
            isNegative = true;
            value = value.substring(1); // Loại bỏ ký tự âm từ giá trị
        }

        switch (baseInput) {
            case 1:
                //neu baseInput = 1 : xu li binary
                result = convertBinary(baseOutput, value);
                break;
            case 2:
                //neu base input = 2 : xu li decimal
                result = convertDecimal(baseOutput, value);
                break;
            case 3:
                //neu base input = 3 : xu li hexadecimal
                result = convertHexadecimal(baseOutput, value);
                break;
        }
        // Nếu là số âm, thêm dấu trừ
        if (isNegative) {
            result = "-" + result;
        }

        System.out.println("Value is: " + result);
    }

    private String convertBinary(int baseOutput, String value) {
        String result = null;
        switch (baseOutput) {
            case 1:
                //neu baseOutput = 1 : binary => binary ( 2=>2)
                result = value;
                break;
            case 2:
                //neu baseOutput = 2 : binary => decimal ( 2=> 10)
                result = convertOtherToDecimal(2, value);
                break;
            case 3:
                //neu baseOutput = 3 : binary => hexadecimal ( 2 =>16)
                result = convertDecimalToOther(convertOtherToDecimal(2, value), 16);
                break;
        }
        return result;
    }

    private String convertHexadecimal(int baseOutput, String value) {
        String result = null;
        switch (baseOutput) {
            case 1:
                //neu baseOutput = 1 : hexa => binary ( 16=>2)
                result = convertDecimalToOther(convertOtherToDecimal(16, value), 2);
                break;
            case 2:
                //neu baseOutput = 2 : hexa => decimal ( 16=> 10)
                result = convertOtherToDecimal(16, value);
                break;
            case 3:
                //neu baseOutput = 3 : hexa => hexadecimal ( 16 =>16)
                result = value;
                break;
        }
        return result;
    }

    private String convertDecimal(int baseOutput, String value) {
        String result = null;
        switch (baseOutput) {
            case 1:
                //neu baseOutput = 1 : decimal => binary ( 2=>10)
                result = convertDecimalToOther(value, 2);
                break;
            case 2:
                //neu baseOutput = 2 : decimal => decimal ( 10=> 10)
                result = value;
                break;
            case 3:
                //neu baseOutput = 3 : decimal => hexadecimal ( 10 =>16)
                result = convertDecimalToOther(value, 16);
                break;
        }
        return result;
    }

    public static String convertOtherToDecimal( int baseInput, String value) {
        if (value.equals("8")) {
            return "0";
        }

        boolean isNegative = false;
        if (value.startsWith("-")) {
            isNegative = true;
            value = value.substring(1); // Loại bỏ ký tự âm từ giá trị
        }

        double baseInt = baseInput;
        double result = 0;
        String HEX = "0123456789ABCDEF";
        String[] parts = value.split("\\.");

        // Chuyển đổi phần nguyên
        String integerPart = parts[0];
        double basePower = 1;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            double valueIndex = HEX.indexOf(integerPart.charAt(i));
            double number = valueIndex * basePower;
            result += number;
            basePower *= baseInt;
        }

        // Chuyển đổi phần thập phân nếu có
        if (parts.length > 1) {
            String fractionalPart = parts[1];
            basePower = Math.pow(baseInt, -1);
            for (int i = 0; i < fractionalPart.length(); i++) {
                int valueIndex = HEX.indexOf(fractionalPart.charAt(i));
                double number = valueIndex * basePower;
                result += number;
                basePower /= baseInt;
            }
        }

        if (isNegative) {
            result = -result; // Đảo dấu kết quả nếu đầu vào là số âm
        }

        return Double.toString(result);
    }

    /**
     *
     *  // Chuyển đổi một số ở hệ cơ số khác thành số thập phân private String
     * convertOtherToDecimal(int baseInput, String value) { if
     * (value.equals("0")) { return "0"; }
     *
     * boolean isNegative = false; if (value.startsWith("-")) { isNegative =
     * true; value = value.substring(1); // Loại bỏ ký tự âm từ giá trị }
     *
     * // Khởi tạo số BigInteger từ cơ số đầu vào // BigInteger baseBigInteger
     * = BigInteger.valueOf(baseInput); // baseBigInteger =
     * baseBigInteger.divide(baseBigInteger); // Không làm gì cả, chỉ để khởi
     * tạo BigInteger baseBigInteger = new BigInteger("1");
     *
     * String HEX = "0123456789ABCDEF";
     *
     * BigInteger result = new BigInteger("0");
     *
     * //so thap phan String[] parts = value.split("\\."); //convert the
     * integer part String integerPart = parts[0]; // Vòng lặp chuyển đổi từng
     * chữ số ở hệ cơ số khác sang thập phân for (int i = integerPart.length() -
     * 1; i >= 0; i--) { // Lấy chỉ số của ký tự hiện tại trong chuỗi HEX để xác
     * định giá trị tương ứng BigInteger valueIndex =
     * BigInteger.valueOf(HEX.indexOf(value.charAt(i))); // Nhân giá trị của ký
     * tự với cơ số đầu vào để tính giá trị tương ứng ở thập phân BigInteger
     * number = valueIndex.multiply(baseBigInteger); // Cộng giá trị tương ứng
     * vào kết quả tổng result = result.add(number); // Tăng cơ số đầu vào lên
     * baseInput lần tiếp theo để tính toán cho chữ số tiếp theo baseBigInteger
     * = baseBigInteger.multiply(BigInteger.valueOf(baseInput)); }
     *
     * //convert the fractional part if present if (parts.length > 1) { String
     * fractionalPart = parts[1]; // Vòng lặp chuyển đổi từng chữ số ở hệ cơ số
     * khác sang thập phân for (int i = fractionalPart.length() - 1; i >= 0;
     * i--) { int valueFrac = HEX.indexOf(fractionalPart.charAt(i)); // Lấy giá
     * trị tương ứng của ký tự trong chuỗi HEX BigInteger digitValue =
     * BigInteger.valueOf(valueFrac); // Nhân giá trị của ký tự với cơ số đầu ra
     * để tính giá trị tương ứng ở hệ cơ số 10 BigInteger exponent =
     * BigInteger.valueOf(fractionalPart.length() - i - 1); BigInteger power =
     * BigInteger.valueOf(baseInput).pow(exponent.intValue()); BigInteger number
     * = digitValue.multiply(power); result = result.add(number); } }
     *
     * // Vòng lặp chuyển đổi từng chữ số ở hệ cơ số khác sang thập phân for
     * (int i = value.length() - 1; i >= 0; i--) { // Lấy chỉ số của ký tự hiện
     * tại trong chuỗi HEX để xác định giá trị tương ứng BigInteger valueIndex =
     * BigInteger.valueOf(HEX.indexOf(value.charAt(i)));
     *
     * // Nhân giá trị của ký tự với cơ số đầu vào để tính giá trị tương ứng ở
     * thập phân BigInteger number = valueIndex.multiply(baseBigInteger);
     *
     * // Cộng giá trị tương ứng vào kết quả tổng result = result.add(number);
     *
     * // Tăng cơ số đầu vào lên baseInput lần tiếp theo để tính toán cho chữ
     * số tiếp theo baseBigInteger =
     * baseBigInteger.multiply(BigInteger.valueOf(baseInput)); }
     *
     * if (isNegative) { result = result.negate(); // Đảo dấu kết quả nếu đầu
     * vào là số âm }
     *
     * return result.toString(); }
     *
     * @param baseInput
     * @param value
     * @return
     */
//    private String convertOtherToDecimal(int baseInput, String value) {
//        // Kiểm tra nếu giá trị đầu vào là "0"
//        if (value.equals("0")) {
//            return "0";
//        }
//
//        boolean isNegative = false;
//        if (value.startsWith("-")) {
//            isNegative = true;
//            value = value.substring(1); // Loại bỏ ký tự âm từ giá trị
//        }
//
//        // Khởi tạo giá trị cơ số đầu vào dưới dạng BigInteger
//        BigInteger baseBigInteger = BigInteger.valueOf(baseInput);
//        // Chuỗi biểu diễn các giá trị trong hệ cơ số mới (ví dụ: HEX trong hệ 16)
//        String HEX = "0123456789ABCDEF";
//        // Khởi tạo biến lưu kết quả cuối cùng
//        BigInteger result = BigInteger.ZERO;
//
//        // Tách phần nguyên và phần thập phân (nếu có) từ giá trị đầu vào
//        String[] parts = value.split("\\.");
//        // Xử lý phần nguyên
//        String integerPart = parts[0];
//        for (int i = integerPart.length() - 1; i >= 0; i--) {
//            // Lấy chỉ số của ký tự hiện tại trong chuỗi HEX để xác định giá trị tương ứng
//            BigInteger valueIndex = BigInteger.valueOf(HEX.indexOf(integerPart.charAt(i)));
//            // Khởi tạo giá trị cho số tại vị trí i
//            BigInteger number = valueIndex;
//            // Tính lũy thừa cho giá trị tại vị trí i
//            for (int j = 0; j < integerPart.length() - i - 1; j++) {
//                number = number.multiply(baseBigInteger);
//            }
//            // Cộng giá trị tại vị trí i vào kết quả tổng
//            result = result.add(number);
//        }
//
//        // Xử lý phần thập phân nếu có
//        if (parts.length > 1) {
//            String fractionalPart = parts[1];
//            for (int i = 0; i < fractionalPart.length(); i++) {
//                // Lấy giá trị tương ứng của ký tự trong chuỗi HEX
//                int valueFrac = HEX.indexOf(fractionalPart.charAt(i));
//                // Khởi tạo giá trị cho số tại vị trí i
//                BigInteger digitValue = BigInteger.valueOf(valueFrac);
//                BigInteger power = BigInteger.ONE;
//                // Tính lũy thừa cho vị trí i trong phần thập phân
//                for (int j = 0; j < i + 1; j++) {
//                    power = power.multiply(baseBigInteger);
//                }
//                // Chia giá trị của số tại vị trí i cho lũy thừa để tính giá trị tương ứng ở hệ cơ số 10
//                BigInteger number = digitValue.divide(power);
//                // Cộng giá trị tương ứng vào kết quả tổng
//                result = result.add(number);
//            }
//        }
//
//        // Đảo dấu kết quả nếu đầu vào là số âm
//        if (isNegative) {
//            result = result.negate();
//        }
//
//        // Trả về kết quả cuối cùng dưới dạng chuỗi
//        return result.toString();
//    }
//    private static String convertDecimalToOther(String decimalNumber, int base) {
//        if (decimalNumber.equals("0")) {
//            return "0";
//        }
//
//        // Khởi tạo một đối tượng BigInteger từ chuỗi số thập phân đầu vào
//        BigInteger decimalBigInteger = new BigInteger(decimalNumber);
//
//        // Khởi tạo đối tượnsg BigInteger từ cơ số đầu vào
//        BigInteger baseBigInteger = BigInteger.valueOf(base);
//
//        // Chuỗi ký tự biểu diễn các giá trị trong hệ cơ số mới (ví dụ: HEX trong hệ 16)
//        String HEX = "0123456789ABCDEF";
//
//        // Chuỗi kết quả cuối cùng sau khi chuyển đổi
//        StringBuilder result = new StringBuilder();
//
//        // Biến kiểm tra xem số thập phân đầu vào có âm hay không
//        boolean isNegative = false;
//
//        // Kiểm tra xem số thập phân có âm hay không
//        if (decimalBigInteger.compareTo(BigInteger.ZERO) < 0) {
//            isNegative = true;
//
//            // Lấy giá trị tuyệt đối để xử lý chuyển đổi
//            decimalBigInteger = decimalBigInteger.abs();
//        }
//
//        // Vòng lặp chuyển đổi từ số thập phân sang hệ cơ số khác
//        while (decimalBigInteger.compareTo(BigInteger.ZERO) > 0) {
//            // Tính phần dư khi chia số thập phân cho cơ số mới
//            BigInteger[] divisionResult = decimalBigInteger.divideAndRemainder(baseBigInteger);
//            int remainder = divisionResult[1].intValue();
//
//            // Lấy ký tự tương ứng với phần dư từ chuỗi HEX
//            result.append(HEX.charAt(remainder));
//
//            // Chia số thập phân cho cơ số mới để tiếp tục chuyển đổi các chữ số khác
//            decimalBigInteger = divisionResult[0];
//        }
//
//        if (isNegative) {
//            result.append("-");
//        }
//
//        return result.reverse().toString();
//    }
    private static String convertDecimalToOther(String decimalNumber, int base) {
        if (decimalNumber.equals("0")) {
            return "0";
        }

        // Chuyển đổi chuỗi số thập phân thành số dấu phẩy động
        double decimalDouble = Double.parseDouble(decimalNumber);

        // Tách phần nguyên và phần thập phân từ số dấu phẩy động
        int integerPart = (int) Math.abs(decimalDouble);
        double fractionalPart = Math.abs(decimalDouble) - integerPart;

        // Khởi tạo giá trị của cơ số dưới dạng số dấu phẩy động
        double baseDouble = base;

        // Chuỗi ký tự biểu diễn các giá trị trong hệ cơ số mới (ví dụ: HEX trong hệ 16)
        String HEX = "0123456789ABCDEF";

        // Chuỗi kết quả cuối cùng sau khi chuyển đổi
        StringBuilder result = new StringBuilder();

        // Biến kiểm tra xem số thập phân đầu vào có âm hay không
        boolean isNegative = false;

        // Kiểm tra xem số thập phân có âm hay không
        if (decimalDouble < 0) {
            isNegative = true;
        }

        // Chuyển đổi phần nguyên sang hệ cơ số mới
        while (integerPart > 0) {
            int remainder = integerPart % base;
            result.append(HEX.charAt(remainder));
            integerPart /= base;
        }

        // Đảo ngược chuỗi kết quả để hiển thị đúng giá trị
        result.reverse();

        // Xử lý phần thập phân (nếu có)
        if (fractionalPart > 0) {
            result.append(".");

            // Giới hạn số lượng chữ số thập phân để tránh vòng lặp vô hạn
            int maxFractionalDigits = 10;
            int currentFractionalDigits = 0;

            // Chuyển đổi phần thập phân sang hệ cơ số mới
            while (fractionalPart > 0 && currentFractionalDigits < maxFractionalDigits) {
                double product = fractionalPart * baseDouble;
                int digit = (int) product;
                result.append(HEX.charAt(digit));
                fractionalPart = product - digit;
                currentFractionalDigits++;
            }
        }

        // Nếu số thập phân đầu vào là âm, thêm ký tự '-' vào kết quả
        if (isNegative) {
            result.insert(0, "-");
        }

        return result.toString();
    }

    /**
     *     // Chuyển đổi một số thập phân thành hệ cơ số khác private static String
     * convertDecimalToOther(String decimalNumber, int base) { if
     * (decimalNumber.equals("0")) { return "0"; }
     *
     * // Khởi tạo một đối tượng BigInteger từ chuỗi số thập phân đầu vào
     * BigInteger decimalBigInteger = new BigInteger(decimalNumber);
     *
     * // Khởi tạo đối tượnsg BigInteger từ cơ số đầu vào BigInteger
     * baseBigInteger = BigInteger.valueOf(base);
     *
     * // Chuỗi ký tự biểu diễn các giá trị trong hệ cơ số mới (ví dụ: HEX
     * trong hệ 16) String HEX = "0123456789ABCDEF";
     *
     * // Chuỗi kết quả cuối cùng sau khi chuyển đổi StringBuilder result = new
     * StringBuilder();
     *
     * // Biến kiểm tra xem số thập phân đầu vào có âm hay không boolean
     * isNegative = false;
     *
     * // Kiểm tra xem số thập phân có âm hay không if
     * (decimalBigInteger.compareTo(BigInteger.ZERO) < 0) {
     * isNegative = true;
     *
     * // Lấy giá trị tuyệt đối để xử lý chuyển đổi
     * decimalBigInteger = decimalBigInteger.abs();
     * }
     *
     * // Vòng lặp chuyển đổi từ số thập phân sang hệ cơ số khác
     * while (decimalBigInteger.compareTo(BigInteger.ZERO) > 0) { // Tính phần
     * dư khi chia số thập phân cho cơ số mới int remainder =
     * decimalBigInteger.mod(baseBigInteger).intValue();
     *
     * // Lấy ký tự tương ứng với phần dư từ chuỗi HEX
     * result.append(HEX.charAt(remainder));
     *
     * // Chia số thập phân cho cơ số mới để tiếp tục chuyển đổi các chữ số
     * khác decimalBigInteger = decimalBigInteger.divide(baseBigInteger); }
     *
     * if (isNegative) { result.append("-"); }
     *
     * return result.reverse().toString(); }
     *
     * @param decimalNumber
     * @param base
     * @return
     */
}
