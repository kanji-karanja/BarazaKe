package ke.co.cryosoft.barazake;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Karim K Kanji on 08/06/2017.
 */
public class AddIssue extends AppCompatActivity {
    private static final String[] nature = {
            "Select one", "Domestic Violence", "Theft", "Debts", "Livestock", "Resources", "Household",
            "Land", "Child abuse", "Unspecified"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addissue);
        Spinner sp = (Spinner) findViewById(R.id.spinner_nature);
        ArrayAdapter<String> mAdapter = new
                ArrayAdapter<String>(this, R.layout.spinner_entry, nature);
        mAdapter.setDropDownViewResource(R.layout.spinner_entry);
        sp.setAdapter(mAdapter);

        TextView submit = (TextView) findViewById(R.id.submit_issue);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
