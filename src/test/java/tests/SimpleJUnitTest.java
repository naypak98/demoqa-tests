package tests;

import org.junit.jupiter.api.*;



public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n###  Before All\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###  Before each");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###  After each\n");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("###  After All\n");
    }


    @Test
    void firstTest() {

        System.out.println("###   First Test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {

        System.out.println("###   Second Test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {

        System.out.println("###   Third Test");
        Assertions.assertTrue(result > 2);
    }


    private int getResult() {
        return 3;
    }
}
