package no.ntnu.pentbrukt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.already_registered:
                Intent launchLoginActivity = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(launchLoginActivity);
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }
}