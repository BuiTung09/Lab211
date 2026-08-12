/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reverse.word;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acmon
 */
public class Reverse {
    public String printReverse(String input) {

        String[] words = input.trim().split("\\s+");

        // Lưu vị trí những từ có dấu chấm
        List<Integer> dotPosition = new ArrayList<>();

        // Bỏ dấu chấm ra khỏi từ
        for (int i = 0; i < words.length; i++) {
            if (words[i].endsWith(".")) {
                dotPosition.add(i);
                words[i] = words[i].substring(0, words[i].length() - 1);
            }
        }

        // Đảo mảng từ
        String[] reverse = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reverse[i] = words[words.length - 1 - i];
        }

        // Gắn lại dấu chấm
        // Nếu dấu chấm ở vị trí i của chuỗi gốc
        // thì sau khi đảo sẽ nằm ở vị trí n - i - 2
        for (Integer pos : dotPosition) {
            int newPos = words.length - pos - 2;

            if (newPos >= 0 && newPos < reverse.length) {
                reverse[newPos] += ".";
            }
        }

        // Ghép chuỗi
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reverse.length; i++) {
            result.append(reverse[i]);

            if (i != reverse.length - 1) {
                result.append(" ");
            }
        }

        // Chỉ viết hoa ký tự đầu tiên
        result.setCharAt(0,
                Character.toUpperCase(result.charAt(0)));

        return result.toString();
    }
}
