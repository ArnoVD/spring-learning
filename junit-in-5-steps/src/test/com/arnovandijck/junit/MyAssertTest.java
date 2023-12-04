package test.com.arnovandijck.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

    @Test
    public void test(){
        boolean test = todos.contains("Learn Spring MVC");
        assertTrue(test, "Something went wrong");
        assertEquals(3, todos.size(), "Error message");
        assertFalse(todos.isEmpty(), "Error message");
        assertNull(null, "Error message");
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Error message");
    }
}
