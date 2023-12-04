package test.com.arnovandijck.junit;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach executed");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll executed");
    }

    @Test
    public void test1() {
        System.out.println("test1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    @Test
    public void test3() {
        System.out.println("test3 executed");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach executed");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll executed");
    }
}
