package app.utilities;

import static app.interfaces.ResponseInterface.*;



public class COVIDTest {

    private static int counter;
    private static int score;

    private static void calculateScore(char lastIndex) {


        if (lastIndex == '2' || lastIndex == '5' )
            score += SCORES[counter];

        System.out.printf("counter: %d, score: %d, lastIndex: %c%n", counter, score, lastIndex);

    }

    private static String getTestScore() {

        if (score <= 2)
            return "1";

        else if (score <= 5)
            return "2";

        else if (score <= 12)
            return "3";

        else
            return "4";

    }

    private static void init(String result) {

        if (result.matches("[1-4]")) {
            score = 0;
            counter = 0;
        }

    }

    public static String getResponse(char index) {


        if (counter == 12)

            return getTestScore();

        calculateScore(index);

        return QUESTIONS[counter++];

    }

    public static String takeTest(String request) {

        String result = getResponse(request.charAt(request.length() - 1));

        init(result);

        switch (result) {
            case "1":
                return END + " " + STRESS_RELATED_AND_OBSERVE;

            case "2":
                return END + " " + PERSONAL_HYGIENE_OBSERVE_AND_RE_EVALUATE_AFTER_TWO_DAYS;

            case "3":
                return END + " " + SEEK_A_CONSULTATION_WITH_DOCTOR;

            case "4":
                return END + " " + NCDC;

            default:
                return CON + " " + ResponseFormatter.getFormat(result);

        }


    }



    public static String takeTest(String request, String isoLang) {



        String result = getResponse(request.charAt(request.length() - 1));

        init(result);

        switch (result) {
            case "1":
                return END + " " + LocalTranslation.getTranslate(STRESS_RELATED_AND_OBSERVE, isoLang);

            case "2":
                return END + " " + LocalTranslation.getTranslate(PERSONAL_HYGIENE_OBSERVE_AND_RE_EVALUATE_AFTER_TWO_DAYS, isoLang);

            case "3":
                return END + " " + LocalTranslation.getTranslate(SEEK_A_CONSULTATION_WITH_DOCTOR, isoLang);

            case "4":
                return END + " " + LocalTranslation.getTranslate(NCDC, isoLang);

            default:
                return CON + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(result, isoLang));

        }


    }

}
