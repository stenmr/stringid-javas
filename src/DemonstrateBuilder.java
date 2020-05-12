public class DemonstrateBuilder {
    public static void main(String[] args) {
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
}