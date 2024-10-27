
/**
 * Write a description of class Advertisement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author minut
 */
class Advertisement {

    private String businessPostCode;
    private String businessSector;
    private double productPrice;
    private ArrayList<Integer> ratings;
    private ArrayList<String> reviews;
    private String title;
    private String adText;

    public Advertisement(String businessPostCode, String businessSector, double productPrice, String title, String adText) {
        this.businessPostCode = businessPostCode;
        this.businessSector = businessSector;
        this.productPrice = productPrice;
        this.title = title;
        this.adText = adText;
        ratings=new ArrayList<Integer>();
        reviews=new ArrayList<String>();

    }

    public void addReview() {
        System.out.println("Add a Review" + "\n*******************************************" );
        System.out.println("Please input a Review for " + title);
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream   
        String review = sc.nextLine();      //reads string   
        reviews.add(review);
        
    }
    
    public  ArrayList<String> getReviews() {
        return reviews;
    }
    
    public String getTitle() {
        return this.title;
    }

    public void addRating() {
        System.out.println("Add a Rating" + "\n*******************************************" );
        System.out.println("Please input a Ranking 0 - 10 for " + title);
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream   
        int rate = sc.nextInt(); 
        ratings.add(rate);    
    }
    
    public String getPostCode(){
        return this.businessPostCode;
    }

    public String getSector() {
        return this.businessSector;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public double getAvgRanking() {
        double temp=0;
        for(int r:ratings){
            temp+=r;
        }
        return temp/ratings.size();
    }
    
    public void display(){
        System.out.println(title +  "\n" + adText +"\nFind out more at: "+businessPostCode +"\nFor just: " + "£"+ productPrice + "\n" + "*******************************************");
    }
}