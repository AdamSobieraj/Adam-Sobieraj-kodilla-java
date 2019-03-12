package com.kodilla.good.patterns.challenges.Task3.ImputDataValidation;

public class ImputValidator {

    private ImputValidator(){
    }

    public static void validateString(String arg, String message){
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /*
    Stream of(T… values) returns a sequential ordered stream whose elements are the specified values.
    A sequential stream work just like for-loop using a single core. On the other hand, a Parallel
    stream divide the provided task into many and run them in different threads,
    utilizing multiple cores of the computer.

    Syntax :

    static <T> Stream<T> of(T... values)

    Where, Stream is an interface and T
    is the type of stream elements.
    values represents the elements of the
    new stream and the function
    returns the new stream.
     */

    public static <T> void validateNotEmpty(T arg, String message){
        if (arg == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateTrue(boolean expr, String message){
        if (!expr) {
            throw new IllegalArgumentException(message);
        }
    }
}
