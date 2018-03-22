package solutions;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2,7,11,27,30};
        TwoSum twoSum = new TwoSum();
        //int[] result = twoSum.twoSum(nums, 9);
        //int[] result = twoSum.twoSumTwoPassMap(nums, 9);
        int[] result = twoSum.twoSumSinglePassMap(nums, 9);
        if(result != null)
            System.out.println(result[0] + ", " +result[1]);
        else
            System.out.println("Given set of numbers do not have 2 numbers whose sum is 9");
    }
}
