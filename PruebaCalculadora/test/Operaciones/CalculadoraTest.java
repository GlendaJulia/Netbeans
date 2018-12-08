package Operaciones;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class CalculadoraTest {

    static Calculadora calc;
    
    @Before
    public void before(){
        System.out.println("before()");
        calc = new Calculadora();
    }
    
    @After
    public void after(){
        System.out.println("after()");
        calc.clear();
    }
    
    @Test
    public void testSum(){
        System.out.println("sum()");
        int resul = calc.add(3, 2);
        int esper = 5;
        assertEquals(esper,resul);
    }
    
    @Test
    public void testAnsSum(){
        
        System.out.println("ansSum()");
        calc.add(3, 2);
        int resul = calc.ans();
        int esper = 5;
        assertEquals(esper,resul);
    }
    
    @Test
    public void testDiv(){
        System.out.println("TestDiv()");
        calc.div(5, 3);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivPorCero(){
        System.out.println("testDivPorCero()");
        calc.div(5, 0);
    }
    
    @Test(timeout = 100)
    public void testAlgoritmoOptimo(){
        System.out.println("Test()");
        calc.operacionOptima();
    }
    
    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass()");
        calc = new Calculadora();
    }
    
    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass()");
    }
}
