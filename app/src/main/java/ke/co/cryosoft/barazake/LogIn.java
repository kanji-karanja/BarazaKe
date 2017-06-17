package ke.co.cryosoft.barazake;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Karim K Kanji on 01/06/2017.
 */
public class LogIn extends AppCompatActivity {
    SQLiteDatabase db;
    String phone, password;
    String FirstName, LastName, PhoneNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void logging(View view) {
        EditText phoneget = (EditText) findViewById(R.id.editText);
        EditText passwordget = (EditText) findViewById(R.id.editText2);
        phone = phoneget.getText().toString().trim();
        password = passwordget.getText().toString().trim();
        db = openOrCreateDatabase("user", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM login WHERE PhoneNumber='" + phone + "' AND Password='" + password + "'", null);
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                FirstName = c.getString(0);
                LastName = c.getString(1);
                PhoneNumber = c.getString(2);
            }
            Intent i = new Intent(LogIn.this, Home.class);
            i.putExtra("FirstName", FirstName);
            i.putExtra("LastName", LastName);
            i.putExtra("PhoneNumber", PhoneNumber);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(LogIn.this, "Sorry no such username or password exists", Toast.LENGTH_SHORT).show();
        }
    }
}
