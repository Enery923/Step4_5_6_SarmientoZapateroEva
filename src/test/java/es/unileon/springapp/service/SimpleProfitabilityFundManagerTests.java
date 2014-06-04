package es.unileon.springapp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.repository.InMemoryInvestmentFundDao;
import es.unileon.springapp.repository.InvestmentFundDao;

public class SimpleProfitabilityFundManagerTests {

	private SimpleProfitabilityFundManager profitabilityFundManager;
	//Antes era List<>
	private ArrayList<InvestmentFund> investmentFunds;
	
	private static int INVESTMENTFUND_COUNT = 2;
	
	private static String DESCRIPTION_FUND1 = "Fund1";
	private static int NUMBER_FUND1 = 3;
	private static double PROFITABILITY_FUND1 = 3.22;
	private static String DATE_FUND1 = "06/10/2014";
	
	private static String DESCRIPTION_FUND2 = "Fund2";
	private static int NUMBER_FUND2 = 12;
	private static double PROFITABILITY_FUND2 = 7.45;
	private static String DATE_FUND2 = "26/04/2014";
	
	private static String NEW_DATE = "12/06/2014";
	private static String SEARCH = "Fund1";
	
	@Before
    public void setUp() throws Exception {
		profitabilityFundManager = new SimpleProfitabilityFundManager();
		investmentFunds = new ArrayList<InvestmentFund>();
		
		InvestmentFund investmentFund= new InvestmentFund();
		investmentFund.setId(DESCRIPTION_FUND1);
		investmentFund.setAmount(NUMBER_FUND1);
		investmentFund.setProfitability(PROFITABILITY_FUND1);
		investmentFund.setDate(DATE_FUND1);
		investmentFunds.add(investmentFund);
		
		investmentFund= new InvestmentFund();
		investmentFund.setId(DESCRIPTION_FUND2);
		investmentFund.setAmount(NUMBER_FUND2);
		investmentFund.setProfitability(PROFITABILITY_FUND2);
		investmentFund.setDate(DATE_FUND2);
		investmentFunds.add(investmentFund);
		
		InvestmentFundDao investmentFundDao = new InMemoryInvestmentFundDao(investmentFunds);
		profitabilityFundManager.setInvestmentFundDao(investmentFundDao);
		
		
    }

    @Test
    public void testGetProductsWithNoInvestmentFunds() {
    	profitabilityFundManager = new SimpleProfitabilityFundManager();
    	profitabilityFundManager.setInvestmentFundDao(new InMemoryInvestmentFundDao(null));
        assertNull(profitabilityFundManager.getInvestmentFunds());
    }
    
    @Test
    public void testGetInvestmentFunds() {
        List<InvestmentFund> investmentFunds = profitabilityFundManager.getInvestmentFunds();
        assertNotNull(investmentFunds);        
        assertEquals(INVESTMENTFUND_COUNT, profitabilityFundManager.getInvestmentFunds().size());
    
        InvestmentFund investmentFund = investmentFunds.get(0);
        assertEquals(DESCRIPTION_FUND1, investmentFund.getId());
        assertEquals(NUMBER_FUND1, investmentFund.getAmount());
        assertEquals(PROFITABILITY_FUND1, investmentFund.getProfitability(), 0.0);
        assertEquals(DATE_FUND1, investmentFund.getDate());
        
        
        investmentFund = investmentFunds.get(1);
        assertEquals(DESCRIPTION_FUND2, investmentFund.getId());
        assertEquals(NUMBER_FUND2, investmentFund.getAmount());
        assertEquals(PROFITABILITY_FUND2, investmentFund.getProfitability(), 0.0);
        assertEquals(DATE_FUND2, investmentFund.getDate());
        
    }
    
    @Test
    public void testSetWithNullListOfInvestmentFunds() {
        try {
            profitabilityFundManager = new SimpleProfitabilityFundManager();
            profitabilityFundManager.setInvestmentFundDao(new InMemoryInvestmentFundDao(null));
            profitabilityFundManager.set(NEW_DATE, SEARCH );
        }
        catch(NullPointerException ex) {
            fail("InvestmentFunds list is null.");
        }
    }

    @Test
    public void testSetWithEmptyListOfInvestmentFunds() {
        try {
        	profitabilityFundManager = new SimpleProfitabilityFundManager();
        	profitabilityFundManager.setInvestmentFundDao(new InMemoryInvestmentFundDao(new ArrayList<InvestmentFund>()));
        	profitabilityFundManager.set(NEW_DATE, SEARCH);
        }
        catch(Exception ex) {
            fail("InvestmentFunds list is empty.");
        }           
    }
    
    
	@Test
    public void testSet() {
    	profitabilityFundManager.set(NEW_DATE, SEARCH);
        Double expectedNewProfitabilityFund1 = 3.22;
        
        List<InvestmentFund> investmentFunds = profitabilityFundManager.getInvestmentFunds();      
        InvestmentFund investmentFund = investmentFunds.get(0);
        assertEquals(expectedNewProfitabilityFund1, investmentFund.getProfitability(),0);
        
        investmentFund = investmentFunds.get(1);
        assertEquals(PROFITABILITY_FUND2, investmentFund.getProfitability(),0);
        
    }

}
