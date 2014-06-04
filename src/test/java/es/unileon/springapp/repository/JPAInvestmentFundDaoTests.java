package es.unileon.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.springapp.domain.InvestmentFund;

public class JPAInvestmentFundDaoTests {

	private ApplicationContext context;
    private InvestmentFundDao investmentFundDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        investmentFundDao = (InvestmentFundDao) context.getBean("investmentFundDao");
       
    }

    @Test
    public void testGetInvestmentFundList() {
        List<InvestmentFund> investmentFunds = investmentFundDao.getInvestmentFundList();
        assertEquals(investmentFunds.size(), 0, 0);	   
    }

    @Test
    public void testSaveInvestmentFund() {
        List<InvestmentFund> investmentFunds = investmentFundDao.getInvestmentFundList();

        InvestmentFund i = investmentFunds.get(0);
        String date = i.getDate();
        i.setDate("2020-10-13");
        investmentFundDao.saveInvestmentFund(i);

        List<InvestmentFund> updatedInvestmentFunds = investmentFundDao.getInvestmentFundList();
        InvestmentFund i2 = updatedInvestmentFunds.get(0);
        assertEquals(i2.getDate(), "2020-10-13");

        i2.setDate(date);
        investmentFundDao.saveInvestmentFund(i2);
    }

}
