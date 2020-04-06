package app.controller;


import app.languageResopnses.EnglishResponses;
import app.languageResopnses.HausaResponses;
import app.languageResopnses.IgboResponses;
import app.languageResopnses.YorubaResponses;
import app.network.NetworkClient;
import app.interfaces.MessageInterface;
import static app.interfaces.ResponseInterface.*;

public class USSDController {


    public static String request(String request){



        if (request.length() == 3)
            NetworkClient.getInstance().getCountryCovidCases();

        String response = "";

        System.out.println(request);

        char firstIndex = request.length() != 0 ? request.charAt(0) : '\0';



        switch (firstIndex) {

            case '\0':

                response = SELECT_YOUR_PREFERRED_LANGUAGE;
                break;

            case '1':

                response = EnglishResponses.getResponse(request);
                break;

            case '2':

                response = HausaResponses.getResponse(request);
                break;

            case '3':

                response = YorubaResponses.getResponse(request);
                break;

            case '4':

                response = IgboResponses.getResponse(request);
                break;

        }


        if (request.length() == 15 && request.charAt(2) == '4' && request.substring(4, 14).matches("[0-9]+")) {


            if (firstIndex == '1')

                response = MessageInterface.sendMessageToFriend(ISO_ENGLISH);

            if (firstIndex == '2')

                response = MessageInterface.sendMessageToFriend(ISO_HAUSA);

            if (firstIndex == '3')

                response = MessageInterface.sendMessageToFriend(ISO_YORUBA);

            if (firstIndex == '4')

                response = MessageInterface.sendMessageToFriend(ISO_IGBO);
        }

        return response;
    }



}
