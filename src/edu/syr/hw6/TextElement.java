package edu.syr.hw6;

public class TextElement extends Element {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public String toMarkdown() {
        return text;
    }
}
