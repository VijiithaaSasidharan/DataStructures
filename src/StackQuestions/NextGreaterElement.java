package StackQuestions;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        int arr[]={1,3,2,4};

        int[] result=nextGreater(arr);
        Arrays.stream(result).forEach(System.out::println);

    }


    public static int[] nextGreater(int[] nums) {
        /*

         AIM : is to find the next greater element in the array from the current element

         1.Create a empty array with the same size as the input array
         2. create a stack ( to push the elements from the array)

         Steps:
            Iterate the array from the last
         1. check if the stack is empty, if true, add -1 to the new array
         2. if the stack is not empty
            A) and the element on the top of the array is greater than the current element -> then that is the next greater element
                push that element to the new array
            B) and the element on the top is less than or equal to the current element ->
                create a while loop, iterate & pop until the element in stack is greater
                (i) if the stack is empty-> push -1 to new array
                (ii) else push the element from the top of the array
         3. push the current element to the stack

         */
        Stack<Integer> stack=new Stack<>();
        int[] result = new int[nums.length];

        for (int i=nums.length-1;i>=0;i--){

            if (stack.empty()){
                result[i]=-1;
            }
            else if(stack.size()!=0 && stack.peek()>nums[i]){
                result[i]= stack.peek();
            }
            else if (stack.size()!=0 && stack.peek()<=nums[i]){
                while (stack.size()!=0 && stack.peek()<=nums[i]){
                    stack.pop();
                }
                if (stack.empty()){
                    result[i]=-1;
                }else {
                    result[i]=stack.peek();
                }
            }
            stack.push(nums[i]);
        }

        return result;
    }
}