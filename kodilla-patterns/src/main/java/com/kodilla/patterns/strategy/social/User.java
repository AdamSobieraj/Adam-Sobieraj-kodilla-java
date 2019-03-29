package com.kodilla.patterns.strategy.social;

public class User {
    final private String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String share() {
        return socialPublisher.share();
    }

    public void setSharePost(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
