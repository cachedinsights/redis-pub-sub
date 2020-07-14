package com.stackfortech.redispubsub.configuration;

public interface MessagePublisher {
    void publish(String message);
}
