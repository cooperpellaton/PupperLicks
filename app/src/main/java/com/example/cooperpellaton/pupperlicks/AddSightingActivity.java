package com.example.cooperpellaton.pupperlicks;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddSightingActivity extends Activity {

    private EditText editTextUniqueKey, editTextCreatedDate, editTextLocationType,
            editTextIncidentZip, editTextIncidentAddress, editTextCity, editTextBorough,
            editTextLatitude, editTextLongitude;

    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sighting);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // set up textedits
        editTextUniqueKey = (EditText) findViewById(R.id.editTextUniqueKey);
        editTextCreatedDate = (EditText) findViewById(R.id.editTextCreatedDate);
        editTextLocationType = (EditText) findViewById(R.id.editTextLocationType);
        editTextIncidentZip = (EditText) findViewById(R.id.editTextIncidentZip);
        editTextIncidentAddress = (EditText) findViewById(R.id.editTextIncidentAddress);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        editTextBorough = (EditText) findViewById(R.id.editTextBorough);
        editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
        editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);

        // set up button
        btnSave = (Button) findViewById(R.id.button2);

        btnSave.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                ServerPortal sp = new ServerPortal();
                // build rat sighting object and send server add request
                sp.addReport(new RatSighting(
                        editTextUniqueKey.getText().toString(),
                        editTextCreatedDate.getText().toString(),
                        editTextLocationType.getText().toString(),
                        editTextIncidentZip.getText().toString(),
                        editTextIncidentAddress.getText().toString(),
                        editTextCity.getText().toString(),
                        editTextBorough.getText().toString(),
                        editTextLatitude.getText().toString(),
                        editTextLongitude.getText().toString()));
            }
        });
    }

}
