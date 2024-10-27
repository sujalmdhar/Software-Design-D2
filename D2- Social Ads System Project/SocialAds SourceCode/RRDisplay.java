import java.util.ArrayList;

public class RRDisplay implements Observer {
    private ArrayList<Advertisement> reviewedAds;  // List of reviewed ads

    public RRDisplay() {
        reviewedAds = new ArrayList<Advertisement>();
    }

    // Implement the update method from the Observer interface
    @Override
    public void update(Advertisement ad) {
        if (!reviewedAds.contains(ad)) {
            reviewedAds.add(ad);  // Add the reviewed ad
        }
    }

    // Display all reviews for the ads
    public void displayReviews() {
        System.out.println("*******************************************");
        System.out.println("Display Reviews");
        System.out.println("*******************************************");

        for (Advertisement a : reviewedAds) {
            System.out.println("Reviews for " + a.getTitle());
            for (String review : a.getReviews()) {
                System.out.println("Review: " + review);
            }
        }
    }

    // Display all ratings for the ads
    public void displayRatings() {
        System.out.println("*******************************************");
        System.out.println("Display Ratings");
        System.out.println("*******************************************");

        for (Advertisement a : reviewedAds) {
            System.out.println("Average Rating for " + a.getTitle() + ": " + a.getAvgRanking());
        }
    }
}
