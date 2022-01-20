package com.techelevator;

public class ArrayAndLoops {

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
        is assigned to "The John Fulton".
        * */

        instructors[0] = "The John Fulton";

        /*
        Build an int[] called nums with the values {10, 20, 25, 15, 1}
        * */

        int[] nums = new int[] {10, 20, 25, 15, 1};
        System.out.println(nums[3]);

    }
}
