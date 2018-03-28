package com.eclips.collect.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.eclips.collect.android.R;
import com.eclips.collect.android.preferences.LoginPreferencesActivity;

public class LoginActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

		ImageButton dados_usr_but = (ImageButton) findViewById(R.id.dados);
		dados_usr_but.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), LoginPreferencesActivity.class);
				startActivity(i);
			}
		});


		ImageButton login_but = (ImageButton) findViewById(R.id.login);
		login_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), LoginChooser.class);
				startActivity(i);
			}
		});

		ImageButton logout_but = (ImageButton) findViewById(R.id.logout);
		logout_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), LogoutChooser.class);
				startActivity(i);
			}
		});


    }
}