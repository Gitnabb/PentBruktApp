package no.ntnu.pentbrukt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    private EditText email, password;

    @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login_button:
                    Toast.makeText(this, "Logget inn!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.not_registered_newuser:
                    Intent launchRegisterActivity = new Intent(MainActivity.this, RegistrationActivity.class);
                    startActivity(launchRegisterActivity);
            }
}

    private void setupUIViews() {

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.login_button);
        TextView notRegistered = (TextView) findViewById(R.id.not_registered_newuser);
        TextView alreadyRegistered = (TextView) findViewById(R.id.already_registered);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validated()) {
                    // Run login request to database
                }
            }
        });

    }

    private boolean validated() {

        boolean dataEntered = false;

        String emailEntered = email.getText().toString();
        String passwordEntered = password.getText().toString();

        if (emailEntered.isEmpty() && passwordEntered.isEmpty()) {
            Toast.makeText(this, "Vennligst skriv inn både email og passord", Toast.LENGTH_SHORT).show();
        } else {
            dataEntered = true;
        }
        return dataEntered;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();


    }

}