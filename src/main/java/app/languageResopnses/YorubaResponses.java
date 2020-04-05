package app.languageResopnses;

import app.controller.SmsController;
import app.models.Country;
import app.interfaces.MessageInterface;
import app.interfaces.ResponseInterface;

import app.utilities.COVIDTest;
import app.utilities.LocalTranslation;
import app.utilities.ResponseFormatter;

public class YorubaResponses implements ResponseInterface, MessageInterface {



    public static String getResponse(String request) {

        String response = "";

        switch (request) {

            case "3":

                response = CON + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(SELECT_AN_OPTION, ISO_YORUBA));
                break;

            case "3*1":

                response = END + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(Country.getCountryInfo(), ISO_YORUBA));
                break;

            case "3*2":

                response = END + " " + LocalTranslation.getTranslate(PROTECT_YOURSELF, ISO_YORUBA);
                SmsController.sms(LocalTranslation.getTranslate(PROTECT_YOURSELF_MESSAGE, ISO_YORUBA));
                break;

            case "3*3":

                response = END + " " + LocalTranslation.getTranslate(SYMPTOMS, ISO_YORUBA);
                SmsController.sms(LocalTranslation.getTranslate(SYMPTOMS_MESSAGE, ISO_YORUBA));
                break;

            case "3*4":
                response = CON + " " + LocalTranslation.getTranslate(TELL_A_FRIEND, ISO_YORUBA);
                break;

        }

        if (request.length() > 2 && request.charAt(2) == '5')
            response = COVIDTest.getTest(request, ISO_YORUBA);


        return response;
    }


}
