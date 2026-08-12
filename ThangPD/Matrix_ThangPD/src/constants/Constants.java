package constants;

/**
 * Chứa các hằng số, enum dùng chung trong toàn chương trình.
 */
public class Constants {

    private Constants() {
    }

    public static final int MIN_DIMENSION = 1;
    public static final int MAX_DIMENSION = Integer.MAX_VALUE;
    public static final int MIN_MENU_CHOICE = 1;
    public static final int MAX_MENU_CHOICE = 4;

    public enum MenuChoice {
        ADDITION(1),
        SUBTRACTION(2),
        MULTIPLICATION(3),
        QUIT(4);

        private final int code;

        MenuChoice(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static MenuChoice fromCode(int code) {
            for (MenuChoice m : values()) {
                if (m.code == code) {
                    return m;
                }
            }
            return null;
        }
    }
}
