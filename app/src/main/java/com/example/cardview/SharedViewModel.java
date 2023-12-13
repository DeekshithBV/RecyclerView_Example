package com.example.cardview;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {
    private final List<Integer> selectedPositions = new ArrayList<>();

    public List<Integer> getSelectedPositions() {
        return selectedPositions;
    }

    public void addSelectedPosition(int position) {
        selectedPositions.add(position);
    }

    public void removeSelectedPosition(int position) {
        selectedPositions.remove(Integer.valueOf(position));
    }

    public void clearSelectedPositions() {
        selectedPositions.clear();
    }
}

