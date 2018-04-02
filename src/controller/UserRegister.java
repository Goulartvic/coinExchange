package controller;

import model.User;

public class UserRegister {

    private CoinRegister coinRegister = new CoinRegister();

    public User newUser(String nome, String password) {
        return new User(nome, password, coinRegister.generateWallet());
    }
}
