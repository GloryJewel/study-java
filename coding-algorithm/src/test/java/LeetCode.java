import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode {



    /*
    refactoring ddong code
    Use queue
     */

    /**
     * https://leetcode.com/problems/palindrome-number/
     * Determine whether an integer is a palindrome.
     * An integer is a palindrome when it reads the same backward as forward.
     * Follow up:Coud you solve it without converting the integer to a string?
     */
    @Test
    public void isPalindrome(){

        final int x = 121;
        final int divisor = 10;

        int quotient = x;
        int remainder = 0;
        double total = 0;

        Queue<Integer> integersQue = new LinkedList<Integer>();

        while(true){

            remainder = quotient % divisor;
            quotient = quotient / divisor;
            integersQue.offer(remainder);

            if(quotient == 0)
                break;
        }

        int power = integersQue.size()-1;

        while(!integersQue.isEmpty()){

            total += integersQue.poll() * Math.pow(10, power--);
        }

        assertEquals(121, total);
    }

    @Test
    public void test(){

        System.out.println(1 % 10);
        System.out.println(1 / 10);
    }

    @Test
    public void validParentheses(){

        final String s = "()";
        Stack<TOKEN> tokenStack = new Stack<>();

        for(char item : s.toCharArray()){
            TOKEN token = TOKEN.ValuOf(item);

            if(!tokenStack.empty() &&
                    tokenStack.peek().isCrash(token)){
                tokenStack.pop();
            }else{
                tokenStack.push(token);
            }
        }

        for(TOKEN token : tokenStack){
            System.out.println(token);
        }

        assertEquals(tokenStack.empty(), true);
    }

    enum TOKEN {
        CURLYLEFT('{', '}'),
        CURLYRIGHT('}', '{'),
        SQUARELEFT('[', ']'),
        SQUARERIGHT(']', '['),
        ROUNDLEFT('(', ')'),
        ROUNRIGHT(')', '('),
        EMPTY('*','*');

        private char tokenChar;
        private char tokenCrash;

        TOKEN(char tokenChar, char tokenCrash) {
            this.tokenChar = tokenChar;
            this.tokenCrash = tokenCrash;
        }

        static public TOKEN ValuOf(final char tokenChar){
            return Arrays.stream(TOKEN.values())
                    .filter(token -> token.tokenChar == tokenChar)
                    .findFirst()
                    .orElse(TOKEN.EMPTY);
        }

        public boolean isCrash(TOKEN tokenCrash){
           return this.tokenCrash == tokenCrash.tokenChar;
        }
    }

    @Test
    public void nonDecreasingArray(){

        int nums[] = {4,2,3};
//        //[4,2,3]
//
//        Arrays.stream(num).reduce((n1,n2)->{
//            if(n1 > n2){
//                updateCount++;
//                System.out.println(n1);
//            }
//
//            return n2;
//        });
//
//        assertEquals(updateCount < 2, true);

        int updateCount = 0;
        int beforeInt = 0;
        for(int i=0;i<nums.length-1;i++){

            if(nums[i]>nums[i+1]){

                if(beforeInt > nums[i+1]){
                    nums[i+1] = nums[i];
                }else{
                    nums[i] = nums[i+1];
                }
                updateCount++;
            }

            if(updateCount > 2)
                break;

            beforeInt = nums[i];
        }

        assertEquals(updateCount < 2, true);
//
//        IntTreeCompareInterface intTreeCompareInterface = (centerArray) ->{
//
//
//        };



    }

}