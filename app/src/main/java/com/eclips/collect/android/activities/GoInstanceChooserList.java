package com.eclips.collect.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.eclips.collect.android.R;

public class GoInstanceChooserList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_instance_chooser_list);
        Intent i = new Intent(getApplicationContext(),InstanceChooserList.class);
        startActivity(i);
    }

}
