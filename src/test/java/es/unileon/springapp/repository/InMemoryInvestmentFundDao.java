package es.unileon.springapp.repository;

import java.util.ArrayList;
import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;



public class InMemoryInvestmentFundDao implements InvestmentFundDao {

	private List<InvestmentFund> investmentFundList;
	
	public InMemoryInvestmentFundDao(ArrayList<InvestmentFund> arrayList) {
		this.investmentFundList = arrayList;
	}
	
	public List<InvestmentFund> getInvestmentFundList() {
		return investmentFundList;
	}

	public void saveInvestmentFund(InvestmentFund investFund) {
	
	}
	
	

}
