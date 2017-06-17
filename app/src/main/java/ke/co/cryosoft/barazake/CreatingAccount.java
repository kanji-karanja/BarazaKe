package ke.co.cryosoft.barazake;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Karim K Kanji on 15/06/2017.
 */
public class CreatingAccount extends AppCompatActivity {
    Timer t;
    String FirstName, LastName, PhoneNumber, Password;
    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creating_account);
        Intent i = getIntent();
        FirstName = i.getStringExtra("FirstName");
        LastName = i.getStringExtra("LastName");
        PhoneNumber = i.getStringExtra("PhoneNumber");
        Password = i.getStringExtra("Password");

        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(CreatingAccount.this, Success.class);
                startActivity(i);
                finish();
                t.cancel();
            }
        }, 10000, 10000);
        db = openOrCreateDatabase("user", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS login(FirstName VARCHAR, LastName VARCHAR, PhoneNumber VARCHAR, Password VARCHAR);");
        db.execSQL("INSERT INTO login VALUES('" + FirstName + "','" + LastName + "','" + PhoneNumber + "','" + Password + "');");
    }
}
