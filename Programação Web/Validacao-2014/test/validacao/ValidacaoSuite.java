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
public class ValidacaoSuite extends TestCase {
    
    public ValidacaoSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("ValidacaoSuite");
        suite.addTest(ValidacaoTest.suite());
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
}
