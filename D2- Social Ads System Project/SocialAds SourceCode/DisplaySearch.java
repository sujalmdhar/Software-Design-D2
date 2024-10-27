
/**
 * Stub class for Displaying Serach Results
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class DisplaySearch
{
    public DisplaySearch (){
       
    }
    
    public void showRecentSearch(ArrayList<Advertisement> results){
        
        
        if (!results.isEmpty()){
            for (Advertisement a:results){
                a.display();
           
            }
        }
        else {System.out.println("Sorry No Adverts Found");}
        
        System.out.println();
        
        }
     public void displayAllActivity(HashMap<String, Advertisement> activity){ 
        System.out.println("All Search Results");
        System.out.println("*******************************************" + "\n*******************************************");
        Set set = activity.entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            activity.get(me.getKey()).display();
            
    }
        System.out.println();
        
        }   
}
