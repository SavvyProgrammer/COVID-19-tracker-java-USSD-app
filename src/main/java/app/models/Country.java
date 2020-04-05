package app.models;

public class Country {

    private static Integer cases;
    private static Integer active;
    private static Integer todayCases;
    private static Integer recovered;
    private static Integer deaths;

    public static Integer getCases() {
        return cases;
    }

    public static void setCases(Integer cases) {
        Country.cases = cases;
    }

    public static Integer getActive() {
        return active;
    }

    public static void setActive(Integer active) {
        Country.active = active;
    }

    public static Integer getTodayCases() {
        return todayCases;
    }

    public static void setTodayCases(Integer todayCases) {
        Country.todayCases = todayCases;
    }

    public static Integer getRecovered() {
        return recovered;
    }

    public static void setRecovered(Integer recovered) {
        Country.recovered = recovered;
    }

    public static Integer getDeaths() {
        return deaths;
    }

    public static void setDeaths(Integer deaths) {
        Country.deaths = deaths;
    }


    public static String getCountryInfo() {

        return "Cases: " + getCases() +
                "/" + "Today Cases: " + getTodayCases() +
                "/" + "Active Cases: " + getActive() +
                "/" + "Recovered: " + getRecovered() +
                "/" + "Deaths: " + getDeaths();
    }
}