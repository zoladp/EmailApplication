# Title: Email Application generator

## Project description: IT Support Administrator tool. 
Email tool solves problem with craation a huge amount new hired employess email addresses.
The application autmatically generates email addresses, assigns random password and manages 
mailbox settings

## Scenario.
You are an IT Support Administrator Specialist and are charged with the task of createing 
email accounts for new hires.

The applications should do the following:
- Generate an email with following syntax:
`firstname.lastname@department.company.com`
  
- Determine the department (sales, developmnet, accounting). If none
is provided leave blank
  
- Provide **setter** methods to:
    - change the password, 
    - set the mailbox capacity, 
    - define an alternate email address
- Provide **getter** methods to:
    - display:
        - name
        - email
        - mailbox capacity


## Project Structure (Maven)
```
email-application/
├── src/
│ ├── main/
│ │ └── java/
│ │ └── com/company/emailapp/
│ │ ├── EmailApp.java # main class
│ │ └── Email.java # business logic
│ └── test/
│ └── java/
│ └── com/company/emailapp/
│ └── EmailTest.java # unit tests
├── pom.xml
└── README.md
```

## How to Run
1. Clone this repository
   ```bash
   git clone https://github.com/your-username/email-application.git
2. Navigate into the project folder
3. cd email-application
4. Build with Maven ```mvn clean install```
5. Run the application
6. ```mvn exec:java -Dexec.mainClass="com.company.emailapp.EmailApp"```

## Example Output
New worker: John Smith  
Department: Development  
Generated Email: ```john.smith@development.company.com```   
Temporary password: Xh7#Pz92!   
Mailbox capacity: 500mb 

##Possible Extensions
Add more departments    
Encrypt generated passwords     
Store accounts in a database   
Generate email accounts in bulk    
Provide a simple GUI    