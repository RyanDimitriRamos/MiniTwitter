package MiniTwitter.ObserverPattern;

public interface Subject {

    public void register(Observer observer);

    public void notifyObservers();
}
