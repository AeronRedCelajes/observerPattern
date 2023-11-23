package observerPattern;
import java.util.ArrayList;
import java.util.List;

// The Concrete Subject
public class NewsAgency implements NewsAgencySubject {
    private List<Subscriber> subscribersList = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribersList.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribersList.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribersList) {
            subscriber.update(news);
        }
    }

    // Simulate publishing breaking news
    public void publishNews(String news) {
        System.out.println("Breaking News!: " + news);
        //tells the news
        notifySubscribers(news);
    }
}
