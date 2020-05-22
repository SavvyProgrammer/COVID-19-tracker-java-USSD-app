package app.utilities;

public class ResponseFormatter {

    public static String getFormat(String lang, String response)  {

        return lang.equals("en")
                ? String.join("", response.split("\\*"))
                : String.join("\n", response.split("\\*"));


    }

    public static String getFormat(String response)  {

     
        return String.join("\n", response.split("\\*"));


    }
}
