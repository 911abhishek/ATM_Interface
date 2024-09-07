import java.util.Scanner;
class BankAccount{
    String name;
    String username;
    String password;
    String accountNo;
    float balance = 10000f;
    int transactions = 0;
    String transactionHistory = "";
    public  void register(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter Your Name: ");
        this.name = input.nextLine();
        System.out.println("\nEnter Your User Name: ");
        this.username = input.nextLine();
        System.out.println("\nEnter Your Password: ");
        this.password = input.nextLine();
        System.out.println("\nEnter Your Account Number: ");
        this.accountNo = input.nextLine();
        System.out.println("\nRegistration Successful. Please Log in to your Bank Account");
    }
    public boolean login() {
        boolean isLogin = false;
//        String Username;
        Scanner input = new Scanner(System.in);
            while( !isLogin){
            System.out.println("\nEnter Your User Name: ");
            String Username = input.nextLine();
            if(Username.equals(username)){
                while(!isLogin){
                    System.out.println("\nEnter Your Password: ");
                    String Password = input.nextLine();
                    if(Password.equals(password)){
                        System.out.println("\nLogin Successful");
                        isLogin = true;
                    }
                    else{
                        System.out.println("\nIncorrect Password");
                    }
                }
            }else{
                System.out.println("\nUserName not valid");

            }

        }
            return isLogin;
    }
    public void withdraw(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter Amount to Withdraw");
        float Amount = input.nextFloat();
        try{
            if(balance >= Amount){
                transactions ++;
                balance -= Amount;
                System.out.println("\nWithdraw Successful!");
                String str = Amount +"Rs Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("\nInsufficient Balance");
            }
        }catch(Exception e){
            System.out.println("Error Code "+ e);
        }
    }
    public void deposit(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter Amount to Deposit");
        float Amount = input.nextFloat();
        try{
            if(balance >= 10000){
                transactions ++;
                balance += Amount;
                System.out.println("\nDeposit Successful!");
                String str = Amount +"Rs Deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("\nSorry Deposit limit is 100000");
            }
        }catch(Exception e){
            System.out.println("Error Code "+ e);
        }
    }
    public void transfer(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter Recipient Name");
        String recipient = input.nextLine();
        System.out.println("\nEnter Amount to Transfer");
        float Amount = input.nextFloat();
        try{
            if(balance>= Amount) {
                if (balance <= 10000f) {
                    transactions ++;
                    balance += Amount;
                    System.out.println("\nSuccessfully Transferred to "+ recipient);
                    String str = Amount + "Rs Transferred to "+recipient +"\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry transfer limit is 100000");
                }
            }
            else {
                System.out.println("\nInsufficient Balance");
            }
            }catch(Exception e){
            System.out.println("Error Code "+ e);
        }
        }

    public void checkbalance(){
    System.out.println("\n"+balance+"Rs");
    }



    public void transactionHistory(){
        if(transactions == 0){
            System.out.println("No Transaction Happened!");
        }
        else{
            System.out.println("\n"+transactionHistory);
        }
    }
}


public class AtmInterface {
        public static int takenIntegerInput(int limit){
            int i = 0;
            boolean flag = false;
            while(!flag){
                try{
                    Scanner input = new Scanner(System.in);
                    i = input.nextInt();
                    flag = true;
                    if(flag && i>limit || i <1){
                        System.out.println("Choose the number between1 to "+limit);
                        flag = false;
                    }
                }catch (Exception e){
                    System.out.println("Enter only integer value! Error code:"+e);
                    flag=false;
                }
            }
            return i;
        }
        public static void main(String[] args){
            System.out.println("\n\t Welcome to Oasis Bank Atm Intreface");
            System.out.println("Choose the Desired Options: ");
            System.out.println("1.Register\n2.Exit");
            int choose = takenIntegerInput(2);

            if(choose == 1){
                BankAccount b=new BankAccount();
                b.register();
                while(true){
                    System.out.println("1.Login\n2.Exit");
                    System.out.println("Choose the Desired Options: ");
                    int ch = takenIntegerInput(2);
                    if(ch==1){
                        if(b.login()){
                            System.out.println("\nWelcome "+b.name);
                            boolean isFinished = false;
                            while(!isFinished){
                                System.out.println("1.Withdraw\n2.Deposit\n3.Transfer\n4.check Balance\n5.Transaction History\n6.Exit");
                                System.out.println("Choose the Desired Options: ");
                                int c = takenIntegerInput(6);
                                switch(c){
                                    case 1:
                                        b.withdraw();
                                        break;
                                    case 2:
                                        b.deposit();
                                        break;
                                    case 3:
                                        b.transfer();
                                        break;
                                    case 4:
                                        b.checkbalance();
                                        break;
                                    case 5:
                                        b.transactionHistory();
                                        break;
                                    case 6:
                                        isFinished = true;
                                        break;

                                }
                            }
                        }
                        else{
                            System.exit(0);
                        }
                    }

                }
            }
            else {
                System.exit(0);
            }
        }
    }
