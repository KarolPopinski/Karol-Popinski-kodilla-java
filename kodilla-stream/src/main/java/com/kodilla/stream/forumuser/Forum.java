package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser("XBold28", 'M', 1, 10101, 2002, 12, 30));
        theForumUserList.add(new ForumUser("jenny78", 'F', 10, 10102, 1985, 10, 5));
        theForumUserList.add(new ForumUser("ToonyX", 'M', 95, 10103, 1965, 5, 28));
        theForumUserList.add(new ForumUser("SweetEmy", 'F', 5, 10104, 2000, 7, 10));
        theForumUserList.add(new ForumUser("Ellen45", 'F', 15, 10105, 2010, 9, 12));
        theForumUserList.add(new ForumUser("Mike78", 'M', 38, 10106, 1978, 3, 8));
        theForumUserList.add(new ForumUser("TheWild", 'M', 54, 10107, 2011, 8, 17));
        theForumUserList.add(new ForumUser("GepWarty", 'F', 19, 10108, 2008, 11, 3));
    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(theForumUserList);
    }
}
