/*
    Name: Aman Velani
    SUID: 982212915
*/
package edu.syr.hw6;

public class Italic extends Element{
    private Element elem;

    public Italic(String s) {
        super(s);
        this.elem = new Element(s);
    }

    public Italic(Element elem){
        super(elem.str);
        this.elem = elem;
    }
    @Override
    public String toString() {
        return elem.toString();
    }

    @Override
    public String toMarkdown() {
        return "*" + elem.toMarkdown().trim() + "* ";
    }
    @Override
    public String toHtml() {
        return "<i>" + elem.toHtml().trim() + "</i> ";
    }
}
