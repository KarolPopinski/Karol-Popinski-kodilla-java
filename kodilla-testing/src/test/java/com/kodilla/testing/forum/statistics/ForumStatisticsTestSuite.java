package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Statistic Forum")
class ForumStatisticsTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test#" + testCounter);
    }

    @Mock
    Statistics statisticsMock;

    private List<String> generateUsersList(int numberOfUsers) {
        List<String> listOfUsers = new ArrayList<>();

        for (int i = 0; i < numberOfUsers; i++) {
            listOfUsers.add("user" + i);
        }
        return listOfUsers;
    }
    private int generatePostsNumber(int givenPosts) {
        int numberOfPosts = givenPosts;

        return numberOfPosts;
    }
    private int generateCommentsNumber(int givenComments) {
        int numberOfComments = givenComments;

        return numberOfComments;
    }
    @Nested
    class testPosts {

        @Test
        void test0Posts() {
            //Given
            ForumStats forumStats = new ForumStats(statisticsMock);

            List<String> listOfUsers = generateUsersList(20);
            int postsN = generatePostsNumber(0);
            when(statisticsMock.usersNames()).thenReturn(listOfUsers);
            when(statisticsMock.postsCount()).thenReturn(postsN);

            //When
            forumStats.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, forumStats.getAveragePostsOnUser());
            assertEquals(0, forumStats.getAverageCommentsOnUser());
            assertEquals(0, forumStats.getAverageCommentsOnPost());
        }

        @Test
        void test1000Posts() {
            //Given
            ForumStats forumStats = new ForumStats(statisticsMock);

            List<String> listOfUsers = generateUsersList(20);
            int postsN = generatePostsNumber(1000);
            when(statisticsMock.usersNames()).thenReturn(listOfUsers);
            when(statisticsMock.postsCount()).thenReturn(postsN);

            //When
            forumStats.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(50, forumStats.getAveragePostsOnUser());
            assertEquals(0, forumStats.getAverageCommentsOnUser());
            assertEquals(0, forumStats.getAverageCommentsOnPost());
        }
    }
    @Nested
    class TestComments {

        @Test
        void test0Comments() {
            //Given
            ForumStats forumStats = new ForumStats(statisticsMock);

            List<String> listOfUsers = generateUsersList(20);
            int postsN = generatePostsNumber(1000);
            int commentsN = generateCommentsNumber(0);

            when(statisticsMock.usersNames()).thenReturn(listOfUsers);
            when(statisticsMock.postsCount()).thenReturn(postsN);
            when(statisticsMock.commentsCount()).thenReturn(commentsN);

            //When
            forumStats.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(50, forumStats.getAveragePostsOnUser());
            assertEquals(0, forumStats.getAverageCommentsOnUser());
            assertEquals(0, forumStats.getAverageCommentsOnPost());
        }

        @Test
        void testLessCommentsThanPosts() {
            //Given
            ForumStats forumStats = new ForumStats(statisticsMock);

            List<String> listOfUsers = generateUsersList(20);
            int postsN = generatePostsNumber(1000);
            int commentsN = generateCommentsNumber(100);

            when(statisticsMock.usersNames()).thenReturn(listOfUsers);
            when(statisticsMock.postsCount()).thenReturn(postsN);
            when(statisticsMock.commentsCount()).thenReturn(commentsN);

            //When
            forumStats.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(50.0, forumStats.getAveragePostsOnUser());
            assertEquals(5.0, forumStats.getAverageCommentsOnUser());
            assertEquals(0.1, forumStats.getAverageCommentsOnPost());
        }

        @Test
        void testMoreCommentsThanPosts() {
            //Given
            ForumStats forumStats = new ForumStats(statisticsMock);

            List<String> listOfUsers = generateUsersList(20);
            int postsN = generatePostsNumber(100);
            int commentsN = generateCommentsNumber(1000);

            when(statisticsMock.usersNames()).thenReturn(listOfUsers);
            when(statisticsMock.postsCount()).thenReturn(postsN);
            when(statisticsMock.commentsCount()).thenReturn(commentsN);

            //When
            forumStats.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(5.0, forumStats.getAveragePostsOnUser());
            assertEquals(50.0, forumStats.getAverageCommentsOnUser());
            assertEquals(10.0, forumStats.getAverageCommentsOnPost());
        }
    }
    @Nested
    class TestUser {

        @Test
        void test0Users() {
            //Given
            ForumStats forumStats = new ForumStats(statisticsMock);

            List<String> listOfUsers = generateUsersList(0);

            when(statisticsMock.usersNames()).thenReturn(listOfUsers);

            //When
            forumStats.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0.0, forumStats.getAveragePostsOnUser());
            assertEquals(0.0, forumStats.getAverageCommentsOnUser());
            assertEquals(0.0, forumStats.getAverageCommentsOnPost());
        }

        @Test
        void test100Users() {
            //Given
            ForumStats forumStats = new ForumStats(statisticsMock);

            List<String> listOfUsers = generateUsersList(100);

            when(statisticsMock.usersNames()).thenReturn(listOfUsers);

            //When
            forumStats.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0.0, forumStats.getAveragePostsOnUser());
            assertEquals(0.0, forumStats.getAverageCommentsOnUser());
            assertEquals(0.0, forumStats.getAverageCommentsOnPost());
        }
    }
}