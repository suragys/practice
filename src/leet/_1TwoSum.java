package leet;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
public class _1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if(m.containsKey(nums[i])){
                res[0] = m.get(nums[i]);
                res[1] = i;
                break;
            } else {
                m.put(r, i);
            }
        }
        return res;
        //123456
//        int[] result = new int[2];
        // for(int i=0;i<nums.length;i++){
        //     boolean found=false;
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             result[0]=i;
        //             result[1]=j;
        //             found=true;
        //             break;
        //         }
        //     }
        //     if(found){
        //         break;
        //     }
        // }

//        int left = 0;
//        int right = nums.length - 1;
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        boolean found = false;
//        while (!found) {
//            int sum = nums[left] + nums[right];
//            if (sum == target) {
//                result[0] = left;
//                result[1] = right;
//                found = true;
//            } else if (sum > target) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return result;

    }

    public static void main(String[] args) {
        _1TwoSum s = new _1TwoSum();

        int[] nums = {3,2,4};
        int[] r = s.twoSum(nums, 6);
        System.out.println(Arrays.toString(r));

        Pair<Integer, Integer> p = new Pair<>(1,2);
        int i = p.fst;
        int j = p.snd;



    }

}
