package controller;

import model.Coin;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class CoinRegister {

    private Coin real = new Coin("Real",1);
    private Coin pic = new Coin("Pic", 3.14);
    private Coin doge = new Coin("Doge", 2.5);
    private Coin crip = new Coin("Crip", 5.83);
    private Coin mob = new Coin("MOB", 4.74);

    public Map<String, Double> generateWallet() {
        Map<String, Double> wallet = new HashMap<>();
        wallet.put(real.getName(), real.getValue()*0);
        wallet.put(pic.getName(), pic.getValue()*0);
        wallet.put(doge.getName(), doge.getValue()*0);
        wallet.put(crip.getName(), crip.getValue()*0);
        wallet.put(mob.getName(), mob.getValue()*0);

        return wallet;
    }

    public void depositReal(User user, double value) {
        user.getWallet().replace("Real", value);
    }

    public void withdrawReal(User user, double value) {
        if (value <= user.getWallet().get("Real")) {
            user.getWallet().replace("Real", (user.getWallet().get("Real") - value));
        }
        else {
            System.out.println("Falta dinheiros!");
        }
    }

    public void exchange(User user, double value, Coin coinOut, Coin coinIn) {
        if (value > user.getWallet().get(coinOut.getName())) {
            System.out.println("Falta dinheiro");
        }
        else {
            double walletCoinOut = user.getWallet().get(coinOut.getName()) - value;
            double walletCoinIn = user.getWallet().get(coinIn.getName());
            double coinOutToCoinIn = (value / coinIn.getValue()) + walletCoinIn;

            user.getWallet().replace(coinOut.getName(), walletCoinOut);
            user.getWallet().replace(coinIn.getName(), coinOutToCoinIn);
        }
    }

    public static void main(String[] args) {
        CoinRegister coinRegister = new CoinRegister();
        User user = new User("Teste", "teste",coinRegister.generateWallet());
        coinRegister.depositReal(user, 200);
        Coin coinOut = coinRegister.real;
        Coin coinIN = coinRegister.crip;
        coinRegister.exchange(user, 100, coinOut, coinIN);
        System.out.println(user.getWallet());
        coinRegister.withdrawReal(user,80);
        System.out.println(user.getWallet());
    }
}
