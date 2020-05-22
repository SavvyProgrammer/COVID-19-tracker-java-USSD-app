package app.languageResopnses;

import app.controller.SMSController;
import app.models.Country;

import app.utilities.COVIDTest;
import app.utilities.LocalTranslation;
import app.utilities.ResponseFormatter;

import static app.interfaces.MessageInterface.*;
import static app.interfaces.ResponseInterface.*;

public class HausaResponses {

    private static HausaResponses instance;
    private final COVIDTest covidTest = new COVIDTest();


    // required private constructor
    private HausaResponses() {

    }

    // lazy initialization
    public static HausaResponses getInstance() {

        if (instance == null)
            instance = new HausaResponses();

        return instance;
    }

    public String getResponse(String request) {

        String response = "";
        switch (request) {

            case "2":

                response = CON + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(SELECT_AN_OPTION, ISO_HAUSA));
                break;

            case "2*1":

                response = END + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(Country.getCountryInfo(), ISO_HAUSA));
                break;

            case "2*2":

                response = END + " " + LocalTranslation.getTranslate(PROTECT_YOURSELF, ISO_HAUSA);
                SMSController.sms(LocalTranslation.getTranslate(PROTECT_YOURSELF_MESSAGE, ISO_HAUSA));
                break;

            case "2*3":

                response = END + " " + LocalTranslation.getTranslate(SYMPTOMS, ISO_HAUSA);
                SMSController.sms(LocalTranslation.getTranslate(SYMPTOMS_MESSAGE, ISO_HAUSA));
                break;

            case "2*4":
                response = CON + " " + LocalTranslation.getTranslate(TELL_A_FRIEND, ISO_HAUSA);
                break;

        }


        if (request.length() > 2 && request.charAt(2) == '5')
            response = covidTest.takeTest(request, ISO_HAUSA);

        return response;
    }



}
