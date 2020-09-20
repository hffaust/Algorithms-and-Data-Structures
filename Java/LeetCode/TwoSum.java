// KEYWORDS: Amazon  hashmap  twosum

//public class TwoSum {
//}
/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


 */

/*
// optimal solution below

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(target - nums[i])){
                return new int[] {hash.get(target - nums[i]), i};
            }
            else{
                hash.put(nums[i], i);
            }
        }
        return null;
    }
}
 */


// My solution below
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        //int temp = 0;
        int targetcopy = target;
        int ret [] = new int [2];
        for(int i = 0; i < size; i++){
            // temp = nums[i];
            targetcopy = target - nums[i];
            for(int j = i+1; j < size; j++){
                if((targetcopy - nums[j]) == 0){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
            targetcopy = target;
        }
        return null;
    }
}

/*

// another, worse performing solution.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int ret [] = new int [2];
        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                if(nums[i]+nums[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return null;
    }
}
*/