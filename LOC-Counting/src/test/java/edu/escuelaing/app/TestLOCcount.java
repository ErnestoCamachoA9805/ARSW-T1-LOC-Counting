package edu.escuelaing.app;

import java.io.*;
import junit.framework.*;

public class TestLOCcount extends TestCase{

    /**
     * Test that the amount of lines is correct in the phyCount 
     */
    public void testphyCountArchive(){
        File file= new File("./Resources/Tests/Listahuecos.txt");
        assertTrue(LOCcount.phyCount(file) == (15));
    }
     
    /**
     * Test that the amount of lines is correct in the locCount 
     */
    public void testlocCountArchive(){
        File file= new File("./Resources/Tests/Listahuecos.txt");
        assertTrue(LOCcount.locCount(file) == (8));
    }

    /**
     * Test that the amount of lines is correct in the phyCount 
     */
    public void testphyCountDir(){
        File file= new File("./Resources/Tests/");
        assertTrue(LOCcount.phyCount(file) == (37));
    }
}
