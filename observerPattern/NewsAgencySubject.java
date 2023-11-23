package observerPattern;

// The subject
public interface NewsAgencySubject {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String news);
}
