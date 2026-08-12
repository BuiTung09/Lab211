package Main;


public class Main {

    public static void main(String[] args) {

        Validation validator = new Validation();
        LetterAndCharacterCount lc = new LetterAndCharacterCount();
        String input = validator.getString("Enter string: ");
      
        lc.countWords(input);
        lc.countCharacters(input);
    }
}
