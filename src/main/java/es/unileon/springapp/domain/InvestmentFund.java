package es.unileon.springapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="investmentFunds")
public class InvestmentFund implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
	private String id;
	private int amount;
	private double profitability;
	private String date;
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public double getProfitability() {
		return profitability;
	}
	
	public void setProfitability(double profitability) {
		this.profitability = profitability;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + id + ";");
        buffer.append("Number of Funds: " + amount + ";");
        buffer.append("Profitabily: " + profitability + ";");
        buffer.append("Liquidation Date: " + date);
        return buffer.toString();
    }
}
