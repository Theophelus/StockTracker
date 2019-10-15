package stock;

class StockEntry {
    private StockType stockType;
    private int qty;

    public StockEntry(StockType stockType, int qty) {
        this.stockType = stockType;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public StockType getStockType() {
        return stockType;
    }
}
