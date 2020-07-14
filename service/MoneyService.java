package service;

public interface MoneyService {
	boolean validateMoney(int result);

	void deposit(int result);

    int getBalance();

    int getCurrentBalance();
    
    int getCharge();
    
    void addCharge(int charge);

    int getTotalMoney();
    
    void save();


}