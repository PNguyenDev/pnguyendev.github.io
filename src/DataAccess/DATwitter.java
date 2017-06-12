package DataAccess;
import DTO.Tweet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.User;

public class DATwitter {
    private static final String USER_TO_READ = "salesforce";
    private static final String ACCESS_KEY = "ynbbgGwdNtetr4ezSghuRBmWz";
    private static final String ACCESS_SECRET = "oIhIPMUOiSAZjv0ffOYDyO0cRjLOGvxfAWMekLFAwcq276oiQZ";
    private static final String TOKEN = "874114561527435265-cG17YwMBBF0hZLdww96Wnk8DJo1hle9";
    private static final String TOKEN_SECRET = "DZCaJ2BKmvMOXzzyWzz9zmEKigRAdSDAbLUpLOfwJ34MY";
    private static final int RETURN_COUNT = 10;
        
    public List<Tweet> getTimeline() {   
        // Initialize the connection to retrieve infomration
        ConfigurationBuilder config = new ConfigurationBuilder();
        config.setOAuthConsumerKey(ACCESS_KEY)
                .setOAuthConsumerSecret(ACCESS_SECRET)
                .setOAuthAccessToken(TOKEN)
                .setOAuthAccessTokenSecret(TOKEN_SECRET);
        TwitterFactory twitterFactory = new TwitterFactory(config.build());
        Twitter twitter = twitterFactory.getInstance();      
        
        // Set up the return object
        List<Tweet> tweets = new ArrayList();
        
        // Time to try and retrieve the timeline retrieval
        try {
            List<Status> statuses = twitter.getUserTimeline(USER_TO_READ,new Paging(1,RETURN_COUNT));
            for(Status status: statuses) {
                Tweet tweet = new Tweet();
                // Parse status information
                tweet.setSource(status.getText());
                tweet.setRetweetCount(status.getRetweetCount());
                
                // Handle DateTime format for initial Tweet Creation
                Calendar tweetedOn = Calendar.getInstance();
                tweetedOn.setTime(status.getCreatedAt());
                tweetedOn.set( Calendar.HOUR_OF_DAY, 0);
                tweetedOn.set( Calendar.MINUTE, 0);
                tweetedOn.set( Calendar.SECOND, 0);
                tweetedOn.set( Calendar.MILLISECOND, 0);
                tweet.setTweetedOn(tweetedOn.getTime());
                
                // Parse user Information
                User user = status.getUser();
                tweet.setScreenName(user.getScreenName());
                tweet.setUserName(user.getName());
                tweet.setUserImage(user.getProfileImageURL());
                
                // Add the tweet to the return list
                tweets.add(tweet);    
            }
            return tweets;
        } catch (Exception ex) {
            // Simple output to console for error logging
            System.out.print("An error was encountered please verify your secret and key. Error" + ex);
            return tweets;
        }
    }
}