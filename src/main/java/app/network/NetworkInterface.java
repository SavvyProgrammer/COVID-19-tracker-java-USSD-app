package app.network;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NetworkInterface {

    @GET("/v2/countries/566")
    Call<Object> getCountryCasesInfo();
}
