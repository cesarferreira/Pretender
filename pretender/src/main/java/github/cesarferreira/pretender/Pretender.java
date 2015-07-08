package github.cesarferreira.pretender;

import android.content.Context;

import github.cesarferreira.pretender.interfaces.FakeUsersCallback;
import github.cesarferreira.pretender.utils.Gender;
import github.cesarferreira.pretender.utils.Nationality;


public class Pretender {

    private final String baseURL = "http://api.randomuser.me/0.6/";

    private Context mContext;
    private static Pretender mPretender;

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
    public Pretender nactionality(Nationality nationality) {
        return null;
    }

    /**
     * Set the gender
     */
    public Pretender gender(Gender gender) {
        return null;
    }

    /**
     * Amount of pretenders
     *
     * @param amount amount of pretenders
     */
    public Pretender amount(int amount) {
        return null;
    }

    /**
     * Seeds allow you to always generate the same user (or set of users).
     * For example, the seed "foobar" will always return results for "Mathew Weaver"
     * Seeds can be any string or sequence of characters.
     *
     * @param seed
     */
    public Pretender seed(String seed) {
        return null;
    }

    public void callback(FakeUsersCallback callback) {
        // todo: do shit and
        callback.onSuccess(null);
    }
}
