package es;
import src.Persona;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonaTest {
    
    @Test(expected= AssertionError.class)
    public void test1(){
        Persona p = new Persona("a","e");
        p.Verificar();
    }
    @Test(expected= AssertionError.class)
    public void test2(){
        Persona p = new Persona("","");
        p.Verificar();
    }
}
