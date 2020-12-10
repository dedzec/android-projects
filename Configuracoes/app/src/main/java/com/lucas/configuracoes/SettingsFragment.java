package com.lucas.configuracoes;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;

public class SettingsFragment extends PreferenceFragment {
    @NonNull
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
