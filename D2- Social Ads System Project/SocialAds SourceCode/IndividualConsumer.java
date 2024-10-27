public class IndividualConsumer extends Consumer {

    private String DOB; // Date of Birth
    private String passportNumber;

    public IndividualConsumer(AdBank adBank) {
        super(adBank);
        this.DOB = "";
        this.passportNumber = "";
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDOB() {
        return DOB;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public void display() {
        System.out.println("Individual Consumer:");
        super.display();
        System.out.println("DOB: " + DOB);
        System.out.println("Passport Number: " + passportNumber);
    }
}
