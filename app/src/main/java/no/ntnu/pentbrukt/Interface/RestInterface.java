package no.ntnu.pentbrukt.Interface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestInterface {

    @FormUrlEncoded
    @POST("new-user")
    public Call<ResponseBody> registerUser(
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("username") String username,
            @Field("password") String password
    );

}
