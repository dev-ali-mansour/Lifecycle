package dev.alimansour.lifecycle;

import android.widget.TextView;

import androidx.lifecycle.ViewModel;

/**
 * Lifecycle Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- Lifecycle IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
public class CounterViewModel extends ViewModel {
    private int counter = 0;
    private String unit;

    public CounterViewModel(String unit) {
        this.unit = unit;
    }

    public String getCounter() {
        return counter++ + " " + unit;
    }

    // Never do this
    public void setCounter(TextView view) {
        view.setText(String.valueOf(counter++));
    }

}
