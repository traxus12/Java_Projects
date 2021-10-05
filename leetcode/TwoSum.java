class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] retval = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        int test = nums[i] + nums[j];
        if (test == target && i!=j) {
          System.out.println("test: "+test+" "+"target: "+target + " i: " +i+" j: " +j);
          retval[0] = i;
          retval[1] = j;
          return retval;
        }
      }
    }
    return retval;
  }
}
