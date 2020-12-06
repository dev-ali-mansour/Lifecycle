package dev.alimansour.lifecycle;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * Lifecycle Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- Lifecycle IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
public class GreetingsViewModel extends AndroidViewModel {
    private String team;

    public GreetingsViewModel(@NonNull Application application, String team) {
        super(application);
        this.team = team;
    }

    public void WelcomeUser(String fullNme) {
        Toast.makeText(getApplication().getApplicationContext(),
                "Welcome back " + fullNme + "\nGreetings from " + team,
                Toast.LENGTH_LONG).show();
    }
}
