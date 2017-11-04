package dataAbstraction;

import java.util.List;

public class User {
	public String username;
	private String password;
	private List<String> trade_setups;
	private List<String> goals;
	private Journal user_journal;

	private User(String username, String password, List<String> trade_setups, List<String> goals, Journal user_journal) {
		this.username = username;
		this.password = password;
		this.trade_setups = trade_setups;
		this.goals = goals;
		this.user_journal = user_journal;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getTrade_setups() {
		return trade_setups;
	}

	public void setTrade_setups(List<String> trade_setups) {
		this.trade_setups = trade_setups;
	}

	public List<String> getGoals() {
		return goals;
	}

	public void setGoals(List<String> goals) {
		this.goals = goals;
	}

	public Journal getUser_journal() {
		return user_journal;
	}

	public void setUser_journal(Journal user_journal) {
		this.user_journal = user_journal;
	}
}
