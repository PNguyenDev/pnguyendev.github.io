package Endpoints;
import Business.TimelineLogic;

public class ConsoleEndpoint {
    public static void main(String[] args){  
        // Instantiate our business class
        TimelineLogic t = new TimelineLogic();
        // Call to our business layer to get a JSON encoded string of our tweets
        String returnVal = t.retrieveTimeline();
        System.out.print(returnVal);
    }
}