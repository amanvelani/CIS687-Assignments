package edu.syr.finals.observer;

public interface Observer {
    void update(Subject subject);
    void subscribeChannel(Channel channel);
}
