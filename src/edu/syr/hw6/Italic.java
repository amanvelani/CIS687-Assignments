package edu.syr.hw6;

public class Italic extends Element{
    private Element elem;

    public Italic(Element elem) {
        this.elem = elem;
    }


    @Override
    public String toString() {
        return elem.toString();
    }

    @Override
    public String toMarkdown() {
        return "*" + elem.toMarkdown() + "*";
    }
}
