package solutions;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void twoSum(){
        int[] testInput = {2,5,3,8,9};
        int target = 5;

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(testInput, target);

        assertThat(result[0], is(0));
        assertThat(result[1], is(2));

        int[] result_1 = twoSum.twoSumTwoPassMap(testInput, target);

        assertThat(result_1[0], is(0));
        assertThat(result_1[1], is(2));

        int[] result_2 = twoSum.twoSumSinglePassMap(testInput, target);

        assertThat(result_2[0], is(0));
        assertThat(result_2[1], is(2));

    }
}
