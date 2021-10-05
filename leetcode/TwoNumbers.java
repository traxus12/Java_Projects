/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = 
next; }
 * }
 */

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode firstList = l1;
    int leftVal = 0;
    int place = 1;
    while (firstList != null) {
      int x = firstList.val;
      int base = 10, exponent = place;
      int result = 1;
      while (exponent != 0) {
        result *= base;
        --exponent;
      }
      leftVal = leftVal + x * result;
      place = place + 1;
      if (firstList != null) {
        firstList = firstList.next;
      }
    }
    leftVal = leftVal /10;
    System.out.println(leftVal);
      
    ListNode secondList = l2;
    int rightVal = 0;
    place = 1;
    while (secondList != null) {
      int x = secondList.val;
      int base = 10, exponent = place;
      int result = 1;
      while (exponent != 0) {
        result *= base;
        --exponent;
      }
      rightVal = rightVal + x * result;
      place = place + 1;
      if (secondList != null) {
        secondList = secondList.next;
      }
    }
    rightVal = rightVal /10;
    System.out.println(rightVal);
    int sum = leftVal + rightVal;
    ListNode retvalled = new ListNode(0);
    ListNode retval = retvalled;
    String s = String.valueOf(sum);
    char[] ch = new char[s.length()];
    System.out.println(sum);
    for (int i = 0; i < s.length(); i++) {
         ch[i] = s.charAt(i);
    }
    for(int i = s.length()-1; i >= 0; i--){
        int a=Character.getNumericValue(ch[i]);
        retval.next = new ListNode(a);
        retval = retval.next;
    }
    return retvalled.next;
  }
}
