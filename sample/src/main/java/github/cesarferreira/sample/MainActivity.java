package github.cesarferreira.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import github.cesarferreira.pretender.Pretender;
import github.cesarferreira.pretender.interfaces.FakeUsersCallback;
import github.cesarferreira.pretender.models.FakeUser;
import github.cesarferreira.pretender.utils.Gender;
import github.cesarferreira.pretender.utils.Nationality;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();

        Pretender.with(context)
                .nactionality(Nationality.US)
                .gender(Gender.MALE)
                .amount(10)
                .seed("cena")
                .callback(new FakeUsersCallback() {
                    @Override
                    public void onSuccess(List<FakeUser> fakeUsers) {

                    }

                    @Override
                    public void onError() {

                    }
                })
        ;
    }

}
