import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("StringBuilder: " + stringBuilderConcat(1_000_000_000, "") + "ms");

        System.out.println("StringBuffer: " + stringBufferConcat(1_000_000_000, "") + "ms");

        System.out.println("String.concat(\"\"): " + simpleConcat(1_000_000_000, "") + "ms");

        System.out.println("String.concat(\"s\"): " + simpleConcat(100_000, "s") + "ms");
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
