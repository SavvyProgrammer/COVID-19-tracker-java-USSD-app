package app.languageResopnses;

import app.models.Country;
import app.controller.SMSController;
import app.utilities.COVIDTest;
import app.utilities.ResponseFormatter;

import static app.interfaces.MessageInterface.*;
import static app.interfaces.ResponseInterface.*;


public class EnglishResponses {


    private static EnglishResponses instance;
    private final COVIDTest covidTest = new COVIDTest();

    // required private constructor
    public EnglishResponses() {

    }

    public static EnglishResponses getInstance() {
        if(instance == null) {
            instance = new EnglishResponses();
        }
        return instance;
    }



    public String getResponse(String request) {

        String response = "";

        switch (request) {

            case "1":

                response = CON + " " + ResponseFormatter.getFormat("en", SELECT_AN_OPTION);
                break;

            case "1*1":

                response = END + " " + ResponseFormatter.getFormat("en", Country.getCountryInfo());
                break;

            case "1*2":

                response = END + " " + PROTECT_YOURSELF;
                SMSController.sms(PROTECT_YOURSELF_MESSAGE);
                break;

            case "1*3":

                response = END + " " + SYMPTOMS;
                SMSController.sms(SYMPTOMS_MESSAGE);
                break;

            case "1*4":
                response = CON + " " + TELL_A_FRIEND;
                break;

        }

        if (request.length() > 2 && request.charAt(2) == '5')
            response = covidTest.takeTest(request);

        return response;
    }






}
