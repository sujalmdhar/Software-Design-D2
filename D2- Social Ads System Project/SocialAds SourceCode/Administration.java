import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.Random;

public class Administration
{ // stub class for Administration
    
    private HashMap<String, Consumer> consumers;
    
    
    public  Administration(){
        
        consumers = new HashMap<String, Consumer>() ;
      
    }
    
 
    public void signUp(AdBank adBank){
        Consumer consumer; 
        //Sign in  Consumer
       
        consumer = new Consumer(adBank);
        
        //set id
        consumer.setId(createId()); 
        
        // get details and store in consumer
        consumer.signUp();
        
        
        //consumers.add(consumer);
        consumers.put(consumer.getId(),consumer);
        
        
        //Simulate Consumer activity
        consumer.simulation();
        
    } 
    public String createId() {
        
        Random ran  = new Random();
        int i = ran.nextInt(100000);
        String id= i +"";
        return id;
        
    }
    public void display(){
        System.out.println("Display Consumers");
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        Set set = consumers.entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            consumers.get(me.getKey()).display();
        }
            
        System.out.println();
    
    } 
    public void changeDetails(String id){
        System.out.println("Consumers");
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        
        consumers.get(id).changeDetails();//find consumer and change
        
        
    }
    public static void main(String[] args){
        
            AdBank adBank = new AdBank();
            
            Administration  admin = new Administration();
            
            admin.signUp(adBank);
            
            
      
    }
}