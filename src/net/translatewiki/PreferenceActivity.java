package net.translatewiki;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;

import com.actionbarsherlock.app.SherlockPreferenceActivity;

public class PreferenceActivity extends SherlockPreferenceActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		EditTextPreference languagePreference = (EditTextPreference) findPreference("language");
		final String sLang = PreferenceManager
				.getDefaultSharedPreferences(this).getString("language", "en");
		languagePreference
				.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
					@Override
					public boolean onPreferenceChange(Preference preference, // NOPMD by MANJUPRABHUV on 11/11/12 12:44 PM
							Object lang) {
						final String sNewlang = (String) lang;
						if (sNewlang.equalsIgnoreCase(sLang)) {
							PreferenceActivity.this.finish();
							
						}else{
							Intent intent = new Intent(getApplicationContext(),
									ProofReadActivity.class);
							startActivity(intent);
						}
						return true;
					}
				});

	}

}
