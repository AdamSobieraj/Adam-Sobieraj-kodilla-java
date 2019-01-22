package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String s, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(s);
        System.out.println("Result equals: " + result);
    }
}
