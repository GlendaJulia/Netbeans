/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class ArrayTest {
    
    @Test
    public void testSize() {
        int arr[] = {1,2,3};
        Array a = new Array(arr);
        assertEquals(3,a.size());
    }
    @Test
    public void testToString() {
        int arr[] = {1,2,3};
        Array a = new Array(arr);
        assertEquals("1;2;3",a.toString());
    }
    @Test
    public void setUp(){
        System.out.println("Los valores iniciales del arreglo: {1,2,3} ");
    }
    @Test
    public void testSetElementAt() {
        int arr[] = {1,2,3};
        Array a = new Array(arr);
        a.setElementAt(100,2);
        
        int obt[] = a.getArray();
        assertEquals(obt[2],100);
        
        try{
            a.setElementAt(100, -1);
            assertFalse(true);
        }
        catch(Exception e){
            assertTrue(true);
        }
    }
    
    @Test
    public void tearDown(){
        System.out.println("Aqui finaliza este caso de prueba");
    }
}
