package test.com.arnovandijck.junit;

import com.arnovandijck.junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {

    private final MyMath myMath = new MyMath();

    @Test
    public void calculateSum_FiveMemberArray() {
        assertEquals(15, myMath.calculateSum(new int[] { 1, 2, 3, 4, 5 }));
    }

    @Test
    public void calculateSum_EmptyArray() {
        assertEquals(0, myMath.calculateSum(new int[] {}));
    }
}
