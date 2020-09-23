package no.ntnu.pentbrukt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textPublish;
    private EditText editTextName;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPublish:
                Toast.makeText(this, "Annonse publisert!", Toast.LENGTH_SHORT).show();
                textPublish.setText("Hello " + editTextName.getText().toString());
                break;
            default:
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPublish = findViewById(R.id.buttonPublish);
        btnPublish.setOnClickListener(this);

        editTextName = findViewById(R.id.editTextName);
        textPublish = findViewById(R.id.textPublish);

    }

}