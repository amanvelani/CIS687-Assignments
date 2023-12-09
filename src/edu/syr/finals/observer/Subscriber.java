package edu.syr.finals.observer;

public class Subscriber implements Observer{
    private String name;
    private Channel channel = new Channel();

    public Subscriber(String name){
        this.name = name;
    }
    @Override
    public void update(Subject subject) {
        System.out.println("Hey " + name + ", Video Uploaded");
    }

    @Override
    public void subscribeChannel(Channel channel) {
        channel = channel;
    }
}
