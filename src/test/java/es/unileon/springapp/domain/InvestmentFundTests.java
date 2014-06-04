package es.unileon.springapp.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InvestmentFundTests {

	private InvestmentFund investmentFund;

    @Before
    public void setUp() throws Exception {
    	investmentFund = new InvestmentFund();
    }

    @Test
    public void testSetAndGetDescription() {
        String testDescription = "aDescription";
        assertNull(investmentFund.getId());
        investmentFund.setId(testDescription);
        assertEquals(testDescription, investmentFund.getId());
    }
    
    @Test
    public void testSetAndGetNumberFunds() {
    	int testNumberFunds = 5;
    	assertEquals(0, investmentFund.getAmount());
    	investmentFund.setAmount(testNumberFunds);
    	assertEquals(testNumberFunds, investmentFund.getAmount());
    }
    
    @Test
    public void testSetAndGetProfitability() {
    	double testProfitability = 6.27;
    	assertEquals(0.0, investmentFund.getProfitability(), 0.0);
    	investmentFund.setProfitability(testProfitability);
    	assertEquals(testProfitability, investmentFund.getProfitability(), 0.0);
    }
    

}