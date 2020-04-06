package app.network;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NetworkInterface {

    @GET("/countries/566")
    Call<Object> getCountryCasesInfo();
}
