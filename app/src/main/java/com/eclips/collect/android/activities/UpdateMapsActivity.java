package com.eclips.collect.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.eclips.collect.android.R;

public class UpdateMapsActivity extends Activity {
		@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_maps_layout);

			ImageButton landsat2008 = (ImageButton) findViewById(R.id.landsat2008);
			landsat2008.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(UpdateMapsActivity.this, UpdateURLActivity.class);
					Bundle b = new Bundle();
					String arq = "Fase-1_Landsat2008.mbtiles";
					b.putString("arq",arq);
					intent.putExtras(b);
					startActivity(intent);
				}
			});


			ImageButton spot = (ImageButton) findViewById(R.id.spot);
			spot.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(UpdateMapsActivity.this, UpdateURLActivity.class);
					Bundle b = new Bundle();
					String arq = "assentamento.mbtiles";
					b.putString("arq",arq);
					intent.putExtras(b);
					startActivity(intent);
				}
			});

			ImageButton rapideye = (ImageButton) findViewById(R.id.rapideye);
			rapideye.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(UpdateMapsActivity.this, UpdateURLActivity.class);
					Bundle b = new Bundle();
					String arq = "Fase-1_RapidEye.mbtiles";
					b.putString("arq",arq);
					intent.putExtras(b);
					startActivity(intent);
				}
			});

			ImageButton mapabasemt = (ImageButton) findViewById(R.id.mapabasemt);
			mapabasemt.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(UpdateMapsActivity.this, UpdateURLActivity.class);
					Bundle b = new Bundle();
					String arq = "MapaBaseMT.mbtiles";
					b.putString("arq",arq);
					intent.putExtras(b);
					startActivity(intent);
				}
			});



    }
}
