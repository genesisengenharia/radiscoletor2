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
import android.content.Intent;
import android.os.Bundle;
import com.eclips.collect.android.R;

public class FormDeleteActivity extends Activity {


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_delete_layout);
        
		Intent i = new Intent(getApplicationContext(),FileManagerTabs.class);
				startActivity(i);

    }

}
