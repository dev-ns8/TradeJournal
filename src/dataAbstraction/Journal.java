package dataAbstraction;

import java.util.ArrayList;

public class Journal {
	public ArrayList<Trade> trades;
	public JournalStats stats;

	private Journal(ArrayList<Trade> trades) {
		this.trades = trades;
	}

	public ArrayList<Trade> getTrades() {
		return trades;
	}

	public void setTrades(ArrayList<Trade> trades) {
		this.trades = trades;
	}

	public Trade getItem(int index) {
		return trades.get(index);
	}
}

