/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import DataAccess.DATwitter;
import DTO.Tweet;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Peter
 */
public class TimelineLogic {
    public String retrieveTimeline()
    {
        // Instantiate the data access class
        DATwitter conn = new DATwitter();
        // Retrieve the tweets
        List<Tweet> timeline = conn.getTimeline();
        // If the return had something we want to JSON encode it
        if(timeline.size() > 0) {
            JSONObject obj = new JSONObject(timeline);
            return obj.toString();
        }
        // Return an empty string if we got nothing
        return "";
    }    
}
