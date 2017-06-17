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
public class RegisterName extends AppCompatActivity {
    TextView mess;
    private String first, last;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regname);
        mess = (TextView) findViewById(R.id.message);
        mess.setText("");
    }

    public void check(View view) {
        EditText fname = (EditText) findViewById(R.id.fname_name);
        EditText lname = (EditText) findViewById(R.id.lname_name);
        first = fname.getText().toString().trim();
        last = lname.getText().toString().trim();

        if (first.length() == 0) {
            mess = (TextView) findViewById(R.id.message);
            mess.setText("Please fill in First Name");
        } else if (last.length() == 0) {
            mess = (TextView) findViewById(R.id.message);
            mess.setText("Please fill in Last Name");
        } else {
            mess = (TextView) findViewById(R.id.message);
            mess.setText("");
            Intent next = new Intent(RegisterName.this, RegisterNum.class);
            next.putExtra("FirstName", first);
            next.putExtra("LastName", last);
            startActivity(next);
            finish();
        }


    }
}
