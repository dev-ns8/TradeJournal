package Test;

import dataAbstraction.Journal;
import dataAbstraction.User;

public class MainTest {

    public static void main(String args[]) {
        User nate = new User();
        Journal testJournal = nate.getUser_journal();
        testJournal.addTrade("/ZB");
      //  testJournal.addTrade("/TN", "11/7/17", "11/7/17", "134'05");
    }
}
