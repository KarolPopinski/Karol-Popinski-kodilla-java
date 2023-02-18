package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User lewis = new Millenials("SmallLewis");
        User valtteri = new YGeneration("Val39");
        User fernando = new ZGeneration("SuperFernando");

        //When
        String lewisPosted = lewis.sharePost();
        System.out.println("Posted on: " + lewisPosted);
        String valtteriPosted = valtteri.sharePost();
        System.out.println("Posted on: " + valtteriPosted);
        String fernandoPosted = fernando.sharePost();
        System.out.println("Posted on: " + fernandoPosted);

        //Then
        assertEquals("TWITTER", lewisPosted);
        assertEquals("FACEBOOK", valtteriPosted);
        assertEquals("SNAPCHAT", fernandoPosted);
    }
    @Test
    void testIndividualSharingsStrategy() {
        //Given
        User valtteri = new YGeneration("Val39");

        //When
        String valtteriPosted = valtteri.sharePost();
        System.out.println("Posted on: " + valtteriPosted);
        valtteri.setShareStrategy(new SnapchatPublisher());
        valtteriPosted = valtteri.sharePost();
        System.out.println("Posted on: " + valtteriPosted);

        //Then
        assertEquals("SNAPCHAT", valtteriPosted);

    }
}
