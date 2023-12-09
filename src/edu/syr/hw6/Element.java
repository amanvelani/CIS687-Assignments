/*
    Name: Aman Velani
    SUID: 982212915
*/
package edu.syr.hw6;

public class Element {
    String str;

    Element(String str) {
        if(str!=null)
            this.str = str;
        else
            this.str = "";
    }

    public String toHtml(){
        return this.str + " ";
    }
    @Override
    public String toString(){
        return this.str + " ";
    }
    public String toMarkdown(){
        return this.str + " ";
    }
}


