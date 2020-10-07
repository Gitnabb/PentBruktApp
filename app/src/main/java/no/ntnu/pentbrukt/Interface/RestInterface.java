package no.ntnu.pentbrukt.Interface;

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

    @POST("users/new-user")
    Call<ResponseBody> registerUser(@Body User user

    );

    public class User{
        String firstname;
        String lastname;
        String username;
        String password;

        public User(String firstname, String lastname, String username, String password) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.username = username;
            this.password = password;
        }
    }

}
