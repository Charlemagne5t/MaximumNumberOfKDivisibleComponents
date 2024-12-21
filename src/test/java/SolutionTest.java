import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int n = 5;
        int[][] edges = {
                {0,2},
                {1,2},
                {1,3},
                {2,4},
        };
        int[] values = {1,8,1,4,4};
        int k = 6;
        int expected = 2;
        int actual = new Solution().maxKDivisibleComponents(n, edges, values, k);

        Assert.assertEquals(expected, actual);
    }
}
