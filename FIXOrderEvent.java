public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;
    public FIXOrderEvent(String senderId, long timestamp,
                         double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }
    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015;
        double totalAmount = basePrice + fee;
        System.out.println("\nFIX Order Event");
        System.out.println("Client Order ID: " + clOrdId);
        System.out.println("Stock Price: $" + basePrice);
        System.out.println("Exchange Fee: $" + fee);
        System.out.println("Total Amount: $" + totalAmount);
    }
}