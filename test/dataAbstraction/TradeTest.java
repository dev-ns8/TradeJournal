package dataAbstraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TradeHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TradeTest {
    private Trade basic,advanced;

    @Test
    void newTradeHappyPath() {
        //todo
        Date start = new Date();
        basic = new Trade.TradeBuilder("CAPR",start,new BigDecimal(1.0),true,1,false).build();
    }
    @Test
    void newTradeBadPath() {

    }

    @Test
    void updateTradeStats() {
        //TODO
    }
}