package observerPattern;
import java.util.*;

// The Concrete Observer
public class SubscriberNews implements Subscriber {
    private String name;
    private NewsAgency newsAgency;
    private List<String> preferencesList = new ArrayList<>();

    public SubscriberNews(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        if (newsMatchesPreferences(news))
            System.out.println(name + " received breaking news: " + news);
    }

    @Override
    public void subscribeToNewsAgency(NewsAgency newsAgency) {
        this.newsAgency = newsAgency;
        newsAgency.subscribe(this);
    }

    @Override
    public void unsubscribeFromNewsAgency() {
        if (newsAgency != null) {
            newsAgency.unsubscribe(this);
        }
    }

    @Override
    public void modifyPreferences(List<String> newPreferences) {
        preferencesList = newPreferences;
        System.out.println(name + "'s preferences updated: " + preferencesList);
    }

    private boolean newsMatchesPreferences(String news) {
        // Check if the news contains any part of the subscriber's preferences
        for (String preference : preferencesList) {
            if (news.toLowerCase().contains(preference.toLowerCase()))
                return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
