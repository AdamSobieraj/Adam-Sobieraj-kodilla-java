package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final Integer userID;
    private final String userName;
    private final char gender;
    private final LocalDate birthDate;
    private final Integer postCount;

    public ForumUser(Integer userID, String userName, char gender, LocalDate birthDate, Integer postCount) {
        this.userID = userID;
        this.userName = userName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.postCount = postCount;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{"+ "UserID " + userID + " UserName " + userName+
    " Gender " + gender + " Birth Date "+birthDate + " Post count " + postCount +"}";
    }
}
