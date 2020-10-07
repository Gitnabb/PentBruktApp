package no.ntnu.pentbrukt;

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

import java.io.IOException;

import no.ntnu.pentbrukt.Client.RestClient;
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
                        System.out.println("Register user function went through");
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


    }

}
