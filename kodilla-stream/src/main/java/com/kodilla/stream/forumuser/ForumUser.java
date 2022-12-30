package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final String userName;
    private final char userSex;

    private final LocalDate userBirthDate;

    private final int userNumberOfPosts;

    private final int userUniqueID;

    public ForumUser(final String userName, final char userSex, final int userNumberOfPosts, final int userUniqueID, final int year, final int month, final int day) {
        this.userName = userName;
        this.userSex = userSex;
        this.userNumberOfPosts = userNumberOfPosts;
        this.userUniqueID = userUniqueID;
        this.userBirthDate = LocalDate.of(year, month, day);
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public int getUserNumberOfPosts() {
        return userNumberOfPosts;
    }

    public int getUserUniqueID() {
        return userUniqueID;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userBirthDate=" + userBirthDate +
                ", userNumberOfPosts=" + userNumberOfPosts +
                ", userUniqueID=" + userUniqueID +
                '}';
    }
}
