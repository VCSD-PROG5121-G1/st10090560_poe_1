/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poetask2;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author daiyaan
 */
public class POEtask2 {
 static String password;
    static String username;
    static String username2;
    static String name;
    static String name2;
    static String password2;
    static String TaskID;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //First a user needs to register
        JOptionPane.showMessageDialog(null, "Welcome user, please register before logging in.");

        name = JOptionPane.showInputDialog("Please enter your first name:");// must capture name data
        name2 = JOptionPane.showInputDialog("Please enter your last name:");// must capture name data

        //Username must be created, following specific instructions
        username = JOptionPane.showInputDialog(null, "Enter a username \n Usernames must be 5 characters long, with an underscore.");

        if (username.contains("_") && username.length() <= 5) {
            JOptionPane.showMessageDialog(null, "Username succesfully captured.");
            JOptionPane.showMessageDialog(null, "Welcome " + username);

          //only accept correctly formatted usernames
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            JOptionPane.showInputDialog(null, "Please enter your username");
        }
        checkPasswordComplexity();// call upon class to follow the correct order
        
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban"); // show display message
        int choice;
        
        choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Please select one of the following options: \n 1: Add tasks. \n 2: View report. \n 3: Quit."));
              
        if (choice==(1)){
             addtasks();// call upon the class
        }
        
    }

    public static boolean checkPasswordComplexity() {
// Passwords must:
//  At least 8 characters long
// Contain a capital letter
// Contain a number
// Contain a special character

        //use regex to identify key feauters, needed to be seen in password
        password = JOptionPane.showInputDialog("Please create your password");// password needs to be created 
        Pattern specialCharacters = Pattern.compile("[^a-zA-Z0-9]");
        Pattern CapLetters = Pattern.compile("(?=.*[A-Z])");
        Pattern Numbs = Pattern.compile("[0-9]+");

        //Patterns need to be matched with matchers
       
        Matcher matcher = specialCharacters.matcher(password); 
        Matcher matcher2 = CapLetters.matcher(password);
        Matcher matcher3 = Numbs.matcher(password);

        boolean doeshaveSpecialCharacter = matcher.find();
        boolean doeshaveCapLerrter = matcher2.find();
        boolean doeshaveNumbs = matcher3.find();

        if (password.length() >= 8 && doeshaveSpecialCharacter && doeshaveCapLerrter && doeshaveNumbs) {
            JOptionPane.showMessageDialog(null, "Password succesfully captured.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Password incorrect, please try again using the correct format");
            JOptionPane.showInputDialog(null, "Password incorrect, lease try again using the correct format");// only accept correctly formatted passwords
        }
        
    
         return valUserLogin();
         
         }

    
    
    public static boolean valUserLogin(){

        JOptionPane.showMessageDialog(null, "You may now login");

username2 = JOptionPane.showInputDialog("Please enter your username");
if(username2.equals(username)){
   password2 =  JOptionPane.showInputDialog("Please enter your password.");
}
if (password2.equals(password)){
    JOptionPane.showMessageDialog(null, "Welcome back " + name + " "+ name2 + " it is great to see you.");
}
else {
    JOptionPane.showMessageDialog(null, "Username or Password invalid, please try again.");
    JOptionPane.showInputDialog("Please enter your username");
    
}
       
    
     return false;
        }

    public static void addtasks() {
        
        int noTasks; 
        noTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks do you wish to add?"));
        
        for (int i = 0; i < noTasks; i++) {
          
            String tName;
            tName = JOptionPane.showInputDialog(null, "Please enter the task name.");
            
            int tNumb;
            tNumb = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the task number (Starting at 0)"));
            
            String tDescript;
            tDescript = JOptionPane.showInputDialog(null, "Please enter a description for your task, fewer than 50 words.");
           
            if (tDescript.length()<=50){
                
                JOptionPane.showMessageDialog(null, "Task succesfully captured.");
                
                
                String details;
                details = JOptionPane.showInputDialog(null, "Please enter the developer details (Fisrt and last name of develepor assigned to the task. ");
                
                int duration;
                duration = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the estimated duration of time (In hours) that the task should take"));
                
                JOptionPane.showMessageDialog(null, "Your task ID is: \n" + TaskID);
                
                String tStatus; 
                tStatus = JOptionPane.showInputDialog("Is your task \n 1: To do \n 2: Done \n 3: Doing");
            }
            else {
                JOptionPane.showMessageDialog(null, "“Please enter a task description of less than 50 characters");
                
            }
        }
    }
        
        public static String TaskID(String tName, String details, int tNumb){
         
             TaskID = tName.substring(0,2)+ ":" + Integer.toString(tNumb) + ":" + details.substring(details.length()-3);
            return TaskID.toUpperCase();
        }
}
  

   
    





    

