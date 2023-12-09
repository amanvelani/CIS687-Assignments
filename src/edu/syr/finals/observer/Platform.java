package edu.syr.finals.observer;

public class Platform {
    public static void main(String[] args){
        Channel channel = new Channel();
        Subscriber s1 = new Subscriber("John");
        Subscriber s2 = new Subscriber("Doe");
        Subscriber s3 = new Subscriber("Jane");
        Subscriber s4 = new Subscriber("Aayush");
        Subscriber s5 = new Subscriber("Aman");

        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);
        channel.subscribe(s4);
        channel.subscribe(s5);

        s1.subscribeChannel(channel);
        s2.subscribeChannel(channel);
        s3.subscribeChannel(channel);
        s4.subscribeChannel(channel);
        s5.subscribeChannel(channel);

        channel.upload("How to learn Java");
    }
}
