/*
 * Copyright (C) 2014 GeoODK
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/**
 * Responsible for displaying buttons to launch the major activities. Launches
 * some activities based on returns of others.
 *
 * @author Jon Nordling (jonnordling@gmail.com)
 */

package com.eclips.collect.android.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.eclips.collect.android.R;
import com.eclips.collect.android.application.Collect;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UpdateMenuActivity extends Activity {
	private static final String t = "GeoODK";
	private static boolean EXIT = true;
	private AlertDialog mAlertDialog;
	private String[] assestFormList;

	
    public static final String FORMS_PATH = Collect.ODK_ROOT + File.separator + "forms";
	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_menu_layout);




		ImageButton update_mapas_but = (ImageButton) findViewById(R.id.update_mapas);
		update_mapas_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*Intent intent = new Intent(UpdateMenuActivity.this, UpdateURLActivity.class);
				Bundle b = new Bundle();
				String arq = "Fase-1_GuarantadoNorte.mbtiles";
				b.putString("arq",arq);
				intent.putExtras(b);
				startActivity(intent);*/

				/*Collect.getInstance().getActivityLogger().logAction(this, "UpdateMapsActivity", "click");*/
				Intent i = new Intent("com.eclips.collect.android.activities.UpdateMapsActivity");
				startActivity(i);
			}
		});


		ImageButton update_apoio_but = (ImageButton) findViewById(R.id.update_apoio);
		update_apoio_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Collect.getInstance().getActivityLogger().logAction(this, "UpdateApoioActivity", "click");
				Intent i = new Intent("com.eclips.collect.android.activities.UpdateApoioActivity");
				startActivity(i);
			}
		});


		ImageButton update_coletor_but = (ImageButton) findViewById(R.id.update_coletor);
		update_coletor_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Collect.getInstance().getActivityLogger().logAction(this, "receive_test", "click");
				//Intent i = new Intent("com.eclips.collect.android.activities.UpdateMapActivity");
				//startActivity(i);
				UpdateApp atualizaApp = new UpdateApp();
				atualizaApp.setContext(getApplicationContext());
				atualizaApp.execute("http://projetoradisunb.com.br/aplicativo/radiscoletor.apk");
				Toast.makeText(getApplicationContext(), "Atualizando RADIS COLETOR\nAguarde a tela de instalação", Toast.LENGTH_LONG).show();

			}
		});


		ImageButton update_bussola_but = (ImageButton) findViewById(R.id.update_bussola);
		update_bussola_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Collect.getInstance().getActivityLogger().logAction(this, "receive_test", "click");
				//Intent i = new Intent("com.eclips.collect.android.activities.UpdateMapActivity");
				//startActivity(i);

				UpdateApp atualizaApp = new UpdateApp();
				atualizaApp.setContext(getApplicationContext());
				atualizaApp.execute("http://projetoradisunb.com.br/aplicativo/gpsstatus.apk");
				Toast.makeText(getApplicationContext(), "Atualizando BÚSSOLA\nAguarde a tela de instalação", Toast.LENGTH_LONG).show();

			}
		});


		ImageButton update_geo_but = (ImageButton) findViewById(R.id.update_geo);
		update_geo_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Collect.getInstance().getActivityLogger().logAction(this, "receive_test", "click");
				//Intent i = new Intent("com.eclips.collect.android.activities.UpdateMapActivity");
				//startActivity(i);
				UpdateApp atualizaApp = new UpdateApp();
				atualizaApp.setContext(getApplicationContext());
				atualizaApp.execute("http://projetoradisunb.com.br/aplicativo/radisgeo.apk");
				Toast.makeText(getApplicationContext(), "Atualizando RADIS GEO\nAguarde a tela de instalação", Toast.LENGTH_LONG).show();

			}
		});


		//End of Main activity
    }



	
	
}
