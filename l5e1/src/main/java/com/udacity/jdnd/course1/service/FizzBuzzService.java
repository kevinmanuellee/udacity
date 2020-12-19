package com.udacity.jdnd.course1.service;

public class FizzBuzzService {

    /**
     * If number is divisible by 3, return "Fizz". If divisible by 5,
     * return "Buzz", and if divisible by both, return "FizzBuzz". Otherwise,
     * return the number itself.
     *
     * @Throws IllegalArgumentException for values < 1
     */
    public String fizzBuzz(int number) {
        int divisibleBy3 = number % 3; // 0 Equal to True, Otherwise False
        int divisibleBy5 = number % 5; // 0 Equal to True, Otherwise False
        int divisibleByBoth = divisibleBy3 + divisibleBy5; // 0 Equal to True, Otherwise False
        boolean illegalArgument = number < 1;

        if (illegalArgument){
            throw new IllegalArgumentException();
        } else if (divisibleByBoth == 0) {
            return "FizzBuzz";
        } else if (divisibleBy3 == 0){
            return "Fizz";
        } else if (divisibleBy5 == 0){
            return "Buzz";
        }

        return String.valueOf(number);
    }
}
