package executionEngine;

import config.ActionKeywords;
import config.Constants;
import factory.LogFactory;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import utility.ExcelUtils;

import java.lang.reflect.Method;


public class DriverScript {
    private static WebDriver driver = null;
    private static Logger logger = LogFactory.getLogger(DriverScript.class);
    public static Method method[];
    public static String sActionKeyword;
    public static ActionKeywords actionKeywords;

    public static void main(String[] args) throws Exception{
        /**
         *         Step 1 – Open a Browser
         *         Step 2 – Navigate to URL
         *         Step 3 – Click on My Account button
         *         Step 4 – Enter Username
         *         Step 5 – Enter Password
         *         Step 6 – Click on LogIn button
         *         Step 7 – Click on LogOut button
         *         Step 8 – Close the Browser
         */
        ExcelUtils.setExcelFile(Constants.FILE_PATH, "Test Steps");

        //Hard coded values are used for Excel row & columns for now
        //In later chapters we will replace these hard coded values with varibales
        //This is the loop for reading the values of the column 3 (Action Keyword) row by row
        for (int iRow = 1;iRow <= 9;iRow++){
            //This to get the value of column Action Keyword from the excel
            sActionKeyword = ExcelUtils.getCellData(iRow, 3);
            //A new separate method is created with the name 'execute_Actions'
            //You will find this method below of the this test
            //So this statement is doing nothing but calling that piece of code to execute
            execute_Actions();
        }
    }
    private static void execute_Actions() throws Exception {
        //This is a loop which will run for the number of actions in the Action Keyword class
        //method variable contain all the method and method.length returns the total number of methods
        for(int i = 0;i < method.length;i++){
            //This is now comparing the method name with the ActionKeyword value got from excel
            if(method[i].getName().equals(sActionKeyword)){
                //In case of match found, it will execute the matched method
                method[i].invoke(actionKeywords);
                //Once any method is executed, this break statement will take the flow outside of for loop
                break;
            }
        }
    }
}
