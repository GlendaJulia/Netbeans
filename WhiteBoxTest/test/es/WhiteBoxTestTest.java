/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class WhiteBoxTestTest {
    
    @Test
    public void testAMethod1(){
        WhiteBoxTest instance = new WhiteBoxTest();
        assertEquals(instance.aMethod(true, false, true),2);
    }
    
    @Test
    public void testAMethod2(){
        WhiteBoxTest instance = new WhiteBoxTest();
        assertEquals(instance.aMethod(true, false, false),0);
    }
    
    @Test
    public void testAMethod3(){
        WhiteBoxTest instance = new WhiteBoxTest();
        assertEquals(instance.aMethod(true, true, false),1);
    }
    
    @Test
    public void testAMethod4(){
        WhiteBoxTest instance = new WhiteBoxTest();
        assertEquals(instance.aMethod(false, false, false),0);
    }
    
    @Test
    public void testAMethod() {
        System.out.println("aMethod");
        boolean a = false;
        boolean b = false;
        boolean c = false;
        WhiteBoxTest instance = new WhiteBoxTest();
        int expResult = 0;
        int result = instance.aMethod(a, b, c);
        assertEquals(expResult, result);
    }
    
}
