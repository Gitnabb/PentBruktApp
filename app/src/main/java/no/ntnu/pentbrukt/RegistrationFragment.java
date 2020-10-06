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

import org.w3c.dom.Text;

import java.io.IOException;

import no.ntnu.pentbrukt.Client.RestClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationFragment extends Fragment {

    public TextView alreadyRegistered;

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextRepeatPassword;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        initViews(view);

        Button registerButton = view.findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.register_button:
                        System.out.println("Register button pressed!");
                        registerUser();
                        System.out.println("Register user function went through");
                        break;

                    case R.id.already_registered:
                        break;
                }
            }
        });


        return view;
    }

    public void initViews(View view) {

        editTextFirstName = view.findViewById(R.id.first_name);
        editTextLastName = view.findViewById(R.id.last_name);
        editTextEmail = view.findViewById(R.id.email);
        editTextPassword = view.findViewById(R.id.password);
        editTextRepeatPassword = view.findViewById(R.id.repeat_password);

    }

    private void registerUser() {
        System.out.println("Get in heeeee");
        System.out.println(editTextFirstName.getText().toString());

        String firstname = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String repeatPassword = editTextRepeatPassword.getText().toString().trim();

        if (firstname.isEmpty()) {
            editTextFirstName.setError("Vennligst skriv inn fornavn");
            editTextFirstName.requestFocus();
            return;
        }
        if (lastName.isEmpty()) {
            editTextLastName.setError("Vennligst skriv inn etternavn");
            editTextLastName.requestFocus();
            return;
        }
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

        if (password.length() < 6) {
            editTextPassword.setError("Et passord må ha minst 6 tegn!");
            editTextPassword.requestFocus();
            return;
        }
        if (!repeatPassword.equals(password)) {
            editTextRepeatPassword.setError("Passordene matcher ikke!");
            editTextPassword.requestFocus();
            return;
        }

        // Post request to API
        Call<ResponseBody> call = RestClient
                .getInstance()
                .getRestInterface()
                .registerUser(firstname, lastName, email, password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    String s = response.body().string();
                    Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
