import java.text.DecimalFormat;
import java.util.Scanner;

public class Account
{
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int setCustomerNumber(int customerNumber)
    {
        this.customerNumber = customerNumber;
        return customerNumber;
    }
    public int setPinNumber(int pinNumber)
    {
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    public int getCustomerNumber()
    {
        return this.customerNumber;
    }
    public int SetPinNumber(int pinNumber)
    {
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    public int getPinNumber()
    {
        return this.pinNumber;
    }
    public double getCheckingBalance()
    {
        return this.checkingBalance;
    }
    public double getSavingBalance()
    {
        return this.savingBalance;
    }
    public double calcCheckingWithdraw(double amount)
    {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }
    public double calcSavingWithdraw(double amount)
    {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
    public double calcCheckingDeposit(double amount)
    {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }
    public double calcSavingDeposit(double amount)
    {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCheckingWithdrawInput()
    {
        System.out.println("your Checking Account balance is: " + moneyFormat.format(checkingBalance));
        System.out.println("The amount you want to withdraw from Checking account: ");
        double amount = input.nextDouble();
        if((checkingBalance-amount) >= 0)
        {
            calcCheckingWithdraw(amount);
            System.out.println("The new checking balance is: " + moneyFormat.format(checkingBalance));
        }
        else
        {
            System.out.println("The balance can´t be negative." + "\n");
        }
    }
    public void getSavingWithdrawInput()
    {
        System.out.println("The saving account Balance is: " + moneyFormat.format(savingBalance));
        System.out.println("The amount you want to withdraw from saving account: ");
        double amount = input.nextDouble();
        if((savingBalance - amount) >= 0)
        {
            calcSavingWithdraw(amount);
            System.out.println("The new saving balance is: " + moneyFormat.format(savingBalance));
        }
        else
        {
            System.out.println("the balance can´t be negative." + "\n");
        }
    }

    public void getCheckingDepositInput()
    {
        System.out.println("your Checking Account balance is: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to Deposit from Checking Account: ");
        double amount = input.nextDouble();
        if((checkingBalance + amount) >= 0)
        {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        }
        else
        {
            System.out.println("The balance can´t be negative." + "\n");
        }
    }

    public void getSavingDepositInput()
    {
        System.out.println("Your Saving Account balance is: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to Deposit from Saving Account: ");
        double amount = input.nextDouble();
        if((savingBalance + amount) >= 0)
        {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        }
        else
        {
            System.out.println("The balance can´t be negative." + "\n");
        }
    }
}
