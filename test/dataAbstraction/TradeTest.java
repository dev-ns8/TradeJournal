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

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void newTrade() {
        List<TradeHelper> args = new ArrayList<>();
        args.add(new TradeHelper("instrument","APPL"));
        args.add(new TradeHelper("entry",new Date()));
        args.add(new TradeHelper("entryPrice",new BigDecimal(1.0)));
        args.add(new TradeHelper("actionBuy",true));
        args.add(new TradeHelper("quantity",100));
        basic = Trade.newTrade(args);

        assertEquals("APPL",basic.getInstrument());
        assertTrue(new BigDecimal(1.0).equals(basic.getEntryPrice()));
        assertEquals(true,basic.isActionBuy());
        assertEquals(100,basic.getQuantity());

        /*
        args.add(new TradeHelper("instrument","APPL"));
        args.add(new TradeHelper("exitDate",new Date()));
        args.add(new TradeHelper("exitPrice",new BigDecimal(2.0)));
        args.add(new TradeHelper("stopLoss",new BigDecimal(0.1)));
        args.add(new TradeHelper("takeProfit",new BigDecimal(2.0)));
        args.add(new TradeHelper("commissions",new BigDecimal(0.5)));
        args.add(new TradeHelper("notes","this method sucks ass"));
        advanced = Trade.newTrade(args);
        */

    }

}