package stock;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTrackerTest {

    @Test
    public void shouldBeAbleToAddStock() {

        StockTracker stockTracker = new StockTracker();

        stockTracker.addStock(new StockEntry(StockType.chocolate, 5));
        Predicate<StockEntry> stockEntryPredicate = (stockEntry ->
                stockEntry.getStockType().equals(StockType.chocolate));

        assertEquals(1, stockTracker.getStockEntries(stockEntryPredicate).size());
    }

    @Test
    public void shouldBeAbleToAddDifferentStockTypes() {

        StockTracker stockTracker = new StockTracker();

        stockTracker.addStock(new StockEntry(StockType.chocolate, 5));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 7));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 6));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 3));
        stockTracker.addStock(new StockEntry(StockType.chocolate, 8));

        Predicate<StockEntry> chocolatePredicate = (stockEntry ->
                stockEntry.getStockType().equals(StockType.chocolate));

        Predicate<StockEntry> saltySnackPredicate = (stockEntry ->
                stockEntry.getStockType().equals(StockType.saltysnack));

        assertEquals(2, stockTracker.getStockEntries(chocolatePredicate).size());
        assertEquals(3, stockTracker.getStockEntries(saltySnackPredicate).size());
    }

    @Test
    public void shouldBeAbleToGetStockLevel() {

        StockTracker stockTracker = new StockTracker();

        stockTracker.addStock(new StockEntry(StockType.chocolate, 5));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 7));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 4));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 1));
        stockTracker.addStock(new StockEntry(StockType.chocolate, 8));
        stockTracker.addStock(new StockEntry(StockType.chocolate, 5));

        Predicate<StockEntry> chocolatePredicate = (stockEntry ->
                stockEntry.getStockType().equals(StockType.chocolate));

        Predicate<StockEntry> saltySnackPredicate = (stockEntry ->
                stockEntry.getStockType().equals(StockType.saltysnack));

        assertEquals(18, stockTracker.getStockLevel(chocolatePredicate));
        assertEquals(12, stockTracker.getStockLevel(saltySnackPredicate));

    }

    @Test
    public void shouldBeAbleToGetOverAllStockLevelOne() {

        StockTracker stockTracker = new StockTracker();

        stockTracker.addStock(new StockEntry(StockType.chocolate, 5));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 7));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 4));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 1));
        stockTracker.addStock(new StockEntry(StockType.chocolate, 8));
        stockTracker.addStock(new StockEntry(StockType.chocolate, 5));

        assertEquals(30, stockTracker.getStockLevel());

    }

    @Test
    public void shouldBeAbleToGetOverAllStockLevelTwo() {

        StockTracker stockTracker = new StockTracker();

        stockTracker.addStock(new StockEntry(StockType.chocolate, 15));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 27));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 14));
        stockTracker.addStock(new StockEntry(StockType.saltysnack, 11));
        stockTracker.addStock(new StockEntry(StockType.chocolate, 8));
        stockTracker.addStock(new StockEntry(StockType.chocolate, 3));

        assertEquals(78, stockTracker.getStockLevel());

    }

}
