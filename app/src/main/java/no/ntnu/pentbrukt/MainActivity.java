package no.ntnu.pentbrukt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textLogin;
    private EditText email;
    private EditText password;

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                Toast.makeText(this, "Annonse publisert!", Toast.LENGTH_SHORT).show();
                textLogin.setText("Hello " + email.getText().toString());
                //textLogin.setTextColor(Color.WHITE);
                break;
            default:
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.login_button);
        btnLogin.setOnClickListener(this);

        email = findViewById(R.id.email);
        email.setTextColor(Color.WHITE);

        password = findViewById(R.id.password);
        email.setTextColor(Color.WHITE);

    }

}