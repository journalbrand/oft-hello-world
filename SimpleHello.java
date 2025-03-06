/**
 * Simple Hello World program with name customization
 */
public class SimpleHello {
    /**
     * Entry point - processes args to determine greeting
     */
    public static void main(String[] args) {
        System.out.println(greeting(args));
    }

    /**
     * Generate appropriate greeting based on args
     */
    // [impl->req~hello-output~1]
    // [impl->req~custom-greeting~1]
    public static String greeting(String[] args) {
        if (args.length > 0 && args[0] != null && !args[0].trim().isEmpty()) {
            return "Hello, " + args[0] + "!";
        } else {
            return "Hello, World!";
        }
    }
} 