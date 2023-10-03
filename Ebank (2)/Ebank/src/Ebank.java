
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author SICOMP
 */
public class Ebank {

    ResourceBundle bundle;

    void setLocate(Locale locale) {
        bundle = ResourceBundle.getBundle("messages", locale);

        checkLogin(bundle);
    }

    private void checkLogin(ResourceBundle bundle) {
        //check account number
//        while (true) {
//            String account = Utility.getString(bundle.getString("inputAccount"));
//            String error = checkAccountNumber(account);
//
//            if (error == null) {
//                break;
//            } else {
//                System.out.println(error);
//            }
//        }
//
//        //check account password
//        while (true) {
//            String password = Utility.getString(bundle.getString("inputPassword"));
//            String error = checkPassword(password);
//
//            if (error == null) {
//                break;
//            } else {
//                System.out.println(error);
//            }
//        }

        //check captcha
        String captcha = generateCatpcha();
        System.out.println("Captcha: " + captcha);
        while (true) {

            String captchaInput = Utility.getString(bundle.getString("inputCaptcha"));
            String error = checkCaptcha(captcha, captchaInput);
            if (error == null) {
                break;
            }else {
                System.out.println(error);
            }
        }

    }

    private String checkAccountNumber(String account) {
        if (account.matches("\\d{10}")) {
            return null;
        } else {
            return bundle.getString("inputAccountError");
        }
    }

    private String checkPassword(String password) {
        if (password.matches("(?=.*\\d)(?=.*[a-zA-Z])\\S{8,31}")) {
            return null;
        } else {
            return bundle.getString("inputPasswordError");
        }
    }

    private String generateCatpcha() {
        //A-Z a-z 0-9
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        //sinh ra ki tu ngau nhien A-Z
        for (int i = 0; i < 2; i++) {
            int randomNumber = random.nextInt(26) + 65;
            builder.append((char) randomNumber);
        }
        //sinh ra ki tu ngau nhien 0-9

        for (int i = 0; i < 2; i++) {
            int randomNumber = random.nextInt(10) + 48;
            builder.append((char) randomNumber);
        }
        //sinh ra ki tu ngau nhien a-z

        for (int i = 0; i < 2; i++) {
            int randomNumber = random.nextInt(26) + 97;
            builder.append((char) randomNumber);
        }
        return builder.toString();
    }

    private String checkCaptcha(String captcha, String captchaInput) {
        if (captcha.contains(captchaInput) && !captchaInput.isEmpty()) {
            return null;
        }else {
            return bundle.getString("inputCaptchaError");
        }
    }

}
