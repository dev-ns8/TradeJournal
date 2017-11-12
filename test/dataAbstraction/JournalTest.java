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

class JournalTest {
    Journal journal;
    Trade basic, advanced;

    @BeforeEach
    void setUp() {
        journal = new Journal();

        List<TradeHelper> args= new ArrayList<>();

        Date entry = new Date();
        args.add(new TradeHelper("instrument","APPL"));
        args.add(new TradeHelper("entry",entry));
        args.add(new TradeHelper("entryPrice",new BigDecimal(1.0)));
        args.add(new TradeHelper("actionBuy",true));
        args.add(new TradeHelper("quantity",100));
        basic = Trade.newTrade(args);

        advanced = new Trade("CAPR",new Date(),new BigDecimal(2.0),false,100);
    }
    @AfterEach
    void tearDown() {
        journal = null;
        basic = null;
        advanced = null;
    }




    @Test
    void addTradeHappyPath() {
        //test if in journal and accessible, and passing reference, not copy
        journal.addTrade(basic);
        assertTrue(journal.getItem(0).getInstrument().equalsIgnoreCase("appl"));
        basic.setInstrument("dick");
        assertTrue(journal.getItem(0).getInstrument().equalsIgnoreCase("dick"));//reference!
    }

    @Test
    void getItem() {

    }
}