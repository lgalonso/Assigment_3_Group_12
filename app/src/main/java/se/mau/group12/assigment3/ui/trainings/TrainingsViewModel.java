package se.mau.group12.assigment3.ui.trainings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrainingsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TrainingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is trainings fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}