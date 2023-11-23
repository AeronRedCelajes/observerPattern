package observerPattern;
import java.util.*;

// The App
public class NewsSubscriptionApp {
    /*
        Aeron Red R. Celajes
        3BSCS-1
        Lab Assignment 8 Observer Pattern
    */
    public static void main(String[] args) {

        while(true){
            System.out.println("///Real-time News Subscription Service///");
            System.out.println();

            NewsAgency newsAgency = new NewsAgency();
            Scanner userInput = new Scanner(System.in);

            // Creating the list of news categories for future enhancements, if more news category will be added
            List<String> newsCategoriesList = Arrays.asList("Natural Disasters", "Technology", "Politics");

            System.out.println("These are the News Categories Given: " + newsCategoriesList);

            // Create subscribers
            Subscriber subscriber1 = new SubscriberNews("User1");
            Subscriber subscriber2 = new SubscriberNews("User2");
            Subscriber subscriber3 = new SubscriberNews("User3");
            List<Subscriber> subscribersList = new ArrayList<>(Arrays.asList(subscriber1, subscriber2, subscriber3));

            // Give subscribers with initial preferences (which is Natural Disasters)
            List<String> preferencesList = List.of("Natural Disasters");
            for (Subscriber subscriber : subscribersList) {
                subscriber.modifyPreferences(preferencesList);
            }

            System.out.println();

            // Subscribe subscribers to the news agency
            for (Subscriber subscriber : subscribersList) {
                subscriber.subscribeToNewsAgency(newsAgency);
            }

            // Publish breaking news
            newsAgency.publishNews("(Natural Disasters) Tsunami in City Alpha!");
            System.out.println();

            // Modify preferences of a subscriber based on user input
            for (Subscriber subscriber : subscribersList) {
                while (true) {
                    System.out.print("Do you want to modify " + subscriber.getName() + "'s preferences? (yes/no): ");
                    String modifyPreferencesInput = userInput.nextLine().toLowerCase();

                    if (modifyPreferencesInput.equals("yes")) {
                        System.out.print("Enter new preferences for " + subscriber.getName() + " (comma-separated): ");
                        preferencesList = Arrays.asList(userInput.nextLine().split(","));
                        subscriber.modifyPreferences(preferencesList);
                        break; // Exit the loop if input is valid
                    } else if (modifyPreferencesInput.equals("no")) {
                        System.out.println(subscriber.getName() + "'s preferences remain unchanged.");
                        break; // Exit the loop if input is valid
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                }
                System.out.println();
            }

            // Unsubscribe subscribers based on user input
            for (Subscriber subscriber : subscribersList) {
                System.out.print("Do you want to unsubscribe " + subscriber.getName() + "? (yes/no): ");
                String unsubscribeInput = userInput.nextLine().toLowerCase();
                if (unsubscribeInput.equals("yes")) {
                    subscriber.unsubscribeFromNewsAgency();
                }
            }
            System.out.println();

            // Publish another breaking news
            newsAgency.publishNews("(Technology) New Smartphone Invented!");
            System.out.println();

            // Subscribe a new subscriber with preferences based on user input
            String subscribeInput;

            while (true) {
                System.out.print("Do you want to subscribe User4? (yes/no): ");
                subscribeInput = userInput.nextLine().toLowerCase();

                if (subscribeInput.equals("yes")) {
                    System.out.print("Enter preferences for User4 (comma-separated): ");
                    preferencesList = Arrays.asList(userInput.nextLine().split(","));
                    Subscriber subscriber4 = new SubscriberNews("User4");
                    subscriber4.modifyPreferences(preferencesList);
                    subscriber4.subscribeToNewsAgency(newsAgency);
                    subscribersList.add(subscriber4);
                    break; // Exit the loop if input is valid
                } else if (subscribeInput.equals("no")) {
                    System.out.println("User4 is not subscribed.");
                    break; // Exit the loop if input is valid
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
            System.out.println();

            // Publish one more breaking news
            newsAgency.publishNews("(Politics) Political Event Starts!");
            System.out.println();

            //questions the user to exit the program or not
            String exit = "";
            boolean validChoice2 = false;
            while (!validChoice2) {
                System.out.print("\nDo you still wish to use the program? 1 = yes, 2 = no: ");
                exit = userInput.nextLine();

                switch (exit){
                    case "1":
                    case "2":
                        validChoice2 = true;
                        System.out.println();
                        break;
                    default:
                        System.out.println("Invalid input choice. Please choose between \"1\" or \"2\".");
                }
            }
            if(exit.equals("2")) {
                System.out.println("Thank you for using the program!");
                System.out.println("Exiting the program...");
                // Close the scanner
                userInput.close();
                System.exit(0);
            }

        }
    }
}
