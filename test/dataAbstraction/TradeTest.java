package dataAbstraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TradeHelper;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TradeTest {
    private Trade basic,advanced, two;

    @BeforeEach
    void setUp() {
        Date date = new GregorianCalendar(2017, Calendar.NOVEMBER, 11).getTime();
        Date dateTwo = new GregorianCalendar(2017, Calendar.NOVEMBER, 12).getTime();
        basic = new Trade.TradeBuilder("CAPR",new Date(),new BigDecimal(1.0),true,1,false)
                .build();
        advanced = new Trade.TradeBuilder("YUMA",new Date(),new BigDecimal(2.0),false,1,true)
                .commissions(new BigDecimal(0.3))
                .exit(new Date())
                .exitPrice(new BigDecimal(3.0))
                .notes("fuck i suck")
                .setup_classification("short into strength")
                .stopLoss(new BigDecimal(2.8))
                .takeProfit(new BigDecimal(1.5))
                .build();
        two = new Trade.TradeBuilder("/ZB", date, new BigDecimal(152.06), true, 1, false)
                .exit(dateTwo)
                .exitPrice(new BigDecimal(153))
                .build();
        System.out.println(advanced.getTrade_duration());
    }

    @AfterEach
    void tearDown() {
        basic=null;
        advanced=null;
    }

    @Test
    void updateTradeStats() {
       // int days = Date.
       // assertTrue(two.getTrade_duration() == )
        assertTrue(advanced.getPnl().compareTo(new BigDecimal(-1.0))==0);
        assertTrue(advanced.getTrade_duration().getSeconds()==0);
        assertTrue(!advanced.getWinner());
        //todo:: more testing here for update method
    }
}