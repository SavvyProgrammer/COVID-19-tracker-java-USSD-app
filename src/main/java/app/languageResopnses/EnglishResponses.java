package app.languageResopnses;

import app.models.Country;
import app.interfaces.ResponseInterface;
import app.controller.SMSController;
import app.utilities.COVIDTest;
import app.utilities.ResponseFormatter;

import static app.interfaces.MessageInterface.*;


public class EnglishResponses implements ResponseInterface {



    public static String getResponse(String request) {

        String response = "";

        switch (request) {

            case "1":

                response = CON + " " + ResponseFormatter.getFormat(SELECT_AN_OPTION);
                break;

            case "1*1":

                response = END + " " + ResponseFormatter.getFormat(Country.getCountryInfo());
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
            response = COVIDTest.takeTest(request);

        return response;
    }






}
