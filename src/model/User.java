package model;

import java.util.List;
import java.util.Map;

public class User {

    private String name;

    private String password;

    private Map<String, Double> wallet;

    private List<String> depositHistory;

    public User(String name, String password, Map<String, Double> wallet) {
        this.name = name;
        this.password = password;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Double> getWallet() {
        return wallet;
    }

    public void setWallet(Map<String, Double> wallet) {
        this.wallet = wallet;
    }

    public List<String> getDepositHistory() {
        return depositHistory;
    }

    public void setDepositHistory(List<String> depositHistory) {
        this.depositHistory = depositHistory;
    }
}
