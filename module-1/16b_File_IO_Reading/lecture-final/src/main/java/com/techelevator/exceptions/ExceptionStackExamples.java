package com.techelevator.exceptions;

import java.util.Locale;

public class ExceptionStackExamples {

    public static void main(String[] args) {


//        try {
        String upperCased = methodA("abc");
//        } catch (NullPointerException e) {
//            System.out.println("String was null");
//        }

    }


    private static String methodA(String str) {
        return methodB(str);
    }

    private static String methodB(String str) {
        return methodC(str);
    }

    /*
    Exceptions when thrown can be caught in any method in the current
    call stack.  They do not need to be caught here, but can be caught in methods
    that call this method.
     */
    private static String methodC(String str) {
        Integer.parseInt(str);
        return str.toUpperCase();
    }

}
