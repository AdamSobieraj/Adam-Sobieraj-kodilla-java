package stream.array;

import com.kodilla.stream.array.ArrayOperations;
import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int numbers[] = {1,2,3,4,5,6,7,8,9,22,33,44};
        double expected = 12.0;
        //When
        double resoult = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(expected,resoult, 0.01);

    }

}
