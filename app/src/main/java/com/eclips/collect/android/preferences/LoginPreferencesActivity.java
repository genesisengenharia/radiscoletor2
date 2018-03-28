
package com.eclips.collect.android.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.text.InputFilter;
import android.text.Spanned;

import com.eclips.collect.android.R;
import com.eclips.collect.android.logic.FormController;
import com.eclips.collect.android.logic.PropertyManager;


public class LoginPreferencesActivity extends PreferenceActivity implements OnPreferenceChangeListener {

  public static final String KEY_USERNAME = "username";
  public static final String KEY_PASSWORD = "password";

  protected EditTextPreference mUsernamePreference;
  protected EditTextPreference mPasswordPreference;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.login_preferences);

    setTitle(getString(R.string.app_name) + " > " + getString(R.string.login));

    SharedPreferences adminPreferences = getSharedPreferences(
            AdminPreferencesActivity.ADMIN_PREFERENCES, 0);

    mUsernamePreference = (EditTextPreference) findPreference(LoginPreferencesActivity.KEY_USERNAME);
    mPasswordPreference = (EditTextPreference) findPreference(LoginPreferencesActivity.KEY_PASSWORD);


    mUsernamePreference.setOnPreferenceChangeListener(this);
    mUsernamePreference.setSummary(mUsernamePreference.getText());
    mUsernamePreference.getEditText().setFilters(new InputFilter[] { getReturnFilter() });

    mPasswordPreference.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
      @Override
      public boolean onPreferenceChange(Preference preference, Object newValue) {
        String pw = newValue.toString();

        if (pw.length() > 0) {
          mPasswordPreference.setSummary("********");
        } else {
          mPasswordPreference.setSummary("");
        }
        return true;
      }
    });

    if (mPasswordPreference.getText() != null && mPasswordPreference.getText().length() > 0) {
      mPasswordPreference.setSummary("********");
    }
    mPasswordPreference.getEditText().setFilters(new InputFilter[] { getReturnFilter() });



  }

  @Override
  protected void onPause() {
    super.onPause();

    // the property manager should be re-assigned, as properties
    // may have changed.
    PropertyManager mgr = new PropertyManager(this);
    FormController.initializeJavaRosa(mgr);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // has to go in onResume because it may get updated by
    // a sub-preference screen
    // this just keeps the widgets in sync
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

    String user = sp.getString(KEY_USERNAME, "");
    String pw = sp.getString(KEY_PASSWORD, "");
    mUsernamePreference.setSummary(user);
    mUsernamePreference.setText(user);
    if (pw != null && pw.length() > 0) {
      mPasswordPreference.setSummary("********");
      mPasswordPreference.setText(pw);
    }




  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    if (resultCode == RESULT_CANCELED) {
      // request was canceled, so do nothing
      return;
    }


  }


  /**
   * Disallows carriage returns from user entry
   *
   * @return
   */
  protected InputFilter getReturnFilter() {
    InputFilter returnFilter = new InputFilter() {
      public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart,
          int dend) {
        for (int i = start; i < end; i++) {
          if (Character.getType((source.charAt(i))) == Character.CONTROL) {
            return "";
          }
        }
        return null;
      }
    };
    return returnFilter;
  }

  /**
   * Generic listener that sets the summary to the newly selected/entered value
   */
  @Override
  public boolean onPreferenceChange(Preference preference, Object newValue) {
    preference.setSummary((CharSequence) newValue);
    return true;
  }

}
