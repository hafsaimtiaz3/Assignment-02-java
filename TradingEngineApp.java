public class TradingEngineApp {
    public static void main(String[] args) {
        TradeEvent event1 =
                new FIXOrderEvent(
                        "FIX001",
                        System.currentTimeMillis(),
                        5000,
                        "ORD123"
                );
        TradeEvent event2 =
                new ReutersQuoteEvent(  //redefined
                        "RTR001",
                        System.currentTimeMillis(),
                        0,
                        250.50,
                        252.75
                );
        System.out.println(senderId);
        event1.dispatch();
        event2.dispatch();
    }
}
