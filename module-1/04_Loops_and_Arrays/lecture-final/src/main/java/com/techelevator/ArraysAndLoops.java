package com.techelevator;

public class ArraysAndLoops {

    public static void main(String[] args) {

        /*
        What if we want to hold multiple values for a similar purpose?
        * */
        String instructor1 = "John";
        String instructor2 = "Brian";
        String instructor3 = "Steve";
        String instructor4 = "Matt";
        String instructor5 = "Rachelle";
        String instructor6 = "Dan";

        System.out.println("Please welcome all of our instructors!");
        System.out.println(instructor1 + "!");
        System.out.println(instructor2 + "!");
        System.out.println(instructor3 + "!");
        System.out.println(instructor4 + "!");
        System.out.println(instructor5 + "!");
        System.out.println(instructor6 + "!");

        /*
        Look at all that duplicated code! and unhelpful variable names. Everytime we need to refer
        to all of our instructors, we have to call every single variable.
        * */

        //What if we reassigned a single variable for each instructor?
        String instructor = "John";
        instructor = "Brian";
        instructor = "Steve";
        instructor = "Matt";
        instructor = "Rachelle";
        instructor = "Dan";

        System.out.println("Please reach out to our instructors with questions. They are: ");
        System.out.println(instructor);

        /*
        Now it appears that Dan is our only instructor. :(
        * */

        /*
        An array is a series of values of the same data type
        that are held together in a wrapper that can be treated as a single thing.

        Arrays are created using the new keyword and they are fixed in size.

        We pass in an integer value into the square brackets
        to set the size of the array when it is initialized.
        * */

        String[] instructors = new String[6];

        /*
        When we instantiate a new array, the items in the array assume a default value based
        on their data type.
        ex:
        String : null
        boolean : false
        double, float : 0.0
        byte, short, long, int, char : 0
        * */

        /*
        The items in the array are called elements.
        We can assign, access or update elements by the index of their position.
        Indexes start counting at 0.
        * */
        instructors[0] = "John";
        instructors[1] = "Brian";
        instructors[2] = "Steve";
        instructors[3] = "Matt";
        instructors[4] = "Rachelle";
        instructors[5] = "Dan";



        String greeting = "Hi " + instructors[1] + "!";
        System.out.println(greeting);

        /*
        Update the instructors array so that the first element
        is assigned to a new string.
        * */

        instructors[0] = "The great and wonderful Corwin!!";

        System.out.println(instructors[0]);


        /*
        Add more text to the existing string
        * */
        instructors[0] = instructors[0] + " handsome";

        System.out.println(instructors[0]);

        instructors[4] = "Doug";
        System.out.println(instructors[4]);

        //instructors[5] = "Something awesome!";

        /*
        Build an int[] called nums with the values {10, 20, 25, 15, 1}
        * */

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


        /*
            LOOPS
         */

        /*
            counter variable ; boolean condition that starts true ; change
         */
        for (int i = 0 ;  i < 10  ;  i++)
        {
            System.out.println(i);
        }

        int sum = 0;
        for (int i = 100; i <= 200; i++) {
            sum += i;
        }
        System.out.println(sum);

        for (int i = 29; i > 0; i--) {
            System.out.println(i);
        }

        for (int n = 321 ; n < 500; n += 3) {
            System.out.print(n + " ");
        }

        System.out.println();

        int sumOfEvens = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                sumOfEvens += i;
                System.out.println("i=" + i + " sumOfEvens=" + sumOfEvens);
            }
        }

        int[] numbers = new int[10];
        for(int ix = 0; ix < numbers.length; ix++) {
            numbers[ix] = ix * 2;
        }

        int result = numbers[3];


        for (int index = 0 ; index < instructors.length; index++) {
            System.out.println(instructors[index]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = nums[i] * 2;
        }

        for (int i = 0; i < instructors.length; i++) {
            System.out.println(instructors[i]);
            i++;
            if ((i + 1) < instructors.length) {
                System.out.println(instructors[i + 1]);
            }
        }

        /*
            This is a
            multiple line
            comment
         */

        // this is a single line only comment

        /*
            Basic for loop
         */
        // a variable to count ; boolean condition ; change )
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        int[] arrayOfNums = new int[] { 10, 20, 30 ,40, 50, 60, 70, 80, 90, 100 };

        /*
            Basic loop over an array
         */
        for (int i = 0; i < arrayOfNums.length; i++) {
            System.out.println( arrayOfNums[i] );
        }

        /*
            print the numbers, but if a number is multiple of 25 and the next value is
            multiple of 30 then we will skip both values
         */
        for (int n = 0; n < arrayOfNums.length; n++) {
            if ( (n < arrayOfNums.length - 1)
                    && (arrayOfNums[n] % 25 == 0 && arrayOfNums[ n + 1 ] % 30 == 0) ) {
                n++;
            } else {
                System.out.println(arrayOfNums[n]);
            }

        }

        /*
            print all the numbers, but skip just 50

            continue - ends the current iteration of the loop, but then continues
                       the rest of the loop
         */
        for (int n = 0; n < arrayOfNums.length; n++) {
            if (arrayOfNums[n] == 50) {
                continue;
            }
            System.out.println(arrayOfNums[n]);
        }


        /*
            print all the numbers, but stop at 50

            break - immediately ends the loop
         */
        for (int n = 0; n < arrayOfNums.length; n++) {
            if (arrayOfNums[n] == 50) {
                break;
            }
            System.out.println(arrayOfNums[n]);
        }

    }

}
