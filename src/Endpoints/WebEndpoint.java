
package Endpoints;
import Business.TimelineLogic;
import javax.jws.WebService;
import javax.jws.WebMethod;

// Ensure this is interpreted as a web service
@WebService
public class WebEndpoint {
    
    // A call to the service poitnting at the getTimeline method will call this
    @WebMethod(action="getTimeline")
    public String getTimeline() {
          // Instantiate our business class
          TimelineLogic t = new TimelineLogic();
          // Call to our business layer to get a JSON encoded string of our tweets
          String returnVal = t.retrieveTimeline();
          return returnVal;
    }
}
