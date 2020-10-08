package no.ntnu.pentbrukt.Interface;

import no.ntnu.pentbrukt.LoginRequest;
import no.ntnu.pentbrukt.LoginResponse;
import no.ntnu.pentbrukt.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestInterface {

    @POST("api/users/new-user")
    Call<ResponseBody> registerUser(@Body User user);

    //@FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginUser(@Body LoginRequest loginRequest);

    @GET("api/listings/get-all-listings")
    Call<ResponseBody> getAllListings();

}

