package gr.academic.city.sdmd.viewmodelandlivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        final MainViewModel model = ViewModelProviders.of(this).get(MainViewModel.class);
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
