package app;

import app.controller.UssdController;
import app.network.NetworkClient;
import app.request.UssdRequest;
import app.utilities.AtomicRun;
import com.africastalking.AfricasTalking;
import com.africastalking.UssdService;

import com.google.auth.oauth2.GoogleCredentials;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;


import java.io.IOException;

import static spark.Spark.*;

public class App {

    DatabaseReference ref;
    AtomicRun atomicRun;
    public static void main(String[] args) throws IOException {


        setUpAfricasTalking();
        setUpGoogleApplicationDefaultCredentials();
        getCountryConvidCases();
        final App app = new App();
        app.ref = FirebaseDatabase.getInstance().getReference("users");
        app.atomicRun = new AtomicRun();
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


            get("/", (request, response) ->  UssdRequest.string());


            post("/", (request, response) -> {

                UssdRequest.setSessionId(request.queryParams(UssdService.FLAG_SESSION_ID));
                UssdRequest.setServiceCode(request.queryParams(UssdService.FLAG_SERVICE_CODE));
                UssdRequest.setPhoneNumber(request.queryParams(UssdService.FLAG_PHONE_NUMBER));
                UssdRequest.setText(request.queryParams(UssdService.FLAG_TEXT));

                saveToFirebase(UssdRequest.getPhoneNumber());

                return UssdController.request();

            });

        }

    }

    private void saveToFirebase(String phoneNumber) {

        atomicRun.setRun(() -> ref.setValue(phoneNumber, (databaseError, databaseReference) -> {

            if (databaseError != null)

                System.out.println("Data could not be saved " + databaseError.getMessage());

            else

                System.out.println("Data saved successfully.");

        }));

    }

    private static void getCountryConvidCases() {

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
