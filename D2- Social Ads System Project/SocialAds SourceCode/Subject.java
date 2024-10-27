public interface Subject {
    void attach(Observer o); // Attach an observer
    void detach(Observer o); //Detach an observer
    void notifyObservers(Advertisement ad); // Notify all observers
}
