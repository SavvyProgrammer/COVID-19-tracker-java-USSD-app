package app.network;

import app.models.Country;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.File;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

public class NetworkClient {

    private static final String CORONA_API = "https://corona.lmao.ninja";
    private static final Object LOCK = new Object();
    private static NetworkInterfaceAPI networkInterfaceAPI;
    private static NetworkClient sInstance;


    // Required private constructor
    private NetworkClient() {
    }

    public static NetworkClient getInstance() {
        if (sInstance == null || networkInterfaceAPI == null) {
            synchronized (LOCK) {

                // 5 MB of cache
               Cache cache = new Cache(new File("cache"), 5 * 1024 * 1024);

                // Used for cache connection
                Interceptor networkInterceptor = chain -> {
                    // set max-age and max-stale properties for cache header
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxAge(1, TimeUnit.HOURS)
                            .maxStale(3, TimeUnit.DAYS)
                            .build();
                    return chain.proceed(chain.request())
                            .newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", cacheControl.toString())
                            .build();
                };

                // For logging
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);


                // Building OkHttp client
                OkHttpClient client = new OkHttpClient.Builder()
                        .cache(cache)
                        .addNetworkInterceptor(networkInterceptor)
                        .addInterceptor(loggingInterceptor)
                        .build();

                // Jackson ObjectMapper
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


                // Retrofit Builder
                Retrofit.Builder builder = new Retrofit
                        .Builder()
                        .baseUrl(CORONA_API)
                        .client(client)
                        .addConverterFactory(JacksonConverterFactory.create(mapper));

                networkInterfaceAPI = builder.build().create(NetworkInterfaceAPI.class);
                sInstance = new NetworkClient();
            }
        }
        return sInstance;
    }


    public void getCountryCovidCases() {

        Call<Object> networkCall = networkInterfaceAPI.getCountryCasesInfo();

        networkCall.enqueue(new Callback<Object>() {
            @Override

            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.body() != null) {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) response.body();

                    Country.setCases((Integer) linkedHashMap.get("cases"));
                    Country.setActive((Integer) linkedHashMap.get("active"));
                    Country.setDeaths((Integer) linkedHashMap.get("deaths"));
                    Country.setRecovered((Integer) linkedHashMap.get("recovered"));
                    Country.setTodayCases((Integer) linkedHashMap.get("todayCases"));

                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

        });

    }
}
