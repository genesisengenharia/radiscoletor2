package com.eclips.collect.android.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.eclips.collect.android.R;

public class UploadMenuActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_menu_layout);

		ImageButton upload_forms_but = (ImageButton) findViewById(R.id.upload_forms);
		upload_forms_but.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent("com.eclips.collect.android.activities.InstanceUploaderList");
				startActivity(i);
			}
		});

		ImageButton upload_rotas_but = (ImageButton) findViewById(R.id.upload_rotas);
		upload_rotas_but.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent("com.eclips.collect.android.activities.UploadRotasActivity");
				startActivity(i);
			}
		});
    }
}