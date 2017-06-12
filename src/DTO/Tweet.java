/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.util.Date;

/**
 *
 * @author Peter
 */
public class Tweet {
    public String UserName;
    public String ScreenName;
    public String UserImage;
    public String Source;
    public int RetweetCount;
    public Date TweetedOn;
    
    public void setUserName(String userName) {
        this.UserName = userName;
    }
    
    public void setScreenName(String screenName) {
        this.ScreenName = screenName;
    }
    
    public void setUserImage(String userImage) {
        this.UserImage = userImage;
    }
    
    public void setSource(String source) {
        this.Source = source;
    }
    
    public void setRetweetCount(int retweetCount) {
        this.RetweetCount = retweetCount;
    }
    
    public void setTweetedOn( Date tweetedOn) {
        this.TweetedOn = tweetedOn;
    }
}