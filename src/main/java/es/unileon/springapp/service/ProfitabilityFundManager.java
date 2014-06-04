package es.unileon.springapp.service;

import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;

public interface ProfitabilityFundManager {
	
	public void set(String newProfitability, String id);
    
    public List<InvestmentFund> getInvestmentFunds();

}