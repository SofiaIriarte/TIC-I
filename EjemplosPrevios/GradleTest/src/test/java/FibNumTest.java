import org.junit.Assert;
import org.junit.Test;

public class FibNumTest {

    @Test
    public void FizzBuzzNormalNumbers() {

        FibNum fb = new FibNum();
        Assert.assertEquals("1", fb.convert(1));
        Assert.assertEquals("2", fb.convert(2));
    }

    @Test
    public void FizzBuzzThreeNumbers() {

        FibNum fb = new FibNum();
        Assert.assertEquals("Fizz", fb.convert(3));
    }

    @Test
    public void FizzBuzzFiveNumbers() {

        FibNum fb = new FibNum();
        Assert.assertEquals("Buzz", fb.convert(5));
    }

    @Test
    public void FizzBuzzThreeAndFiveNumbers() {

        FibNum fb = new FibNum();
        Assert.assertEquals("Buzz", fb.convert(5));
    }

}
