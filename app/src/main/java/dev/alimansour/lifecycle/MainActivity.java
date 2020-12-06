package dev.alimansour.lifecycle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private TextView counterTextView;
    private Button button;
    private CounterViewModel counterViewModel;
    private GreetingsViewModel greetingsViewModel;
    private CounterViewModelFactory counterViewModelFactory;
    private GreetingsViewModelFactory greetingsViewModelFactory;
    private SharedPreferences preferences;
    private boolean isPremium;
    private int failedTries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextView);
        button = findViewById(R.id.button);

        preferences = getApplicationContext()
                .getSharedPreferences(getString(R.string.shared_preferences_settings),
                        Context.MODE_PRIVATE);

        counterViewModelFactory = new CounterViewModelFactory("Kilo Gram");
        counterViewModel = new ViewModelProvider(this, counterViewModelFactory)
                .get(CounterViewModel.class);
        greetingsViewModelFactory = new GreetingsViewModelFactory(getApplication(), "YAT Android Team");
        greetingsViewModel = new ViewModelProvider(this, greetingsViewModelFactory).get(GreetingsViewModel.class);

        greetingsViewModel.WelcomeUser("Ahmed Said");
        button.setOnClickListener(v -> {
            counterTextView.setText(String.valueOf(counterViewModel.getCounter()));
        });

        setSettings();

        getSettings();

        if (!isPremium)
            Toast.makeText(this, "You can purchase AdFree premium version", Toast.LENGTH_LONG).show();
        if (failedTries > 3) {
            Toast.makeText(this, "Sorry you have consumed " + failedTries + " tries!", Toast.LENGTH_LONG).show();
        }
    }

    private void getSettings() {
        isPremium = preferences.getBoolean("isPremium", true);
        failedTries = preferences.getInt("failedTries", 0);
    }

    private void setSettings() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isPremium", false);
        editor.putInt("failedTries", 4);
        editor.apply();
    }

}