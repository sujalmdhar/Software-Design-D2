

import java.util.ArrayList;
import java.util.HashMap;

public class AdBank{
    // stub class for online Advcwertisements
    private ArrayList<Advertisement> adverts;
    private HashMap<String, Advertisement> hashAdverts;
    public AdBank() {
        //setup the List 
        adverts = new ArrayList<Advertisement>();
        hashAdverts = new HashMap<String, Advertisement>();
        
        //setup the List 
        adverts.add(new Advertisement("B42 2SU", "Double Glazing", 400.2, "Smiths:Bay Window", "white 4x3"));
        adverts.add(new Advertisement("B42 2SU", "Double Glazing", 350.6, "Johnsons:Bay Window","Gray 2x3m "));
        adverts.add(new Advertisement("DY1 4YP", "Double Glazing", 150.2, "B&Q:Window",  "White 1 x 2 m"));
        adverts.add(new Advertisement("B42 2SU", "Books",   15.2, "Smiths:Lord of the Rings",  "Hardback:Tolken"));
        adverts.add(new Advertisement("B42 2SU", "Books",   10.2, "Hughes Books:In our Time",  "PaperBack:Robson"));
        adverts.add(new Advertisement("DY1 4YP", "Books",    5.2, "Waterstones:By the River Bank","Hardback:Peterson"));
        adverts.add(new Advertisement("B42 2SU", "Plumbing",   12.2, "Plumb Centre:Tap",  "Silver Bath "));
        adverts.add(new Advertisement("B42 2SU", "Plumbing",   50.50, "Plumb Centre:Sink",  "Stainless Steel"));
        adverts.add(new Advertisement("DY1 4YP", "Plumbing",   8.30, "Screwfix: Tap",  "Bronze Bath"));
        adverts.add(new Advertisement("B42 2SU", "DIY",   150.2, "B&Q:Hammer",  "Small"));
        adverts.add(new Advertisement("DY1 4YP", "DIY",   150.2, "Screwfix:Screw Driver",  "Large"));
        
        //setup the Hash
        for (Advertisement a:adverts){
            hashAdverts.put(a.getTitle(),a );
            
        }
        
     
    }   

    public ArrayList<Advertisement> getFeed() {
        return adverts;
    }
    
    public Advertisement getAdvertisement(String title) {
        return hashAdverts.get(title);
       
            
    }
        
}