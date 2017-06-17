package ke.co.cryosoft.barazake;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Karim K Kanji on 08/06/2017.
 */
public class CreatePass extends AppCompatActivity {
    TextView passMess;
    String FirstName, LastName, PhoneNumber, confPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpass);
        Intent i = getIntent();
        FirstName = i.getStringExtra("FirstName");
        LastName = i.getStringExtra("LastName");
        PhoneNumber = i.getStringExtra("PhoneNumber");
        passMess = (TextView) findViewById(R.id.messagepass);
        passMess.setText("");

    }

    public void checkPass(View view) {
        String pass;
        EditText password = (EditText) findViewById(R.id.password);
        EditText confirmPassword = (EditText) findViewById(R.id.confirm);
        pass = password.getText().toString().trim();
        confPass = confirmPassword.getText().toString().trim();
        if (pass.length() == 0) {
            passMess = (TextView) findViewById(R.id.messagepass);
            passMess.setText("Please fill in password");
        } else if (confPass.length() == 0) {
            passMess = (TextView) findViewById(R.id.messagepass);
            passMess.setText("Please confirm your password");
        } else {
            if (!pass.equals(confPass)) {
                passMess = (TextView) findViewById(R.id.messagepass);
                passMess.setText("Passwords do not match");
            } else {
                passMess = (TextView) findViewById(R.id.messagepass);
                passMess.setText("");
                Intent i = new Intent(CreatePass.this, CreatingAccount.class);
                i.putExtra("FirstName", FirstName);
                i.putExtra("LastName", LastName);
                i.putExtra("PhoneNumber", PhoneNumber);
                i.putExtra("Password", confPass);
                startActivity(i);
                finish();
            }
        }
    }
}
