import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Consumer {

    private String id = "00000";
    private String name;
    private String address;
    private String email;
    private String telephoneNumber;
    private HashMap<String, Advertisement> activity;
    private AdBank adBank;
    private ArrayList<Advertisement> results;
    private DisplaySearch displaySearch;
    private LoyaltyCard loyaltyCard;
    private RRDisplay rrDisplay;
    private RRDatabase rrDatabase;

    public Consumer(AdBank adBank) {
        // create stubs for online advertisements and Admin
        this.adBank = adBank;

        // Hashmap to record activity
        activity = new HashMap<String, Advertisement>();

        // Display searches
        displaySearch = new DisplaySearch();

        rrDisplay = new RRDisplay();

        rrDatabase = new RRDatabase();

        // Setup Loyalty card
        loyaltyCard = new LoyaltyCard(rrDisplay, rrDatabase);
    }

    public void display() {
        System.out.println("Id Number: " + id + "\n" + name + "\n" + telephoneNumber + "\n" + address + "\n" + email + "\n" + "*******************************************");
    }

    @SuppressWarnings("resource")
	public void signUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*******************************************");
        System.out.println("Sign up as: ");
        System.out.println("1. Individual Consumer");
        System.out.println("2. Corporate Consumer");
        System.out.println("*******************************************");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the newline left after nextInt()

        if (choice == 1) {
            // Create an IndividualConsumer
            IndividualConsumer individualConsumer = new IndividualConsumer(adBank);

            // Collect details specific to an IndividualConsumer
            System.out.println("Enter Date of Birth (DOB) in format YYYY-MM-DD: ");
            String dob = scanner.nextLine(); // Get Date of Birth
            LocalDate birthDate = LocalDate.parse(dob, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate today = LocalDate.now();

            // Calculate the age
            Period age = Period.between(birthDate, today);

            if (age.getYears() >= 18) {
                individualConsumer.setDOB(dob);
                System.out.println("Enter Passport Number: ");
                String ppNum = scanner.nextLine();  // Get Passport Number
                individualConsumer.setPassportNumber(ppNum);
            } else {
                System.out.println("You must be over 18 to register.");
                signUp(); // Re-prompt the user to sign up
                return;
            }

        } else if (choice == 2) {
            // Create a CorporateConsumer
            CorporateConsumer corporateConsumer = new CorporateConsumer(adBank);

            // Collect details specific to a CorporateConsumer
            System.out.println("Enter Company Sector: ");
            String sector = scanner.nextLine();

            if (!sector.isEmpty()) {
                corporateConsumer.setSector(sector);
            } else {
                System.out.println("Company sector is required.");
                signUp(); // Re-prompt the user to sign up
                return;
            }

        } else {
            System.out.println("Invalid choice! Please choose 1 or 2.");
            signUp(); // Recursively prompt again for valid input
            return;
        }

        // Get common details for both types of consumers
        name = "John";
        telephoneNumber = "07384983844";
        email= "johnK@bcu.ac.uk";
        address = "B42 2SU";
        display();

    }

    public void changeDetails() {
        System.out.println("Display new details after update");
        // Get change details from consumer and store
        address = "WV69 7G";

        display();
        System.out.println("*******************************************");
        System.out.println("*******************************************");
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void simulation() {
        // search
        searchSectorByLocation("Double Glazing", "B42 2SU");
        searchSectorByLocation("Books", "DY1 4YP");
        searchSectorByLocation("Books","DY1 4VP");
        
        
        // display all results
        displaySearch.displayAllActivity(activity);

        // some advertisements are used
        activityRegistered();

        // The consumer displays reviewable/ratable advertisements
        loyaltyCard.displayUsed();

        // Review an advertisement and display
        reviewAd("Smiths:Bay Window");
        reviewAd("B&Q:Hammer");

        // Display Reviews from Database
        rrDisplay.displayReviews();

        // Rate an advertisement and display
        rateAd("Smiths:Bay Window");
        rateAd("Screwfix:Screw Driver");

        // Display Reviews from Database
        rrDisplay.displayRatings();

        // Dump database
        rrDatabase.displayAdverts();
    }

    public void searchSectorByLocation(String sector, String location) {
        // Do a search by location
        Search s1 = new Search(sector, adBank);
        results = s1.searchByLocation(location);

        // Remember the activity
        for (Advertisement a : results) {
            activity.put(a.getTitle(), a);
        }

        // Display search results
        displaySearch.showRecentSearch(results);
    }

    public void activityRegistered() {
        loyaltyCard.registerUse(adBank.getAdvertisement("Smiths:Bay Window"));
        loyaltyCard.registerUse(adBank.getAdvertisement("Johnsons:Bay Window"));
        loyaltyCard.registerUse(adBank.getAdvertisement("B&Q:Hammer"));
        loyaltyCard.registerUse(adBank.getAdvertisement("Screwfix:Screw Driver"));
    }

    public void reviewAd(String title) {
        System.out.println("*******************************************");
        System.out.println("The consumer reviews an advertisement");
        System.out.println("*******************************************");
        // Review an advertisement
        loyaltyCard.reviewAd(title);
    }

    public void rateAd(String title) {
        System.out.println("*******************************************");
        System.out.println("The consumer rates an advertisement");
        System.out.println("*******************************************");
        // Rate an advertisement
        loyaltyCard.rateAd(title);
    }
}
