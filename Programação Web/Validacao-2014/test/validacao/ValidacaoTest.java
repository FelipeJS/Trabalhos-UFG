/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validacao;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author alunoinf
 */
public class ValidacaoTest extends TestCase {
    
    public ValidacaoTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ValidacaoTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of main method, of class Validacao.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Validacao.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
