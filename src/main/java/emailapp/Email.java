package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //Call a method asking for the department -> return the department
        this.department = setDepartment();
        //Call a method that returns a random password
        int defaultPasswordLength = 20;
        this.password = randomPassword(defaultPasswordLength);
        //Combine elements to generate email
        this.email = (this.firstName+"."+this.lastName+"@"+(this.department.isEmpty()?"":this.department+".")+this.companySuffix).toLowerCase();
    }

    //Ask for the department
    private String setDepartment() {
        System.out.print("New worker: "+this.firstName+". DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {return "sales";}
        else if (depChoice == 2) {return "dev";}
        else if (depChoice == 3) {return "acct";}
        else {return "";}
    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWVXYZ0123456789!@#$%&";
        char[] password = new char[length];

        for (int i=0;i<length;i++) {
            char selectChar;
            do {
                int rand = (int) (Math.random() * passwordSet.length());
                selectChar = passwordSet.charAt(rand);
                //Pseudo losowo zmień na małą literę, z 50% szansą zamienia literę na małą
                if(Character.isLetter(selectChar) && Math.random() < 0.5) {
                    selectChar = Character.toLowerCase(selectChar);
                }
                //pierwszy znak, musi być literą, powtarzaj losowanie, jeśli nie jest.
                //środkowy znak, nie może być literą ani cyfrą – czyli musi być znakiem specjalnym, powtarzaj losowanie, jeśli jest literą lub cyfrą.
                //ostatni znak, musi być cyfrą, powtarzaj losowanie, jeśli nie jest cyfrą.
            } while ((i==0 && !Character.isLetter(selectChar)) ||
                    (i==length/2 && Character.isLetterOrDigit(selectChar)) ||
                    (i==length-1 && !Character.isDigit(selectChar)));
                password[i] = selectChar;
        }
        //return new String(password);

        StringBuilder sb = new StringBuilder();
        for(char c : password) {
            sb.append(c);
        }
        return sb.toString();
    }

    //Set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    public int getMailboxCapacity() {return this.mailboxCapacity;}


    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    public String getAlternateEmail() {return this.alternateEmail;}

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }
    public String getPassword() {return this.password;}

    public String showInfo() {
        return "DISPLAY NAME: "+this.firstName +" "+this.lastName+
               "\nCOMPANY EMAIL: "+this.email+
               "\nCOMPANY EMAIL PASSWORD: \t"+this.password+
               "\nLOWER CASE PASSWORD: \t\t"+this.password.toLowerCase()+
               "\nMAILBOX CAPACITY: "+this.mailboxCapacity +"mb";

    }
}
