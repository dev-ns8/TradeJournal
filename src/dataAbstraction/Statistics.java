package dataAbstraction;

import java.math.BigDecimal;
import java.time.Duration;

public class Statistics {

    public BigDecimal PnL;
//    public BigDecimal winLoss;
    public double sharpeRatio;
    public Duration trade_duration;

   /* public Statistics(BigDecimal PnL, BigDecimal winLoss, double sharpeRatio, Duration trade_duration) {
        this.PnL = PnL;
        this.winLoss = winLoss;
        this.sharpeRatio = sharpeRatio;
        this.trade_duration = trade_duration;
    } */

    public BigDecimal getPnL() {
        return PnL;
    }

    public void setPnL(BigDecimal pnL) {
        PnL = pnL;
    }

//    public BigDecimal getWinLoss() {return winLoss;}

//    public void setWinLoss(BigDecimal winLoss) {this.winLoss = winLoss;}

    public double getSharpeRatio() {
        return sharpeRatio;
    }

    public void setSharpeRatio(double sharpeRatio) {
        this.sharpeRatio = sharpeRatio;
    }

    public Duration getTrade_duration() {
        return trade_duration;
    }

    public void setTrade_duration(Duration trade_duration) {
        this.trade_duration = trade_duration;
    }


}
