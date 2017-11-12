package dataAbstraction;

import utils.TradeHelper;

import java.util.ArrayList;
import java.util.List;

public class Journal {
	private List<Trade> trades;
	private JournalStats stats;

	//Basically an exagerated List that handles exceptions and provides usefull information on error.
	//also holds stats

	public Journal() {
		trades = new ArrayList<>();
		stats = new JournalStats(this);
	}


	public Trade getItem(int index) {
		return trades.get(index);
	}

	public boolean addTrade(Trade newTrade){
		if(newTrade!=null){
			if(newTrade.getInstrument()!=null&&!newTrade.getInstrument().equalsIgnoreCase(""))
				if(newTrade.getEntry()!=null)
					if(newTrade.getEntryPrice()!=null) {
						trades.add(newTrade);
						return true;
					}
		}
		return false;
	}
	public boolean removeTrade(Trade newTrade){
		for(int i =0;i<trades.size();i++){
			if(newTrade.equals(trades.get(i))){
				trades.remove(i);
				return true;
			}
		}
		return false;//eventually return custom exception like, "Trade not found" TODO
	}
	public boolean removeTrade(int index){

		if(trades.size()>index){
			trades.remove(index);
			return true;
		}
		return false;//eventually return custom exception "Index out of bounds/ Trade DNE"TODO

	}
	public boolean editTrade(Trade newTrade){
		//replace unedited trade with edited newTrade
		for(int i=0;i<trades.size();i++){
			if(newTrade.equals(trades.get(i))){
				trades.set(i,newTrade);
				return true;
			}
		}
		return false; //eventually return custom exception "Cannot edit Trade that DNE"TODO
	}
	public boolean editTrade(Trade newTrade,int index){
		//replace unedited trade with edited newTrade by index
		if(newTrade!=null){
			if(index<trades.size()){ //index inbounds
				trades.set(index,newTrade);
				return true;
			}
		}
		return false; //eventually return custom exception "Cannot edit Trade that DNE"TODO
	}

	public void addTradeWithList(List<TradeHelper> args) {
		// 1. Iterate through argument list and check the length of array
		//2. If more than 5, create a Trade with the 5 mandatory arguments and pass the rest into helper method
		/* 3. have helperMethod iterate through arguments and decipher what arguments it has and use setters to add to
				the newley created Trade object	*/
		Trade temp = Trade.newTrade(args);
		if(temp!=null) trades.add(temp);
		else {//throw exception
			}
		updateStats();

	}

	private void updateStats() {
		stats.updateAll();
	}

	//Trade newTrade = new Trade(args);


    public int getSize(){
        return trades.size();
    }
}

