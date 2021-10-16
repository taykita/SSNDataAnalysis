package ru.booknetwork.ssn.data.analysis.controllers;

public class StatisticDTO {
    private int accountsCreated;
    private int postsCreated;
    private int messagesSent;
    private int friendsAdded;

    public int getAccountsCreated() {
        return accountsCreated;
    }

    public void setAccountsCreated(int accountsCreated) {
        this.accountsCreated = accountsCreated;
    }

    public int getPostsCreated() {
        return postsCreated;
    }

    public void setPostsCreated(int postsCreated) {
        this.postsCreated = postsCreated;
    }

    public int getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(int messagesSent) {
        this.messagesSent = messagesSent;
    }

    public int getFriendsAdded() {
        return friendsAdded;
    }

    public void setFriendsAdded(int friendsAdded) {
        this.friendsAdded = friendsAdded;
    }
}
