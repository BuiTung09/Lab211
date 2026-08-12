/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import data.Data;
import entity.Account;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import utils.IConstant;

/**
 *
 * @author win
 */
public class Ebank {

    private ResourceBundle bundle;

    /**
     * ham chon ngon ngu bang resource bundle
     *
     * @param locale
     */
    public void setLocate(Locale locale) {
        bundle = ResourceBundle.getBundle("resources/Language", locale);
    }

    /**
     * ham kiem tra account bang regex
     *
     * @param accountNumber
     * @return
     */
    public String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches(IConstant.ACCOUNT_NUMBER)) {
            return null;
        } else {
            return bundle.getString("accountInvalid");
        }
    }

    /**
     * ham kiem tra password bang regex
     *
     * @param password
     * @return
     */
    public String checkPassword(String password) {
        if (password.matches(IConstant.PASSWORD)) {
            return null;
        } else {
            return bundle.getString("passwordInvalid");
        }
    }

    public String generateCaptcha() {
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        StringBuilder captcha = new StringBuilder();
//        Random random = new Random();
//        for (int i = 0; i < IConstant.CAPTCHA_LENGTH; i++) {
//            captcha.append(characters.charAt(random.nextInt(characters.length())));
//        }
//        return captcha.toString();

        Random random = new Random();
        StringBuilder captcha = new StringBuilder();

        while (captcha.length() < IConstant.CAPTCHA_LENGTH) {

            // Random từ ASCII 48 -> 122
            int ascii = random.nextInt(IConstant.ASCII_END - IConstant.ASCII_START + 1)+ IConstant.ASCII_START;

            // Ép sang ký tự
//            char ch = (char) ascii;
            char ch = (char) ascii;
            // Kiểm tra bằng regex
            if (String.valueOf(ch).matches(IConstant.CAPTCHA2)) {
                captcha.append(ch);
            }
        }

        return captcha.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        // sửa lại phần này nếu nhập vào chuỗi trống thì sẽ hông hợp lệ
        if (captchaInput.trim().isEmpty()) {
            return bundle.getString("captchaInvalid");
        }
        if (captchaGenerate.contains(captchaInput)) {
            return null;
        } else {
            return bundle.getString("captchaInvalid");
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        String accountNumber, password, captchaInput;
        String result;
        //Nhap account
        do {
            System.out.print(bundle.getString("account"));
            accountNumber = sc.nextLine();
            result = checkAccountNumber(accountNumber);
            if (result == null) {
                break;
            } else {
                System.out.println(result);
            }
        } while (true);
        //Nhap password
        do {
            System.out.print(bundle.getString("password"));
            password = sc.nextLine();
            result = checkPassword(password);
            if (result == null) {
                break;
            } else {
                System.out.println(result);
            }
        } while (true);
        //Nhap captcha
        String captchaGenerate = generateCaptcha();
        System.out.println(bundle.getString("captcha") + captchaGenerate);
        do {
            System.out.print(bundle.getString("inputCaptcha"));
            captchaInput = sc.nextLine();
            result = checkCaptcha(captchaInput, captchaGenerate);
            if (result == null) {
                break;
            } else {
                System.out.println(result);
            }
        } while (true);
        //Xac thuc authen
        if (authentication(accountNumber, password)) {
            System.out.println(bundle.getString("loginSuccess"));
        } else {
            System.out.println(bundle.getString("loginFailed"));
        }

    }

    boolean authentication(String account, String password) {
        for (Account a : Data.listAccount) {
            if (account.equals(a.getAccount()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
