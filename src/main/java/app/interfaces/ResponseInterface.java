package app.interfaces;

import com.africastalking.UssdService;

public interface ResponseInterface {


    String CON = UssdService.SESSION_CONTINUE;
    String END = UssdService.SESSION_END;

    String ISO_HAUSA = "ha";
    String ISO_IGBO = "ig";
    String ISO_YORUBA = "yo";
    String ISO_ENGLISH = "en";

    String SELECT_YOUR_PREFERRED_LANGUAGE = String.format("%s %s%n%s%n%s%n%s%n%s", CON,
            "Select your preferred language",
            "1. English",
            "2. Hausa",
            "3. Yoruba",
            "4. Igbo");


    String SELECT_AN_OPTION =
            "Select an option"
            + "/" + "1. Latest Numbers"
            + "/" + "2. Protect yourself"
            + "/" + "3. Coronavirus symptoms"
            + "/" + "4. Tell a friend"
            + "/" + "5. COVID-19 symptom test";



    String TELL_A_FRIEND = "Enter your friend's phone number";

    String THANK_YOU = "Thank you";

    String DO_YOU_HAVE_COUGH = "Do you have cough?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String DO_YOU_HAVE_COLDS = "Do you have colds?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String ARE_YOU_HAVING_DIARRHEA = "Are you having Diarrhea?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String DO_YOU_HAVE_SORE_THROAT = "Do you have sore throat?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String ARE_YOU_EXPERIENCING_MYALGIA_OR_BODY_ACHES = "Are you experiencing MYALGIA or Body Aches?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String DO_YOU_HAVE_A_HEADACHE = "Do you have a headache?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String FEVER_TEMPERATURE_37_8_C_AND_ABOVE = "Do you have fever?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String ARE_YOU_HAVING_DIFFICULTY_BREATHING = "Are you having difficulty breathing?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String ARE_YOU_EXPERIENCING_FATIGUE = "Are you experiencing Fatigue?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String TRAVELED_RECENTLY_DURING_THE_PAST_14_DAYS = "Have you traveled recently during the past 14 days?"
            + "/" + "1. NO"
            + "/" + "2. YES";
    String TRAVEL_HISTORY_TO_A_COVID_19_INFECTED_AREA = "Do you have a travel history to a COVID-19 INFECTED AREA?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String TAKING_CARE_OF_A_POSITIVE_COVID_19_PATIENT = "Do you have direct contact or are you taking care of a positive COVID-19 PATIENT?"
            + "/" + "1. NO"
            + "/" + "2. YES";

    String STRESS_RELATED_AND_OBSERVE = "May be stress related and observe";

    String PERSONAL_HYGIENE_OBSERVE_AND_RE_EVALUATE_AFTER_TWO_DAYS = "Hydrate yourself properly and maintain proper personal hygiene. Observe and Re-evaluate after two days";

    String SEEK_A_CONSULTATION_WITH_DOCTOR = "Please, seek a consultation with Doctor";

    String NCDC = "You might have been infected with COVID-19, please call NCDC at 080097000010";


    String[] CHECKLIST = {

            DO_YOU_HAVE_COUGH,
            DO_YOU_HAVE_COLDS,
            ARE_YOU_HAVING_DIARRHEA,
            DO_YOU_HAVE_SORE_THROAT,
            ARE_YOU_EXPERIENCING_MYALGIA_OR_BODY_ACHES,
            DO_YOU_HAVE_A_HEADACHE,
            FEVER_TEMPERATURE_37_8_C_AND_ABOVE,
            ARE_YOU_HAVING_DIFFICULTY_BREATHING,
            ARE_YOU_EXPERIENCING_FATIGUE,
            TRAVELED_RECENTLY_DURING_THE_PAST_14_DAYS,
            TRAVEL_HISTORY_TO_A_COVID_19_INFECTED_AREA,
            TAKING_CARE_OF_A_POSITIVE_COVID_19_PATIENT
    };

    int[] SCORES = {1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3};




}
