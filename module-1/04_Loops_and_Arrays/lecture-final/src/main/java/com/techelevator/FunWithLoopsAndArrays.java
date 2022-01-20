package com.techelevator;

public class FunWithLoopsAndArrays {

    public static void main(String[] args) {

        String[] instructors = new String[5];

        System.out.println(instructors[0]);
        {
            instructors[0] = "John";
            instructors[1] = "Brian";
            instructors[2] = "Steve";
            instructors[3] = "Matt";
            instructors[4] = "Rachelle";
        }
        System.out.println(instructors[0]);

        instructors[0] = "The great and wonderful Corwin!!";

        System.out.println(instructors[0]);

        instructors[0] = instructors[0] + " handsome";

        System.out.println(instructors[0]);

        instructors[4] = "Doug";
        System.out.println(instructors[4]);

        //instructors[5] = "Something awesome!";

        int[] nums = new int[] {10, 20, 25, 15, 1};

        System.out.println("index 2: " + nums[2] + " index 4: " + nums[4]);

        nums[2] = nums[4];

        System.out.println("index 2: " + nums[2] + " index 4: " + nums[4]);

        nums[1] = nums[1] * nums[0];

        System.out.println(nums[1]);

        int sizeOfNumsArray = nums.length;

        System.out.println("This is the last element in the nums array: " + nums[sizeOfNumsArray -1]);

        {
            int x = 10;
            {
                int y = 20;
                System.out.println("Y is = to " + y);
                {
                    int z = 5;
                    y = y + z;
                    System.out.println(z);
                }

                System.out.println("Y is = to " + y);
            }
        }
    }



}
