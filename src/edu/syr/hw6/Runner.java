package edu.syr.hw6;

public class Runner {
    public static void main(String[] args) {
        Element[] pangram = new Element[9];
        pangram[0] = new TextElement("The");
        pangram[1] = new Italic(new TextElement("quick"));
        pangram[2] = new Bold(new TextElement("bold"));
        pangram[3] = new TextElement("fox");
        pangram[4] = new TextElement("jump");
        pangram[5] = new TextElement("over");
        pangram[6] = new TextElement("the");
        pangram[7] = new Strikethru(new TextElement("lazy"));
        pangram[8] = new TextElement("dog");
        StringBuffer justText = new StringBuffer();
        StringBuffer markdown = new StringBuffer();
        for (Element e: pangram) {
            justText.append(e.toString()).append(" ");
            markdown.append(e.toMarkdown()).append(" ");
        }
        System.out.println(justText.toString());
        // The quick bold fox jumps over the lazy dog
        System.out.println(markdown.toString());
        // The *quick* **bold** fox jumped over the ~~lazy~~ dog
    }
}
