package com.kodilla.testing.forum.statistics;

public class ForumStats {

    private int userNumber;
    private int postNumber;
    private int commentNumber;
    private double averagePostsOnUser;
    private double averageCommentsOnUser;
    private double averageCommentsOnPost;

    public ForumStats(Statistics statistics) {
    }
    public void calculateAdvStatistics(Statistics statistics) {
        userNumber = statistics.usersNames().size();
        postNumber = statistics.postsCount();
        commentNumber = statistics.commentsCount();
        if (userNumber == 0) {
            averagePostsOnUser = 0;
            averageCommentsOnUser = 0;
        } else {
            averagePostsOnUser = (double) postNumber / userNumber;
            averageCommentsOnUser = (double) commentNumber / userNumber;
        }
        if (postNumber == 0) {
            averageCommentsOnPost = 0;
        } else {
            averageCommentsOnPost = (double) commentNumber / postNumber;
        }
    }

    public int getUserNumber() {
        return userNumber;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public double getAveragePostsOnUser() {
        return averagePostsOnUser;
    }

    public double getAverageCommentsOnUser() {
        return averageCommentsOnUser;
    }

    public double getAverageCommentsOnPost() {
        return averageCommentsOnPost;
    }

}