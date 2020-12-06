package dev.alimansour.lifecycle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Lifecycle Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- Lifecycle IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
public class GreetingsViewModelFactory implements ViewModelProvider.Factory {
    private Application application;
    private String team;

    public GreetingsViewModelFactory(Application application, String team) {
        this.application = application;
        this.team = team;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GreetingsViewModel(application,team);
    }
}
