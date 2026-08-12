/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

;
public class LetterAndCharacterCount {


    public void countWords(String input) {
        Map<String, Integer> wordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input,  " ,./\\:;!?()[]{}\"'-");
        while (st.hasMoreTokens()) {
            String word = st.nextToken().toLowerCase();
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        System.out.println(wordMap);
    }

    public void countCharacters(String input) {
        Map<Character, Integer> charMap = new TreeMap<>();
        input = input.toLowerCase();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                } else {
                    charMap.put(c, 1);
                }
            }
        }
        System.out.println(charMap);
    }

}
