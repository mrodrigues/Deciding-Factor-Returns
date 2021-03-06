package deciodingFactorReturns.policies;

import decidingFactorReturns.policies.Worst;
import decidingFactorReturns.exceptions.WorstPolicyException;
import decidingFactorReturns.structures.Node;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WorstTest extends TestCase {

    private Worst worst;
    private List<Node> nodes;

    public WorstTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        worst = new Worst();
        nodes = new ArrayList<Node>();
        Node n = new Node();
        n.setValue(2.0F);
        nodes.add(n);
        n = new Node();
        n.setValue(3.0F);
        nodes.add(n);
    }

    @After
    public void tearDown() {
    }

    /**
     * Testa o método <i>evaluate</i> em caso de sucesso
     */
    @Test
    public void testEvaluateSuccess() throws Exception {
        System.out.println("evaluate success");
        Float cutValue = 2.0F;
        float expResult = 2.0F;
        float result = worst.evaluate(cutValue, nodes);
        assertEquals(expResult, result,
                0.0F // Necessário incluir um delta para a comparação de floats
                );
    }

    /**
     * Testa o método <i>evaluate</i> em caso de falha
     */
    @Test
    public void testEvaluateFail() throws Exception {
        System.out.println("evaluate fail");
        Float cutValue = 2.1F;
        try {
            worst.evaluate(cutValue, nodes);
            fail("Deveria lançar exceção");
        } catch (Exception e) {
            assertSame(e.getClass(), WorstPolicyException.class);
        }
    }
}
