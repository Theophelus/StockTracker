package stock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockTracker {

    private List<StockEntry> stockList = new ArrayList<>();

    public void addStock(StockEntry entry) {

        stockList.add(entry);
    }

    /**
     * Get the number of entries for a given StockType
     *
     * @param stockEntryPredicate
     * @return
     */
    public List<StockEntry> getStockEntries(Predicate<StockEntry> stockEntryPredicate ) {

        ArrayList<StockEntry> entriesFound = new ArrayList<>();

        for (StockEntry entry: stockList){
            if (stockEntryPredicate.test(entry)){
                entriesFound.add(entry);
            }
        }

        return entriesFound;
    }

    /**
     * Get the number of entries for a given StockType
     *
     * @param stockEntryPredicate
     * @return
     */
    public int getStockLevel(Predicate<StockEntry> stockEntryPredicate ) {
        int stockLevel = 0;
        //loop through the list  check for specific product an return its size
        for (StockEntry entry: stockList){
            if (stockEntryPredicate.test(entry)){
                stockLevel += entry.getQty();
            }
        }
        return stockLevel;
    }

    public int getStockLevel() {
        int stockLevel = 0;
        //
        for (StockEntry entry: stockList){
            stockLevel += entry.getQty();
        }
        return stockLevel;
    }



}
