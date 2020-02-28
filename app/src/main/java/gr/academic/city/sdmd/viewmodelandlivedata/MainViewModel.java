package gr.academic.city.sdmd.viewmodelandlivedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by trumpets on 2/20/18.
 */

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> sum;

    public MainViewModel() {
        this.sum = new MutableLiveData<>();
        this.sum.setValue(0);
    }

    public LiveData<Integer> getSum() {
        return sum;
    }

    public void add(int amountToAdd) {
        this.sum.setValue(this.sum.getValue() + amountToAdd);
    }
}
