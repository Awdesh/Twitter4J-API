import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.util.List;

/**
 * Class responsible for calling Twitter4J API and performs operations like-:
 * posting a tweet, getTweets from timeline, get favorites.
 * Class will be upgraded with the new api method calls in near future.
 * Created by awdesh on 8/14/15.
 */
public class postTweet
{
        // "**" has been used intentionally in order to hide consumer key and accessTokens.
        static String consumerKeyStr = "**";
        static String consumerSecretStr = "**";
        static String accessTokenStr = "**";
        static String accessTokenSecretStr = "**";

    public static void main(String[] args) {

        try {
            Twitter twitter = new TwitterFactory().getInstance();

            twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
            AccessToken accessToken = new AccessToken(accessTokenStr,
                    accessTokenSecretStr);

            twitter.setOAuthAccessToken(accessToken);

            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" +
                        status.getText());
            }

            System.out.println("**********************************");

            List<Status> messageList =  twitter.getFavorites();
            System.out.println("Retrieving favorites");
            for (Status message : messageList) {
                System.out.println(message.getUser().getName() + ":" +
                        message.getText());
            }

	    twitter.updateStatus("Posting from Twitter4J API");

            System.out.println("Successfully updated the status in Twitter.");
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }
}
