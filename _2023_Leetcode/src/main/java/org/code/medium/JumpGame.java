package org.code.medium;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 4, 5, 3, 2, 1}));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int[] mem = new int[nums.length];
        return jump(nums, 0, mem);
    }

    public static boolean jump(int[] nums, int idx, int[] mem) {
        if (idx >= nums.length - 1) return true;
        if (mem[idx] == 1) return true;
        if (mem[idx] == -1) return false;

        int nextJumps = nums[idx];
        int start = idx + 1;
        int end = idx + nextJumps;

        for (int itr = start; itr <= end; itr++) {
            mem[idx] = jump(nums, itr, mem) ? 1 : -1;
            if (mem[idx] == 1) return true;
        }

        return false;
    }
}
