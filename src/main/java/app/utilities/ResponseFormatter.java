package app.utilities;

public class ResponseFormatter {

    public static String getFormat(String response)  {

        String res= "";
        for (String s : response.split("/")) {
            res = res.concat(s).concat("\n");
        }
        System.out.println(res);
        return res;
    }
}
