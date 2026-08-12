/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import static entity.Base.BIN;
import static entity.Base.DEC;
import static entity.Base.HEX;
import java.math.BigInteger;

/**
 *
 * @author thuha
 */
public class BaseNumber {

    private Base base;
    private String number;

    public BaseNumber(Base base, String number) throws Exception {
        if (isValidNumber(base, number)) {
            this.base = base;
            this.number = number;
        } else {
            throw new Exception("Invalid number of base");
        }
    }

    public boolean isValidNumber(Base base, String number) {
        switch (base) {
            case BIN:
                return number.matches("[01]+");
            case DEC:
                return number.matches("[0-9]+");
            case HEX:
                return number.matches("[0-9A-F]+");
            default:
                throw new AssertionError();
        }
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) throws Exception {
        if (isValidNumber(base, number)) {
            this.number = convertDecOut(base).number;
            this.base = base;
        } else {
            throw new Exception("Invalid number of base");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws Exception {
        if (isValidNumber(base, number)) {
            this.number = number;
        } else {
            throw new Exception("Invalid number of base");
        }
    }

    private BaseNumber convertToDec() throws Exception {
        BigInteger decNum = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(this.base.getValue());
        BigInteger power = BigInteger.ONE;
        for (int i = number.length() - 1; i >= 0; i--) {
            char digit = number.charAt(i);
            BigInteger digitValue = BigInteger.valueOf(Character.getNumericValue(digit));
            decNum = decNum.add(digitValue.multiply(power));
            power = power.multiply(base);
        }
        return new BaseNumber(DEC, decNum.toString());
    }

    private BaseNumber convertDecOut(Base outBase) throws Exception {
        BigInteger decNum = new BigInteger(convertToDec().number);
        StringBuilder reverseResult = new StringBuilder();
        while (decNum.compareTo(BigInteger.ZERO) != 0) {
            int remainNum = decNum.mod(BigInteger.valueOf(outBase.getValue())).intValue();
            decNum = decNum.divide(BigInteger.valueOf(outBase.getValue()));
            switch (remainNum) {
                case 10:
                    reverseResult.insert(0, "A");
                    break;
                case 11:
                    reverseResult.insert(0, "B");
                    break;
                case 12:
                    reverseResult.insert(0, "C");
                    break;
                case 13:
                    reverseResult.insert(0, "D");
                    break;
                case 14:
                    reverseResult.insert(0, "E");
                    break;
                case 15:
                    reverseResult.insert(0, "F");
                    break;
                default:
                    reverseResult.insert(0, remainNum);
            }
        }
        if (reverseResult.toString().isEmpty()) {
            reverseResult.insert(0, "0");
        }
        BaseNumber result = new BaseNumber(outBase, reverseResult.toString());
        return result;
    }
}
