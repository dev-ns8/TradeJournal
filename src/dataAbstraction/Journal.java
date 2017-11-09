package dataAbstraction;

import java.util.ArrayList;
import java.util.List;

public class Journal {
	public List<Trade> trades;
	public JournalStats stats;

	public Journal(ArrayList<Trade> trades) {
		this.trades = trades;
	}
	public Journal() {
		//Empty on purpose
	}



	public Trade getItem(int index) {
		return trades.get(index);
	}

	public void addTrade(Object args) {
		// 1. Iterate through argument list and check the length of array
		//2. If more than 5, create a Trade with the 5 mandatory arguments and pass the rest into helper method
		/* 3. have helperMethod iterate through arguments and decipher what arguments it has and use setters to add to
				the newley created Trade object	*/


	}
}

