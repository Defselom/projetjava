package selom.managedbeans;



import java.util.logging.Logger;

public class MainClass  {

     public static void main(String[] args) 
    { 
  
        // Create a Logger with class name GFG 
        Logger logger 
            = Logger.getLogger(MainClass.class.getName()); 
  
        // Call info method 
        logger.info("Message 1"); 
        logger.info("Message 2"); 
    } 

}
