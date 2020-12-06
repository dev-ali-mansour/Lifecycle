package dev.alimansour.lifecycle;

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
public class CounterViewModelFactory implements ViewModelProvider.Factory {
    private final String unit;

    public CounterViewModelFactory(String unit) {
        this.unit = unit;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CounterViewModel(unit);
    }
}
