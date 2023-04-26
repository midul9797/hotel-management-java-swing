import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class loginCheck {
    String data;
    int code;
    int passwordCheck(String username, String password){

        try {

            URL url = new URL("https://java-swing-project.vercel.app/users/"+username);

            // Create an HttpURLConnection object to connect to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check if the connection was successful
            code = connection.getResponseCode();

            // Read the data from the input stream of the connection
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


             data = response.toString();
            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            return 500;
        }
    if(data.equals(password))return 200; else return 400;
}
    }
