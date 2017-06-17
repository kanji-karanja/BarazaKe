package ke.co.cryosoft.barazake;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Karim K Kanji on 06/06/2017.
 */
public class RegisterNum extends AppCompatActivity {
    TextView messnum;
    String FirstName;
    String LastName;
    private String phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registernum);
        Intent i = getIntent();
        FirstName = i.getStringExtra("FirstName");
        LastName = i.getStringExtra("LastName");
        messnum = (TextView) findViewById(R.id.messagenum);
        messnum.setText("");
    }

    public void checknum(View view) {
        EditText getphone = (EditText) findViewById(R.id.getphone);
        phone = getphone.getText().toString().trim();
        if (phone.length() == 0) {
            messnum = (TextView) findViewById(R.id.messagenum);
            messnum.setText("Please fill in your number");
        } else {
            if (phone.length() < 10) {
                messnum = (TextView) findViewById(R.id.messagenum);
                messnum.setText("Please input valid phone number");
            } else {
                messnum = (TextView) findViewById(R.id.messagenum);
                messnum.setText("");
                Intent i = new Intent(RegisterNum.this, CreatePass.class);
                i.putExtra("FirstName", FirstName);
                i.putExtra("LastName", LastName);
                i.putExtra("PhoneNumber", phone);
                startActivity(i);
                finish();
            }
        }
    }
}
