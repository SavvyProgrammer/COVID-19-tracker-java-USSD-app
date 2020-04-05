package app.controller;

import app.request.UssdRequest;
import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;

import java.util.List;

public class SmsController {


    public static String[] getRecipient(){
        // Recipients
        return new String[]{UssdRequest.getPhoneNumber()};
    }

    public static String getMessage(String message){
        // Message
        return message;
    }

    public static String getShortCode(){
        // Short Code
        return "SavvyDev";
    }


    public static void sms(String message) {


        SmsService smsService = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
        try {

            List<Recipient> response = smsService.send(SmsController.getMessage(message), SmsController.getShortCode(), SmsController.getRecipient(), true);
            if (response != null)
                for (Recipient recipient : response) {
                    System.out.print(recipient.number);
                    System.out.print(" : ");
                    System.out.println(recipient.status);
                }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


}
}
