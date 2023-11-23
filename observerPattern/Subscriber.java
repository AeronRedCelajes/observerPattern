package observerPattern;
import java.util.*;

// The Observer
public interface Subscriber {
    void update(String news);
    void subscribeToNewsAgency(NewsAgency newsAgency);
    void unsubscribeFromNewsAgency();
    void modifyPreferences(List<String> preferences);
    String getName();
}
