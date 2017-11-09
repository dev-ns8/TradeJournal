package dataAbstraction;

import java.math.BigDecimal;
import java.time.Duration;

public class JournalStats extends Statistics {
    public BigDecimal overalPnL;
    public Duration winDuration;
    public Duration lossDuration;
    public Duration averageDuration;
    public double winLossRatio;
    public BigDecimal biggestWin;
    public BigDecimal biggestLoss;
    public Journal myJournal;

    public JournalStats() {
        //Empty on purpose
    }

    public void computeWinLoss() {
        int length = myJournal.getTrades().size();
        int largest = 0;
        int wins = 0, loss = 0;
        for(int i = 0; i< length-1;i++) {
            if(myJournal.getItem(i).getWinner()) {
                wins += 1;
            }
            else {
                loss += 1;
            }
        }
        winLossRatio = wins/loss; //Needs to be fixed, Specifically checked for rounding errors TODO:::
    }

    public void computePnl() {
        for(int i = 0; i < myJournal.getTrades().size() - 1; i++) {
            overalPnL = overalPnL.add(myJournal.getItem(i).getPnl()); //TODO::Write a Test for this
        }
    }

    public void computeBiggestWin() {
        BigDecimal largest = new BigDecimal(0);
        for(int i = 0; i < myJournal.getTrades().size() - 1; i++) {
            if(myJournal.getItem(i).getPnl().compareTo(largest) > 0) {
                largest = myJournal.getItem(i).getPnl();
            }
        }
        biggestWin = largest;
    }

    public void computeBiggestLoss() {
        //Iterate through and find largest value
        computeBiggestWin();
        BigDecimal largestLoss = biggestWin;
        for(int i = 0; i < myJournal.getTrades().size() - 1; i++) {
            if(myJournal.getItem(i).getPnl().compareTo(largestLoss) < 0) {
                largestLoss = myJournal.getItem(i).getPnl();
            }
        }
        biggestLoss = largestLoss;
    }





}
