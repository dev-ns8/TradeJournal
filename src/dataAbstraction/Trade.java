package dataAbstraction;

import utils.TradeHelper;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Trade {
	private String instrument;
	private Date entry;
	private Date exit;
	private BigDecimal entryPrice;
	private BigDecimal exitPrice;
	private String setup_classification;
	private boolean actionBuy; //Buy/Sell
	private int quantity;
	private BigDecimal stopLoss;
	private BigDecimal takeProfit;
	private BigDecimal commissions;
	private Boolean isComplete;
	private String notes;
	//TODO:: TradeStats object maybe
	private BigDecimal pnl;
	private Duration trade_duration;
	private boolean winner;


	public Trade(TradeBuilder builder) {
		this.instrument = builder.instrument;
		this.entry = builder.entry;
		this.entryPrice = builder.entryPrice;
		this.actionBuy = builder.actionBuy;
		this.quantity = builder.quantity;
		this.exit = builder.exit;
		this.exitPrice = builder.exitPrice;
		this.setup_classification = builder.setup_classification;
		this.stopLoss = builder.stopLoss;
		this.takeProfit = builder.takeProfit;
		this.commissions = builder.commissions;
		this.notes = builder.notes;
		setComplete(builder.isComplete); //if true then update trade stats!
	}

	private void updateTradeStats() {
		//determine trade_duration, winner, and PnL
		//is ran when isComplete == true
		//buy
		if(actionBuy){
			if(exitPrice!=null){
				int res = exitPrice.compareTo(entryPrice); //-1 if exit is smaller, 0 same, 1 bigger
				if(res==1){
					winner=true;
				}
				else if(res==-1){
					winner=false;
				}
				else{
					//TODO: If (exitprice==entryprice) does that mean winner/loss or even?
				}
				setPnl(exitPrice.subtract(entryPrice));
			}

		}
		//sell
		else{
			if(exitPrice!=null){
				int res = exitPrice.compareTo(entryPrice); //-1 if exit is smaller, 0 same, 1 bigger
				if(res==-1){
					winner=true;
				}
				else if(res==1){
					winner=false;
				}
				else{
					//TODO: If (exitprice==entryprice) does that mean winner/loss or even?
				}
				setPnl(entryPrice.subtract(exitPrice));
			}

		}
		if(exit!=null){
			long seconds = (exit.getTime()-entry.getTime())/1000;
			setTrade_duration(Duration.ofSeconds(seconds));
			//TODO:: test
		}
	}

// GETTERS and SETTERS
	public void setComplete(Boolean complete) {
	isComplete = complete;
	if(isComplete) updateTradeStats();
}
	public void setExit(Date exit) {
		this.exit = exit;
		updateTradeStats();
	}
	public void setExitPrice(BigDecimal exitPrice) {
		this.exitPrice = exitPrice;
		updateTradeStats();
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
	public BigDecimal getEntryPrice() {
		return entryPrice;
	}
	public void setEntryPrice(BigDecimal entryPrice) {
		this.entryPrice = entryPrice;

	}
	public BigDecimal getExitPrice() {
		return exitPrice;
	}
	public String getSetup_classification() {
		return setup_classification;
	}
	public void setSetup_classification(String setup_classification) {
		this.setup_classification = setup_classification;
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
	public Boolean getWinner() {return winner;}
	public void setPnl(BigDecimal Pnl) {this.pnl = Pnl;}
	public BigDecimal getPnl() {return pnl;}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public boolean isActionBuy() {
		return actionBuy;
	}
	public void setActionBuy(boolean actionBuy) {
		this.actionBuy = actionBuy;
	}
	public Boolean getComplete() {
		return isComplete;
	}



	public Duration getTrade_duration() {
		return trade_duration;
	}
	public void setTrade_duration(Duration trade_duration) {
		this.trade_duration = trade_duration;
	}
	public void setWinner(Boolean winner) {
		this.winner = winner;
	}

// ---------------------------------------------------------------------

	public static class TradeBuilder{
		String instrument;
		Date entry;
		BigDecimal entryPrice;
		boolean actionBuy;
		int quantity;
		Date exit;
		BigDecimal exitPrice;
		String setup_classification;
		BigDecimal stopLoss;
		BigDecimal takeProfit;
		BigDecimal commissions;
		String notes;
		boolean isComplete;


		public TradeBuilder(String instrument, Date entry, BigDecimal entryPrice, boolean actionBuy, int quantity, boolean isComplete) {
			this.instrument = instrument;
			this.entry = entry;
			this.entryPrice = entryPrice;
			this.actionBuy = actionBuy;
			this.quantity = quantity;
			this.isComplete = isComplete;
		}

		public TradeBuilder exit(Date exit){
			this.exit = exit;
			return this;
		}
		public TradeBuilder setup_classification(String setup_classification){
			this.setup_classification = setup_classification;
			return this;
		}
		public TradeBuilder stopLoss(BigDecimal stopLoss){
			this.stopLoss = stopLoss;
			return this;
		}
		public TradeBuilder takeProfit(BigDecimal takeProfit){
			this.takeProfit = takeProfit;
			return this;
		}
		public TradeBuilder commissions(BigDecimal commissions){
			this.commissions = commissions;
			return this;
		}
		public TradeBuilder notes(String notes){
			this.notes = notes;
			return this;
		}
		public TradeBuilder exitPrice(BigDecimal exitPrice){
			this.exitPrice = exitPrice;
			return this;
		}
		public Trade build(){
			return new Trade(this);
		}
	}
	

}
