package edu.syr.hw6;

public class Bold extends Element{
    private Element elem;

    public Bold(Element elem) {
        this.elem = elem;
    }

    @Override
    public String toString() {
        return elem.toString();
    }

    @Override
    public String toMarkdown() {
        return "**" + elem.toMarkdown() + "**";
    }
}
