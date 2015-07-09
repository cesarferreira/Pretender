package github.cesarferreira.sample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import github.cesarferreira.sample.R;
import github.cesarferreira.sample.fragments.UsersAdapterFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new UsersAdapterFragment())
                    .commit();
        }

    }

}
