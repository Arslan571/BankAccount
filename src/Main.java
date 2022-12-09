import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Account[] accounts = new Account[30];
        for(int i = 0; i < accounts.length; i++){
            accounts[i] = new Account();
        }

        Scanner input = new Scanner(System.in);
        int in;
        do{
            Menu();
            in = Integer.parseInt(input.nextLine());
            String string;
            double inAmt;
            boolean isFound;
            int position = 0;
            int index = 0;

            switch (in){
                case 0:
                    System.out.println("Goodbye! Thank you for using the L&L Bank!");
                    break;
                case 1:
                    int sum = 0;
                    isFound = false;
                    for(int i = 0; i < accounts.length; i++){
                        if(!accounts[i].getName().equals((""))){
                            accounts[i].getInfo();
                            sum += 1;
                            isFound = true;
                        }
                    }

                    if(!isFound){
                        System.out.println("Not a single account was found!");
                    }
                    break;
                case 2:
                    System.out.println("Please enter the name of account:");
                    string = input.nextLine();
                    isFound = false;
                    index = 0;

                    for(int i = 0; i < accounts.length; i++){
                        if(accounts[i].getName().toLowerCase().equals(string.toLowerCase())){
                            accounts[i].getInfo();
                            isFound = true;
                        }

                    }
                    if(!isFound){
                        System.out.println("No account with this name was found");
                    }
                    break;
                case 3:
                    System.out.println("Please enter the name of the account:");
                    string = input.nextLine();
                    isFound = false;
                    index = 0;
                    for(int i = 0; i < accounts.length; i++){
                        if(accounts[i].getName().toLowerCase().equals(string.toLowerCase())) {
                            isFound = true;
                            position = i;
                        }
                    }
                    if(!isFound){
                        System.out.println("No account with this name was found");
                    }else{
                        System.out.println("Account found");
                        System.out.println("Please enter the amount you wish to deposit:");
                        System.out.println("$");
                        inAmt = Double.parseDouble(input.nextLine());
                        accounts[position].deposit(inAmt);
                        System.out.println();
                        System.out.println("New account balance: $" + accounts[position].getBalance());
                    }
                    break;
                case 4:
                    System.out.println("Please enter the name of the account:");
                    string = input.nextLine();
                    isFound = false;

                    for(int i = 0; i < accounts.length; i++){
                        if(accounts[i].getName().toLowerCase().equals(string.toLowerCase())){
                            isFound = true;
                            position = i;
                        }
                    }
                    if(!isFound){
                        System.out.println("No account with this name was found");
                    }else{
                        System.out.println("Account is found");
                        System.out.println("Please enter the amount you wish to withdraw:");
                        System.out.println("$");
                        inAmt = Double.parseDouble(input.nextLine());
                        accounts[position].withdraw(inAmt);
                        System.out.println();
                        System.out.println("New account balance: $" + accounts[position].getBalance());
                    }
                    break;

                case 5:
                    System.out.println("Adding 3% interest to all available accounts...");
                    for(index = 0; index < accounts.length; index++){
                        accounts[index].addInterest();
                    }
                    System.out.println("Interst successfully added to all available accounts.");
                    break;

                case 6:
                    isFound = false;
                    index = 0;
                    while(index < accounts.length || !isFound){
                        if(accounts[index].getName().equals("")){
                            position = index;
                            isFound = true;
                        }
                        index++;
                    }
                    if(!isFound){
                        System.out.println("All available accounts are filled");
                    }else{
                        System.out.println("Empty account slot found.");
                        System.out.println("Please enter new account name:");
                        string = input.nextLine();
                        accounts[position].setName(string);
                        System.out.println("Please enter new account balance:");
                        System.out.println("$");
                        inAmt = Double.parseDouble(input.nextLine());
                        accounts[position].setBalance(inAmt);
                        System.out.println();
                        accounts[position].getInfo();
                    }
                break;

                case 7:
                   System.out.println("Please enter the name of the account:");
                   string = input.nextLine();
                   isFound = false;

                   for(int i = 0; i < accounts.length; i++){
                       if(accounts[i].getName().toLowerCase().equals(string.toLowerCase())){
                           isFound = true;
                           position = i;
                       }
                   }
                   if(!isFound){
                       System.out.println("No account with this name was found.");
                   }else{
                       System.out.println("Account found.");
                       System.out.println("Removing account named " + accounts[position].getName());
                       accounts[position].clearAccount();
                       System.out.println("Account removed.");
                   }
                    break;
                default:
                    break;
            }
        }while(in!=0);
        input.close();
    }

    public static void Menu(){
        System.out.println();
        System.out.println("Thanks for using the L&L Bank Online Banking System!");
        System.out.println();
        System.out.println("Select one of the following instructions by entering its listed number:");
        System.out.println();
        System.out.println("1: Display all current accounts");
        System.out.println("2: Find an account by name");
        System.out.println("3: Make a deposit");
        System.out.println("4: Make a withdrawal");
        System.out.println("5: Add interest to all accounts");
        System.out.println("6: Add an account");
        System.out.println("7: Remove an account");
        System.out.println("0: Exit");
        System.out.println();
    }
}
