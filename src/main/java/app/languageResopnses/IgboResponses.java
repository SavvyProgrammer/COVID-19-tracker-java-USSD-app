package app.languageResopnses;

import app.controller.SMSController;
import app.models.Country;

import app.utilities.COVIDTest;
import app.utilities.LocalTranslation;
import app.utilities.ResponseFormatter;

import static app.interfaces.MessageInterface.*;
import static app.interfaces.ResponseInterface.*;


public class IgboResponses {


    private static IgboResponses instance;
    private final COVIDTest covidTest = new COVIDTest();

    // required private constructor
    private IgboResponses() {

    }

    // lazy initialization
    public static IgboResponses getInstance() {
        if(instance == null){
            instance = new IgboResponses();
        }
        return instance;
    }



    public String getResponse(String request) {


        String response = "";

        switch (request) {

            case "4":

                response = CON + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(SELECT_AN_OPTION, ISO_IGBO));
                break;

            case "4*1":

                response = END + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(Country.getCountryInfo(), ISO_IGBO));
                break;

            case "4*2":

                response = END + " " + LocalTranslation.getTranslate(PROTECT_YOURSELF, ISO_IGBO);
                SMSController.sms(LocalTranslation.getTranslate(PROTECT_YOURSELF_MESSAGE, ISO_IGBO));
                break;

            case "4*3":

                response = END + " " + LocalTranslation.getTranslate(SYMPTOMS, ISO_IGBO);
                SMSController.sms(LocalTranslation.getTranslate(SYMPTOMS_MESSAGE, ISO_IGBO));
                break;

            case "4*4":
                response = CON + " " + LocalTranslation.getTranslate(TELL_A_FRIEND, ISO_IGBO);
                break;

        }

        if (request.length() > 2 && request.charAt(2) == '5')
            response = covidTest.takeTest(request, ISO_IGBO);

        return response;
    }


}
