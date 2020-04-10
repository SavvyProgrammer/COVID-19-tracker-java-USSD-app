package app;

import app.controller.USSDController;
import app.network.NetworkClient;
import app.request.USSDRequest;
import com.africastalking.AfricasTalking;
import com.africastalking.UssdService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;

import static spark.Spark.*;

public class App {

    DatabaseReference ref;

    public static void main(String[] args) throws IOException {


        setUpAfricasTalking();
        setUpGoogleApplicationDefaultCredentials();
        getCountryCovidCases();
        final App app = new App();
        app.ref = FirebaseDatabase.getInstance().getReference("users");
        app.run();


    }

    private static void setUpGoogleApplicationDefaultCredentials() throws IOException {

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl("https://convid-19-e77b4.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);

    }



    private void run() {



        synchronized (this) {


            get("/", (request, response) -> USSDRequest.string());


            post("/", (request, response) -> {

                USSDRequest.setSessionId(request.queryParams(UssdService.FLAG_SESSION_ID));
                USSDRequest.setServiceCode(request.queryParams(UssdService.FLAG_SERVICE_CODE));
                USSDRequest.setPhoneNumber(request.queryParams(UssdService.FLAG_PHONE_NUMBER));
                USSDRequest.setText(request.queryParams(UssdService.FLAG_TEXT));


                String res = USSDController.request(USSDRequest.getText());

                if (res.substring(0, 3).equals("END"))
                    saveToFirebase(USSDRequest.getPhoneNumber());

                return res;

            });

        }
    }

    private void saveToFirebase(String phoneNumber) {

        ref.child(phoneNumber.substring(4)).setValue(phoneNumber, (databaseError, databaseReference) -> {

            if (databaseError != null)

                System.out.println("Data could not be saved " + databaseError.getMessage());

            else

                System.out.println("Data saved successfully.");

        });

    }

    private static void getCountryCovidCases() {

        NetworkClient.getInstance().getCountryCovidCases();

    }

    private static void setUpAfricasTalking() {

        final String USERNAME = "sandbox";
        final String API_KEY = "2e8091acff04bacb33a3b58d884ae469a91ce7254f471754b73863687620dde4";
        AfricasTalking.initialize(USERNAME, API_KEY);
        port(getHerokuAssignedPort());
    }

    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
