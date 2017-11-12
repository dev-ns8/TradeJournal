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
	private BigDecimal pnl;
	private Duration trade_duration;
	private Boolean winner;  //0 if Loser 1 if winner
	private String notes;


	public Trade(String instrument, Date entry, BigDecimal entryPrice, boolean actionBuy, int quantity) {
		this.instrument = instrument;
		this.entry = entry;
		this.entryPrice = entryPrice;
		this.actionBuy = actionBuy;
		this.quantity = quantity;
	}

	public static Trade newTrade(List<TradeHelper> args){
		int count = 0; //if count if 5, then all required fields are taken care of
		Trade temp = new Trade(null,null,null,false,0);
		for(int i=0;i<args.size();i++){
			switch (args.get(i).getId().toLowerCase()){
				case "instrument":
					temp.setInstrument((String)args.get(i).getObject());
					count+=1;
					break;
				case "entry":
					temp.setEntry((Date)args.get(i).getObject());
					count+=1;
					break;
				case "entryprice":
					temp.setEntryPrice((BigDecimal) args.get(i).getObject());
					count+=1;
					break;
				case "actionbuy":
					temp.setActionBuy((boolean)args.get(i).getObject());
					count+=1;
					break;
				case "quantity":
					temp.setQuantity((int)args.get(i).getObject());
					count+=1;
					break;
				case "exit":
					temp.setExit((Date)args.get(i).getObject());
					break;
				case "exitprice":
					temp.setExitPrice((BigDecimal) args.get(i).getObject());
					break;
				case "setup_classification":
					temp.setSetup_classification((String)args.get(i).getObject());
					break;
				case "stoploss":
					temp.setStopLoss((BigDecimal) args.get(i).getObject());
					break;
				case "takeprofit":
					temp.setTakeProfit((BigDecimal) args.get(i).getObject());
					break;
				case "commissions":
					temp.setCommissions((BigDecimal) args.get(i).getObject());
					break;
				case "notes":
					temp.setNotes((String)args.get(i).getObject());
					break;
			}
		}
		if (count!=5) temp = null;
		return temp;
	}


	private void updateTradeStats() {
		//determine trade_duration, winner, and PnL
		//is run when isComplete == true
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
			}
			setPnl(exitPrice.min(entryPrice));
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
					winner = false;
				}
			}
			setPnl(entryPrice.min(exitPrice));
		}
		if(exit!=null){
			long seconds = (exit.getTime()-entry.getTime())/1000;
			setTrade_duration(Duration.ofSeconds(seconds));
		}
	}

	
// GETTERS and SETTERS
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
	public void setComplete(Boolean complete) {
		isComplete = complete;
		if(isComplete) updateTradeStats();
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



	

}
