package github.cesarferreira.pretender;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import github.cesarferreira.pretender.interfaces.FakeUsersCallback;
import github.cesarferreira.pretender.models.EncapsulatedUser;
import github.cesarferreira.pretender.models.FakeUser;
import github.cesarferreira.pretender.models.FetchedData;
import github.cesarferreira.pretender.rest.RestClient;
import github.cesarferreira.pretender.utils.Gender;
import github.cesarferreira.pretender.utils.Nationality;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;


public class Pretender {

    private Context mContext;
    private static Pretender mPretender;
    private Nationality mNationality;
    private Gender mGender;
    private int mAmount;
    private String mSeed;

    public static Pretender with(Context context) {
        mPretender = new Pretender(context);
        return mPretender;
    }

    private Pretender(Context context) {
        mContext = context;
    }

    /**
     * Set the nationality
     */
    public Pretender nationality(Nationality nationality) {
        mNationality = nationality;
        return mPretender;
    }

    /**
     * Set the gender
     */
    public Pretender gender(Gender gender) {
        mGender = gender;
        return mPretender;
    }

    /**
     * Amount of pretenders
     *
     * @param amount amount of pretenders
     */
    public Pretender amount(int amount) {
        mAmount = amount;
        return mPretender;
    }

    /**
     * Seeds allow you to always generate the same user (or set of users).
     * For example, the seed "foobar" will always return results for "Mathew Weaver"
     * Seeds can be any string or sequence of characters.
     *
     * @param seed
     */
    public Pretender seed(String seed) {
        mSeed = seed;
        return mPretender;
    }

    public String upperCaseFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public void fetch(final FakeUsersCallback callback) {

        if (mAmount > 100 || mAmount < 1) {
            callback.onError(new Exception("InvalidAmount"));
        }
        new RestClient().getAPI().getUsers(mNationality != null ? mNationality.toString() : null, mSeed, !(mAmount > 0) ? null : mAmount, mGender != null ? mGender.toString() : null)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                    Log.e("some tag", "log error", throwable);
                    callback.onError(throwable);
                })
                .doOnSubscribe(() -> { /* starting request */ })
                .doOnCompleted(() -> { /* finished request */ })
                .onErrorResumeNext(Observable.<FetchedData>empty())
                .subscribe(data -> {

                    List<FakeUser> users = new ArrayList<>();

                    for (EncapsulatedUser encapsulatedUser : data.results) {
                        encapsulatedUser.user.name.title = upperCaseFirstLetter(encapsulatedUser.user.name.title);
                        encapsulatedUser.user.name.first = upperCaseFirstLetter(encapsulatedUser.user.name.first);
                        encapsulatedUser.user.name.last = upperCaseFirstLetter(encapsulatedUser.user.name.last);

                        users.add(encapsulatedUser.user);
                    }

                    callback.onSuccess(users);
                });

    }

}
