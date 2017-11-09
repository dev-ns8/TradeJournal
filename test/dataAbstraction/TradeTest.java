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
    void newTradeHappyPath() {
        //this is the happy path mofo
        List<TradeHelper> args = new ArrayList<>();

        //build essentials for a trade
        Date entry = new Date();
        args.add(new TradeHelper("instrument","APPL"));
        args.add(new TradeHelper("entry",entry));
        args.add(new TradeHelper("entryPrice",new BigDecimal(1.0)));
        args.add(new TradeHelper("actionBuy",true));
        args.add(new TradeHelper("quantity",100));
        basic = Trade.newTrade(args);
        //test essentials for a trade
        assertEquals("APPL",basic.getInstrument());
        assertTrue(new BigDecimal(1.0).equals(basic.getEntryPrice()));
        assertEquals(true,basic.isActionBuy());
        assertEquals(100,basic.getQuantity());
        assertTrue(entry.equals(basic.getEntry()));
        //add additional advanced stuff
        Date exit = new Date();
        args.add(new TradeHelper("exit",exit));
        args.add(new TradeHelper("exitPrice",new BigDecimal(2.0)));
        args.add(new TradeHelper("stopLoss",new BigDecimal(0.1)));
        args.add(new TradeHelper("takeProfit",new BigDecimal(2.0)));
        args.add(new TradeHelper("commissions",new BigDecimal(0.5)));
        args.add(new TradeHelper("setup_classification","turd"));
        args.add(new TradeHelper("notes","this method sucks ass"));
        advanced = Trade.newTrade(args);
        //test advanced
        assertTrue((exit.equals(advanced.getExit())));
        assertTrue(new BigDecimal(2.0).equals(advanced.getExitPrice()));
        assertTrue(new BigDecimal(0.1).equals(advanced.getStopLoss()));
        assertTrue(new BigDecimal(2.0).equals(advanced.getTakeProfit()));
        assertTrue(new BigDecimal(0.5).equals(advanced.getCommissions()));
        assertEquals("this method sucks ass",advanced.getNotes());
    }
    @Test
    void newTradeBadPath() {
        List<TradeHelper> args = new ArrayList<>();
        Date entry = new Date();

        //forgot quantity
        args.add(new TradeHelper("instrument","APPL"));
        args.add(new TradeHelper("entry",entry));
        args.add(new TradeHelper("entryPrice",new BigDecimal(1.0)));
        args.add(new TradeHelper("actionBuy",true));
        basic = Trade.newTrade(args);
        assertTrue(basic==null);

        args.clear();
        //forgot actionBuy
        args.add(new TradeHelper("instrument","APPL"));
        args.add(new TradeHelper("entry",entry));
        args.add(new TradeHelper("entryPrice",new BigDecimal(1.0)));
        args.add(new TradeHelper("quantity",100));
        basic = Trade.newTrade(args);
        assertTrue(basic==null);

        args.clear();
        //forgot instrument
        args.add(new TradeHelper("entry",entry));
        args.add(new TradeHelper("entryPrice",new BigDecimal(1.0)));
        args.add(new TradeHelper("actionBuy",true));
        args.add(new TradeHelper("quantity",100));
        basic = Trade.newTrade(args);
        assertTrue(basic==null);

        args.clear();
        //forgot entry
        args.add(new TradeHelper("instrument","APPL"));
        args.add(new TradeHelper("entryPrice",new BigDecimal(1.0)));
        args.add(new TradeHelper("actionBuy",true));
        args.add(new TradeHelper("quantity",100));
        basic = Trade.newTrade(args);
        assertTrue(basic==null);

        args.clear();
        //forgot entryPrice
        args.add(new TradeHelper("instrument","APPL"));
        args.add(new TradeHelper("entry",entry));
        args.add(new TradeHelper("actionBuy",true));
        args.add(new TradeHelper("quantity",100));
        basic = Trade.newTrade(args);
        assertTrue(basic==null);

        args.clear();
        //add random objects
        args.add(new TradeHelper("fuck","stick"));
        args.add(new TradeHelper("ssads",1.0f));
        args.add(new TradeHelper("ssadsdas",2.0));
        args.add(new TradeHelper("ssadsdas",2.0));
        basic = Trade.newTrade(args);
        assertTrue(basic==null);
    }

    @Test
    void updateTradeStats() {
        //TODO
    }
}