package app.languageResopnses;

import app.models.Country;
import app.interfaces.MessageInterface;
import app.interfaces.ResponseInterface;
import app.controller.SmsController;
import app.utilities.COVIDTest;
import app.utilities.ResponseFormatter;


public class EnglishResponses implements ResponseInterface, MessageInterface {



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
                SmsController.sms(PROTECT_YOURSELF_MESSAGE);
                break;

            case "1*3":

                response = END + " " + SYMPTOMS;
                SmsController.sms(SYMPTOMS_MESSAGE);
                break;

            case "1*4":
                response = CON + " " + TELL_A_FRIEND;
                break;

        }

        if (request.length() > 2 && request.charAt(2) == '5')
            response = COVIDTest.getTest(request);

        return response;
    }






}
