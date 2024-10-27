import java.util.ArrayList;
import java.util.HashMap;

public class LoyaltyCard implements Subject {
    private HashMap<String, Advertisement> usedAds;  // Ads used by the consumer
    private ArrayList<Observer> observers;  // List of observers

    // Constructor that takes RRDisplay and RRDatabase and registers them as observers
    public LoyaltyCard(RRDisplay rrDisplay, RRDatabase rrDatabase) {
        usedAds = new HashMap<>();
        observers = new ArrayList<>();
        attach(rrDisplay);  // Attach RRDisplay as an observer
        attach(rrDatabase); // Attach RRDatabase as an observer
    }

    // Default constructor (if needed)
    public LoyaltyCard() {
        usedAds = new HashMap<>();
        observers = new ArrayList<>();
    }

    // Attach an observer to the list
    @Override
    public void attach(Observer o) {
        observers.add(o); // Add the observer to the list
    }
    
    @Override
    public void detach(Observer o) {
        observers.remove(o); // remove the observer from the list
    }

    // Notify all observers about the updated advertisement
    @Override
    public void notifyObservers(Advertisement ad) {
        for (Observer observer : observers) {
            observer.update(ad);  // Update all attached observers
        }
    }

    // Register a used advertisement
    public void registerUse(Advertisement used) {
        System.out.println("*******************************************");
        System.out.println("Register a Used Advertisement on the Loyalty Card");
        System.out.println("*******************************************");
        if (used != null) {
            usedAds.put(used.getTitle(), used);
            System.out.println(used.getTitle() + " Registered as Used Advertisement");
        } else {
            System.out.println("Sorry, you have not used that Advertisement.");
        }
        System.out.println();
    }

    // Display used advertisements
    public void displayUsed() {
        System.out.println("*******************************************");
        System.out.println("Displaying Used Advertisements");
        System.out.println("*******************************************");
        for (Advertisement ad : usedAds.values()) {
            ad.display();
        }
    }

    // Rate an advertisement
    public void rateAd(String title) {
        if (usedAds.containsKey(title)) {
            Advertisement ratedAd = usedAds.get(title);
            ratedAd.addRating();
            notifyObservers(ratedAd);  // Notify all observers when an ad is rated
        } else {
            System.out.println("Sorry, you cannot rate this advertisement as it was not used: " + title);
        }
        System.out.println();
    }

    // Review an advertisement
    public void reviewAd(String title) {
        if (usedAds.containsKey(title)) {
            Advertisement reviewedAd = usedAds.get(title);
            reviewedAd.addReview();
            notifyObservers(reviewedAd);  // Notify all observers when an ad is reviewed
        } else {
            System.out.println("Sorry, you cannot review this advertisement as it was not used: " + title);
        }
        System.out.println();
    }
}
