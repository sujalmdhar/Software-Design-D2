import java.util.ArrayList;

public class RRDatabase implements Observer {
    private static RRDatabase instance;  // Singleton instance
    private ArrayList<Advertisement> reviewedAds;  // List of reviewed ads

    public RRDatabase() {
        reviewedAds = new ArrayList<Advertisement>();
    }

    // Singleton pattern: provide the instance
    public static RRDatabase getInstance() {
        if (instance == null) {
            instance = new RRDatabase();
        }
        return instance;
    }

    // Implement the update method from the Observer interface
    @Override
    public void update(Advertisement ad) {
        if (!reviewedAds.contains(ad)) {
            reviewedAds.add(ad);  // Add the reviewed ad
        }
    }

    // Display all reviewed ads
    public void displayAdverts() {
        System.out.println("*******************************************");
        System.out.println("Display Reviewed and Rated Advertisements");
        System.out.println("*******************************************");

        for (Advertisement a : reviewedAds) {
            a.display();
            for (String review : a.getReviews()) {
                System.out.println("Review: " + review);
            }
            System.out.println("Average Rating: " + a.getAvgRanking());
            System.out.println("*******************************************\n");
        }
    }
}
