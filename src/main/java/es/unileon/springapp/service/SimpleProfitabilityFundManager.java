package es.unileon.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.repository.InvestmentFundDao;

@Component
public class SimpleProfitabilityFundManager implements ProfitabilityFundManager{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private InvestmentFundDao investmentFundDao;
	private List<InvestmentFund> investmentFunds;
	
	public void setInvestmentFundDao(InvestmentFundDao investmentFundDao) {
		this.investmentFundDao = investmentFundDao; 
	}
	
	public List<InvestmentFund> getInvestmentFunds() {
		return investmentFundDao.getInvestmentFundList();
	}

	public void set(String newDate, String id) {
		List<InvestmentFund> investmentFunds = investmentFundDao.getInvestmentFundList();
		if (investmentFunds != null) {
			for (InvestmentFund investmentFund : investmentFunds) {
				if (id.equals(investmentFund.getId())) {
					investmentFund.setDate(newDate);
					investmentFundDao.saveInvestmentFund(investmentFund);
				}
			}
		}
		
	}

}
