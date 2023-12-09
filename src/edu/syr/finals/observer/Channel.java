package edu.syr.finals.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject{
    String title;
    private List<Subscriber> subs = new ArrayList<>();
    @Override
    public void subscribe(Observer observer) {
        subs.add((Subscriber) observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subs.remove((Subscriber) observer);
    }

    @Override
    public void notifyObservers() {
        for(Subscriber observer: subs){
            observer.update(this);
        }
    }

    public void upload(String title){
        this.title = title;
        System.out.println("Video Uploaded: " + this.title);
        notifyObservers();
    }

    @Override
    public String getTitle() {
        return title;
    }

}
