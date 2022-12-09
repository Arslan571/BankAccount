import java.text.NumberFormat;

public class Account {
    private final double RATE = 0.035;

    private long acctNumber;
    private double balance;
    private String name;

    public Account(){
        this.name = "";
        balance = 0.0;
    }

    public void clearAccount(){
        this.name = "";
        this.balance = 0.0;
    }

    public double deposit(double amount){
        balance = balance + amount;
        return balance;
    }

    public void withdraw(double amount){
        if(this.balance<amount){
            System.out.println("Invalid transaction: not enough funds");
        }else{
            setBalance(this.balance-amount);
        }
    }

    public double addInterest(){
        balance += (balance * RATE);
        return balance;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void getInfo(){
        System.out.println();
        System.out.println("Account info:");
        System.out.println("Name: " + this.name);
        System.out.println("Balance $" + this.getBalance());
    }

    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return acctNumber + "\t" + name + "\t" + fmt.format(balance);
    }
}
