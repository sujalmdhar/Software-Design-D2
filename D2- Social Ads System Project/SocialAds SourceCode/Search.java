



import java.util.ArrayList;


public class Search {
    //private int searchMode;//1 for location, 2 for budget, 3 for review
    private String sector;
    //private OnlineAdFeed feed;
    private ArrayList<Advertisement> result;
    private AdBank adBank;

    public Search(String sector, AdBank adBank) {
     this.sector = sector;
        this.adBank= adBank;   
    }

    public ArrayList<Advertisement> retrieve() {
        return result;
    }
    
    
    public ArrayList<Advertisement> searchByLocation(String postCode){
        this.sector = sector;
        this.adBank= adBank;
        ArrayList<Advertisement> result=new ArrayList<Advertisement>();
        for (Advertisement a:adBank.getFeed()){
            if(a.getPostCode().substring(0,2).equals(postCode.substring(0, 2))&&a.getSector().equals(sector)){
                result.add(a);
            }
        
        }
        System.out.println("Results of Search for " + sector + "  " + postCode);
        System.out.println("*******************************************" + "\n*******************************************");
        this.result=result;
        return result;
    }
    
    public ArrayList<Advertisement> searchByBudget(double budget,int range){
        
        ArrayList<Advertisement> result=new ArrayList<Advertisement>();
        for (Advertisement a:adBank.getFeed()){
            if(budget-range <= a.getProductPrice()&& budget+range >=a.getProductPrice()&&a.getSector().equals(sector)){
                result.add(a);
            }
        
        }
        System.out.println("Results of Search for " + "  " + sector +"  " + budget + "  " + range);
        System.out.println("*******************************************" + "\n*******************************************");
        this.result=result;
        return result;
    }
    
    public ArrayList<Advertisement> searchByRating(int rating){
        
        ArrayList<Advertisement> result=new ArrayList<Advertisement>();
        for (Advertisement a:adBank.getFeed()){
            if(rating-1<=a.getAvgRanking()&&a.getAvgRanking()>=1+rating&&a.getSector().equals(sector)){
                result.add(a);
            }
        
        }
        System.out.println("Results of Search for " + sector + "  " + rating);
        System.out.println("*******************************************" + "\n*******************************************");
        this.result=result;
        return result;
    }
}