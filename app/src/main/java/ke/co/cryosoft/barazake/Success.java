package ke.co.cryosoft.barazake;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Karim K Kanji on 08/06/2017.
 */
public class Success extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Button login = (Button) findViewById(R.id.loginDialog);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Success.this, LogIn.class);
                startActivity(i);
                finish();

            }
        });
    }
}
