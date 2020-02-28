package gr.academic.city.sdmd.viewmodelandlivedata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends FragmentActivity {

    /**
     * ViewModel way
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvCurrentSum = findViewById(R.id.tv_current_sum);

        Button btnAddOne = findViewById(R.id.btn_add_one);
        Button btnAddTwo = findViewById(R.id.btn_add_two);

        final MainViewModel model = new ViewModelProvider(this).get(MainViewModel.class);
        model.getSum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer newSum) {
                tvCurrentSum.setText(getString(R.string.current_sum_w_placeholder, newSum));
            }
        });

        btnAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.add(1);
            }
        });

        btnAddTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.add(2);
            }
        });
    }


    /**
     * Old way, logic in activity, uncomment to try it out
     */
//    private int sum = 0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        final TextView tvCurrentSum = findViewById(R.id.tv_current_sum);
//
//        Button btnAddOne = findViewById(R.id.btn_add_one);
//        Button btnAddTwo = findViewById(R.id.btn_add_two);
//
//        tvCurrentSum.setText(getString(R.string.current_sum_w_placeholder, sum));
//
//        btnAddOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sum += 1;
//                tvCurrentSum.setText(getString(R.string.current_sum_w_placeholder, sum));
//            }
//        });
//
//        btnAddTwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sum += 2;
//                tvCurrentSum.setText(getString(R.string.current_sum_w_placeholder, sum));
//            }
//        });
//    }
}
