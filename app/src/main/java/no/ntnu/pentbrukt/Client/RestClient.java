package no.ntnu.pentbrukt.Client;

import no.ntnu.pentbrukt.Interface.RestInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static String BASE_URL = "http://10.22.190.173:8080/api";
    private static RestClient restClientInstance;
    private static Retrofit retrofit;

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    public static synchronized RestClient getInstance() {
        if (restClientInstance == null) {
            restClientInstance = new RestClient();
        }
        return restClientInstance;
    }

    public RestInterface getRestInterface() {
        return retrofit.create(RestInterface.class);
    }
}
