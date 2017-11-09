package dataAbstraction;

import java.util.ArrayList;
import java.util.List;

public class Journal {
	private List<Trade> trades;
	private JournalStats stats;

	public Journal() {
		trades = new ArrayList<>();
		stats = new JournalStats();
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

		//Trade newTrade = new Trade(args);

	public String fakeDick(){
		return "dildo";
	}
    public int getSize(){
        return trades.size();
    }
}

