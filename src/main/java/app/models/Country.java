package app.models;

import java.util.LinkedHashMap;

public class Country {

    private static Integer cases;
    private static Integer active;
    private static Integer todayCases;
    private static Integer recovered;
    private static Integer deaths;

    public static Integer getCases() {
        return cases;
    }

    static void setCases(Integer cases) {
        Country.cases = cases;
    }

    public static Integer getActive() {
        return active;
    }

    static void setActive(Integer active) {
        Country.active = active;
    }

    public static Integer getTodayCases() {
        return todayCases;
    }

    static void setTodayCases(Integer todayCases) {
        Country.todayCases = todayCases;
    }

    public static Integer getRecovered() {
        return recovered;
    }

    static void setRecovered(Integer recovered) {
        Country.recovered = recovered;
    }

    public static Integer getDeaths() {
        return deaths;
    }

    static void setDeaths(Integer deaths) {
        Country.deaths = deaths;
    }

    public static void getResponseBody(LinkedHashMap<String, Object> response) {


        Country.setCases((Integer) response.get("cases"));
        Country.setActive((Integer) response.get("active"));
        Country.setDeaths((Integer) response.get("deaths"));
        Country.setRecovered((Integer) response.get("recovered"));
        Country.setTodayCases((Integer) response.get("todayCases"));
    }

    public static String getCountryInfo() {

        return "Cases: " + getCases() +
                "/" + "Today Cases: " + getTodayCases() +
                "/" + "Active Cases: " + getActive() +
                "/" + "Recovered: " + getRecovered() +
                "/" + "Deaths: " + getDeaths();
    }
}