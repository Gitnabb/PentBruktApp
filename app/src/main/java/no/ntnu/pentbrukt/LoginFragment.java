package no.ntnu.pentbrukt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.IOException;

import no.ntnu.pentbrukt.Client.RestClient;
import no.ntnu.pentbrukt.Interface.RestInterface;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    public TextView not_registered;

    private EditText editTextEmail;
    private EditText editTextPassword;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initViews(view);

        Button loginButton = view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.login_button:
                        System.out.println("Login button pressed!");
                        loginUser();
                        System.out.println("Login went out!");
                        break;

                    case R.id.not_registered:
                        System.out.println("not registered button pressed");
                        break;
                }
            }
        });


        return view;
    }

    public void initViews(View view) {

        editTextEmail = view.findViewById(R.id.email);
        editTextPassword = view.findViewById(R.id.password);

    }

    private void loginUser() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        final UserPrefData userPrefData = new UserPrefData(getContext());

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(email);
        loginRequest.setPassword(password);

        // DEBUG TODO: DELETE THIS FOR GODS SAKE
        System.out.println(editTextEmail.getText().toString());
        System.out.println(editTextPassword.getText().toString());

        if (email.isEmpty()) {
            editTextEmail.setError("Vennligst skriv inn email");
            editTextEmail.requestFocus();
            return;
        }

        // Check email validity
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Ikke gyldig email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextEmail.setError("Vennligst skriv inn ønsket passord");
            editTextEmail.requestFocus();
            return;
        }

        // Post request to API
        Call<ResponseBody> call = RestClient
                .getInstance()
                .getRestInterface()
                .loginUser(loginRequest);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                System.out.println("onResponse called!");
                Activity activity = getActivity();
                Fragment fragment = new ListingsFragment();

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                if (response.isSuccessful()) {

                    String token;
                    if (response.headers().get("Authorization") != null
                            && response.headers().get("Authorization").length() > 0) {
                        token = response.headers().get("Authorization").split("Bearer ")[1];

                        userPrefData.setToken(token);
                        getActivity().recreate();

                        System.out.println("TOKEN FROM SERVER: " + token);
                        System.out.println("IS TOKEN SAVED TO PREFDATA??: " + userPrefData.getToken());
                        Toast.makeText(activity, "Logget inn!", Toast.LENGTH_SHORT).show();

                        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();

                        /*Intent i = new Intent(getContext(), ListingActivity.class);
                        startActivity(i);*/
                    }
                } else if (response.code() == 403) {
                    String errorMessage = "Brukernavn eller passord er feil!";
                    Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Somethings up! Error boy", Toast.LENGTH_SHORT).show();
                    System.out.println("Somethings up! Error boy");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "on failure", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
