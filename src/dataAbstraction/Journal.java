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

	//fucking with trades
	public boolean addTrade(Trade newTrade){
		if(newTrade!=null){
			trades.add(newTrade);
			updateJournalStats();
			return true;
		}
		return false;
	}
	public boolean removeTrade(Trade newTrade){
		for(int i =0;i<trades.size();i++){
			if(newTrade.equals(trades.get(i))){
				trades.remove(i);
				updateJournalStats();
				return true;
			}
		}
		return false;//eventually return custom exception like, "Trade not found" TODO
	}
	public boolean removeTrade(int index){
		if(trades.size()>index){
			trades.remove(index);
			updateJournalStats();
			return true;
		}
		return false;//eventually return custom exception "Index out of bounds/ Trade DNE"TODO

	}
	public boolean editTrade(Trade newTrade,int index){
		//replace unedited trade with edited newTrade by index
		if(newTrade!=null){
			if(index<trades.size()){ //index inbounds
				trades.set(index,newTrade);
				updateJournalStats();
				return true;
			}
		}
		return false; //eventually return custom exception "Cannot edit Trade that DNE"TODO
	}

	//stats
	private void updateJournalStats() {
		stats.updateAll();
	}
	//general trade list stuff
    public int getSize(){
        return trades.size();
    }
	public Trade getItem(int index) {
		if(trades.size()>index) {
			return trades.get(index);
		}
		return null; //exception shittt
	}
}

