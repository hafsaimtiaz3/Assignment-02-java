public class ReutersQuoteEvent extends TradeEvent {
    private double bidPrice;
    private double askPrice;
    public ReutersQuoteEvent(String senderId, long timestamp,
                             double basePrice,
                             double bidPrice,
                             double askPrice) {
        super(senderId, timestamp, basePrice);
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }
    @Override
    public void dispatch() {
        double total = basePrice + (basePrice * 0.0015);
        double spread = askPrice - bidPrice;
        System.out.println("\nReuters Quote Event");
        System.out.println("Bid Price: $" + bidPrice);//updated bid
        System.out.println("Ask Price: $" + askPrice);
        System.out.println("Spread: $" + spread);
    }
}
