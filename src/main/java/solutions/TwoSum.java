package solutions;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<=nums.length-1; i++){
            for(int j=i+1 ; j<=nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumTwoPassMap(int[] nums, int target){
        Map<Integer, Integer> numbersToIndexMap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            numbersToIndexMap.put(nums[i], i);
        }

        for(int i=0; i<= nums.length; i++){
            int complement = target - nums[i];
            if(numbersToIndexMap.containsKey(complement) && numbersToIndexMap.get(complement) != i){
                return new int[] {i, numbersToIndexMap.get(complement)};
            }
        }
        return null;
    }

    public static int[] twoSumSinglePassMap(int[] nums, int target){
        Map<Integer, Integer> numbersToIndexMap = new HashMap<Integer, Integer>();

        for(int i=0; i< nums.length; i++){
            int complement = target - nums[i];
            if(!numbersToIndexMap.containsKey(complement)){
                numbersToIndexMap.put(nums[i], i);
            } else{
                return new int[]{numbersToIndexMap.get(complement), i};
            }
        }
        return null;
    }
}
