package controller;

import model.User;

public class UserRegister {

    CoinRegister coinRegister = new CoinRegister();

    User user = new User("Teste", "test", coinRegister.generateWallet());
}
