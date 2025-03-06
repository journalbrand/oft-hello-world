/**
 * Unit test for SimpleHello
 */
public class SimpleHelloTest {
    
    /**
     * Test the default greeting
     */
    // [utest->req~hello-output~1]
    public static void testDefaultGreeting() {
        String result = SimpleHello.greeting(new String[0]);
        assert "Hello, World!".equals(result) : "Default greeting should be 'Hello, World!'";
        System.out.println("Default greeting test passed!");
    }

    /**
     * Test the custom greeting
     */
    // [utest->req~custom-greeting~1]
    public static void testCustomGreeting() {
        String result = SimpleHello.greeting(new String[] {"Jane"});
        assert "Hello, Jane!".equals(result) : "Custom greeting should be 'Hello, Jane!'";
        System.out.println("Custom greeting test passed!");
    }

    /**
     * Main method to run the tests
     */
    public static void main(String[] args) {
        testDefaultGreeting();
        testCustomGreeting();
        System.out.println("All tests passed!");
    }
} 