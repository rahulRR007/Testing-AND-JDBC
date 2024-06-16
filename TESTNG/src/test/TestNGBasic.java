package test;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGBasic {

    @Test
    public void testAddition() {
        int result = add(10, 17);
        Assert.assertEquals(result, 27, "Addition result is incorrect");
    }

    @Test
    public void testSubtraction() {
        int result = sub(10, 17);
        Assert.assertEquals(result, -7, "Subtraction result is incorrect");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

}
