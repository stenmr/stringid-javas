import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("StringBuilder: " + stringBuilderConcat(1_000_000_000, "") + "ms");
        System.out.println("StringBuffer: " + stringBufferConcat(1_000_000_000, "") + "ms");
        System.out.println("String.concat(\"\"): " + simpleConcat(1_000_000_000, "") + "ms");
        System.out.println("String.concat(\"s\"): " + simpleConcat(500_000, "s") + "ms");
        
        // StringBuffer is mutable by any type of changes in the existing object
        StringBuffer sbf = new StringBuffer("Henry");
        sbf.append(" is a nice guy");
        sbf.replace(6, 8, "is not");
        System.out.println(sbf);
        sbf.delete(5, 12);
        sbf.replace(6, 6, "is ");
        sbf.reverse();
        System.out.println(sbf);
        
        // why to use equal() instead of == when you want to compare Strings
        // == address comparison
        // equals() content comparison
        String s1 = new String("HELLO");
        String s2 = new String("HELLO");
        System.out.println("HELLO == HELLO: " + s1 == s2);
        System.out.println("s1.equals(s2): " + s1.equals(s2));
    }

    public static long simpleConcat(int amount, String append) {
        String test = new String("test");

        LocalTime beforeTime = LocalTime.now();

        for (int i = 0; i < amount; i++) {
            test = test.concat(append);
        }
        return beforeTime.until(LocalTime.now(), ChronoUnit.MILLIS);
    }

    public static long stringBuilderConcat(int amount, String append) {
        StringBuilder test = new StringBuilder("test");

        LocalTime beforeTime = LocalTime.now();

        for (int i = 0; i < amount; i++) {
            test.append(append);
        }
        return beforeTime.until(LocalTime.now(), ChronoUnit.MILLIS);
    }

    public static long stringBufferConcat(int amount, String append) {
        StringBuffer test = new StringBuffer("test");

        LocalTime beforeTime = LocalTime.now();

        for (int i = 0; i < amount; i++) {
            test.append(append);
        }

        return beforeTime.until(LocalTime.now(), ChronoUnit.MILLIS);
    }
}
