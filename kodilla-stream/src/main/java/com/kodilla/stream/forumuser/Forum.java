package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {
        forumUsers.add(new ForumUser(1,"Tom",'M',LocalDate.of(2014,04,02),2));
        forumUsers.add(new ForumUser(2,"Kasia",'F',LocalDate.of(2004,04,02),78));
        forumUsers.add(new ForumUser(3,"Jon",'M',LocalDate.of(1988,04,04),7));
        forumUsers.add(new ForumUser(4,"Ron",'M',LocalDate.of(1990,04,07),20));
        forumUsers.add(new ForumUser(5,"Rob",'M',LocalDate.of(2010,04,02),3));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(forumUsers);
    }


}
