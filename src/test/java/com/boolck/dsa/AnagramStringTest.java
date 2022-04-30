package com.boolck.dsa;

import org.junit.Assert;
import org.junit.Test;

public class AnagramStringTest {

    AnagramString instance = new AnagramString();

    @Test
    public void testValidAnagram(){
        String a = "cinema";
        String b = "iceman";
        Assert.assertTrue(instance.areTwoStringsAnagram(a,b));
    }

    @Test
    public void testInvalidAnagram(){
        String a = "cinema";
        String b = "random";
        Assert.assertFalse(instance.areTwoStringsAnagram(a,b));
    }

    @Test
    public void testNullString(){
        Assert.assertFalse(instance.areTwoStringsAnagram(null,"test"));
    }

    @Test
    public void testUnequalString(){
        Assert.assertFalse(instance.areTwoStringsAnagram("estte","test"));
    }
}
