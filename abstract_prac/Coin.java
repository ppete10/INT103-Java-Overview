package testEnum;

public enum Coin {
    Penny(1) , Nickle(5) , Dime(10) , Quarter(25);

    private final double Coin;

    Coin(double coin) {
        this.Coin = coin;
    }

    public double getCoin() {
        return Coin;
    }
}
class Main3 {
    public static void main(String[] args) {
//        for (Coin coin : Coin.values()) {
//            System.out.println(coin + " " + coin.getCoin());
//        }
        int totalValue = 0;
        Coin[] coins = {Coin.Penny,Coin.Penny,Coin.Nickle,Coin.Dime,Coin.Quarter};
        for (Coin coin : coins) {
            totalValue += coin.getCoin();
        }
        System.out.println(totalValue);
    }
}