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
public class TESTE1 extends TestCase {
    
    public TESTE1(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("TESTE1");
        suite.addTest(new TestSuite(validacao.Validacao.class));
        suite.addTest(new TestSuite(validacao.Validacao.class));
        suite.addTest(ValidacaoTest.suite());
        return suite;
    }
    
    public void testeValidacao1(){
        int 
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
