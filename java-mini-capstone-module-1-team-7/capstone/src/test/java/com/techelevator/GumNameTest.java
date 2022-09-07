package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumNameTest{
    @Test
    public void gum_name_test(){
        Gum gum=new Gum();
        String gumName= gum.getGumName();
        String expected= "sourCreamGUM";
        Assert.assertEquals(expected,gumName);
    }

}
