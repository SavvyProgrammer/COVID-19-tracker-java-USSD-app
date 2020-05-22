package app.controller;


import app.interfaces.MessageInterface;
import app.languageResopnses.EnglishResponses;
import app.languageResopnses.HausaResponses;
import app.languageResopnses.IgboResponses;
import app.languageResopnses.YorubaResponses;
import app.network.NetworkClient;

import static app.interfaces.ResponseInterface.*;

public class USSDController {

    private static USSDController instance;


    private USSDController(){

    }

    public static USSDController getInstance() {

        if (instance == null)
            instance = new USSDController();
        return instance;
    }

    public String request(String request){

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

                response = EnglishResponses.getInstance().getResponse(request);
                break;

            case '2':

                response = HausaResponses.getInstance().getResponse(request);
                break;

            case '3':

                response = YorubaResponses.getInstance().getResponse(request);
                break;

            case '4':

                response = IgboResponses.getInstance().getResponse(request);
                break;

        }


        if (request.length() == 15 && request.charAt(2) == '4' && request.substring(4, 14).matches("[0-9]+")) {


            if (firstIndex == '1')

                response = MessageInterface.sendMessageToFriend(ISO_ENGLISH, request.substring(5));

            if (firstIndex == '2')

                response = MessageInterface.sendMessageToFriend(ISO_HAUSA, request.substring(5));

            if (firstIndex == '3')

                response = MessageInterface.sendMessageToFriend(ISO_YORUBA, request.substring(5));

            if (firstIndex == '4')

                response = MessageInterface.sendMessageToFriend(ISO_IGBO, request.substring(5));
        }

        return response;
    }



}
