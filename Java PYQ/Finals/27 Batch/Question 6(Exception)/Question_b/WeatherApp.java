
// (b) Suppose you are building a weather application that retrieves weather data from different APIs. The APIs can return different exceptions, such as 
//     NetworkException , DataFormatException and UnauthorizedException where

//     DataFormatException and UnauthorizedException, inherit NetworkException.

//     In addition to these exceptions, other exceptions may be generated as well. Write a try-catch block to handle each of these exceptions separately and 
//     provide appropriate error messages. Briefly explain your code.



// Custom exception classes
class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}

class DataFormatException extends NetworkException {
    public DataFormatException(String message) {
        super(message);
    }
}

class UnauthorizedException extends NetworkException {
    public UnauthorizedException(String message) {
        super(message);
    }
}

public class WeatherApp {

    static void fetchWeatherData() throws Exception {
        // Simulated API call that may throw exceptions
        // Simulating a DataFormatException
        // throw new DataFormatException("Invalid data format");

        // Simulating an UnauthorizedException
        // throw new UnauthorizedException("Unauthorized access");

        // Simulating a NetworkException
        // throw new NetworkException("Network issue encountered");

        // Simulating an unexpected exception
        // throw new Exception("An unexpected issue occurred");
    }

    public static void main(String[] args) {
        try {
            fetchWeatherData();
        } catch (DataFormatException e) {
            System.out.println("Error: Received weather data in an incorrect format.");
        } catch (UnauthorizedException e) {
            System.out.println("Error: Unauthorized access. Please check your API key.");
        } catch (NetworkException e) {
            System.out.println("Error: Network issue encountered while fetching weather data.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected issue occurred - " + e.getMessage());
        }
    }

}
