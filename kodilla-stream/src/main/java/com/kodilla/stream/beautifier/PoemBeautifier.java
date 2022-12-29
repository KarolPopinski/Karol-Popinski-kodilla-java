package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String sthText, PoemDecorator poemDecorator) {
        String beautifiedText = poemDecorator.decorate(sthText);
        System.out.println(beautifiedText);
    }
}
