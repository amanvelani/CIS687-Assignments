/*
    Name: Aman Velani
    SUID: 982212915
*/
package edu.syr.hw6;

public class Runner {
    public static void main(String[] args) {
        Element[] pangram = new Element[9];
        pangram[0] = new Element("The");
        pangram[1] = new Italic("quick");
        pangram[2] = new Bold("bold");
        pangram[3] = new Element("fox");
        pangram[4] = new Element("jumps");
        pangram[5] = new Element("over");
        pangram[6] = new Element("the");
        pangram[7] = new Strikethru("lazy");
        pangram[8] = new Element("dog");
        StringBuffer justText = new StringBuffer();
        StringBuffer markdown = new StringBuffer();
        StringBuffer htmlDown = new StringBuffer();
        for (Element e: pangram) {
            justText.append(e.toString());
            markdown.append(e.toMarkdown());
            htmlDown.append(e.toHtml());
        }
        System.out.println(justText.toString());
        // The quick bold fox jumps over the lazy dog
        System.out.println(markdown.toString());
        // The *quick* **bold** fox jumped over the ~~lazy~~ dog
        System.out.println(htmlDown.toString().trim());
        // The <i>quick</i> <b>bold</b> fox jumped over the <s>lazy</s> dog
    }
}
