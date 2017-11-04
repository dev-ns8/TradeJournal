package dataAbstraction;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {
	public Date entry;
	public Date exit;
	public BigDecimal entryPrice;
	public BigDecimal exitPrice;
	public String setup_classification;
	public String action; //Buy/Sell
	public int quantity;
	public BigDecimal stopLoss;
	public BigDecimal takeProfit;
	public BigDecimal commissions;
	public String notes;
	
	private Trade(Date entry, Date exit, BigDecimal entryPrice, BigDecimal exitPrice, String setup_classification, String action, int quantity, BigDecimal stopLoss, BigDecimal takeProfit, BigDecimal commissions, String notes) {
		this.entry = entry;
		this.exit = exit;
		this.entryPrice = entryPrice;
		this.exitPrice = exitPrice;
		this.setup_classification = setup_classification;
		this.action = action;
		this.quantity = quantity;
		this.stopLoss = stopLoss;
		this.takeProfit = takeProfit;
		this.commissions = commissions;
		this.notes = notes;
	}
	
	
	public Date getEntry() {
		return entry;
	}
	public void setEntry(Date entry) {
		this.entry = entry;
	}
	public Date getExit() {
		return exit;
	}
	public void setExit(Date exit) {
		this.exit = exit;
	}
	public BigDecimal getEntryPrice() {
		return entryPrice;
	}
	public void setEntryPrice(BigDecimal entryPrice) {
		this.entryPrice = entryPrice;
	}
	public BigDecimal getExitPrice() {
		return exitPrice;
	}
	public void setExitPrice(BigDecimal exitPrice) {
		this.exitPrice = exitPrice;
	}
	public String getSetup_classification() {
		return setup_classification;
	}
	public void setSetup_classification(String setup_classification) {
		this.setup_classification = setup_classification;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getStopLoss() {
		return stopLoss;
	}
	public void setStopLoss(BigDecimal stopLoss) {
		this.stopLoss = stopLoss;
	}
	public BigDecimal getTakeProfit() {
		return takeProfit;
	}
	public void setTakeProfit(BigDecimal takeProfit) {
		this.takeProfit = takeProfit;
	}
	public BigDecimal getCommissions() {
		return commissions;
	}
	public void setCommissions(BigDecimal commissions) {
		this.commissions = commissions;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	

}
