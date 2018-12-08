package sample;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({sample.VectorsTest.class, sample.UtilsTest.class})
public class JUnit4TestSuite {
    
}
