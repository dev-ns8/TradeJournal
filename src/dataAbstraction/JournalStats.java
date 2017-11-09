package dataAbstraction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

public class JournalStats {
    private Duration winDuration;
    private Duration lossDuration;
    private Duration averageDuration;
    private BigDecimal winLossRatio;
    private BigDecimal biggestWin;
    private BigDecimal biggestLoss;
    private Journal myJournal;

    public JournalStats() {
        //Empty on purpose
    }

    public void computeWinLoss() {
        int length = myJournal.getSize();
        int largest = 0;
        BigDecimal wins = new BigDecimal(0), loss = new BigDecimal(0);
        for(int i = 0; i< length;i++) {
            if(myJournal.getItem(i).getWinner()!=null) {
                if (myJournal.getItem(i).getWinner()) {
                    wins.add(new BigDecimal(1));
                } else {
                    loss.add(new BigDecimal(1));
                }
            }
        }
        winLossRatio = wins.divide(loss); //Needs to be fixed, Specifically checked for rounding errors TODO::: RoundingMode? only half steps
    }




}
