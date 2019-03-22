package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User steven = new Millenials("Steven Links");
        User john = new YGeneration("John Hemerald");
        User kodilla = new ZGeneration("Kodilla");

        //When
        String stevenMedia = steven.share();
        System.out.println("Steven should: " + stevenMedia);
        String johnMedia = john.share();
        System.out.println("John should: " + johnMedia);
        String kodillaMedia = kodilla.share();
        System.out.println("Kodilla should: " + kodillaMedia);

        //Then
        Assert.assertEquals("Snapchat", stevenMedia);
        Assert.assertEquals("Facebook", johnMedia);
        Assert.assertEquals("Twitter", kodillaMedia);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User steven = new YGeneration("Steven Links");

        //When
        String stevenMedia = steven.share();
        System.out.println("Steven should: " + stevenMedia);
        steven.setSharePost(new TwitterPublisher());
        stevenMedia = steven.share();
        System.out.println("Steven now should: " + stevenMedia);

        //Then
        Assert.assertEquals("Twitter", stevenMedia);
    }
}
