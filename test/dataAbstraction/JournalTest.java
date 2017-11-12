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
    }
    @AfterEach
    void tearDown() {
        journal = null;
        basic = null;
        advanced = null;
    }




    @Test
    void addTradeHappyPath() {
        //todo:: try and break this method
    }

    @Test
    void getItem() {

    }
}