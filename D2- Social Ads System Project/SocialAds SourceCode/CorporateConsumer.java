public class CorporateConsumer extends Consumer {

    private String sector;
    public CorporateConsumer(AdBank adBank) {
        super(adBank);
        this.sector = "";

    }

    
    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public void display() {
        System.out.println("Corporate Consumer:");
        super.display();
        System.out.println("Sector: " + sector);
    }
}
