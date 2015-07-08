package github.cesarferreira.pretender.interfaces;

import java.util.List;

import github.cesarferreira.pretender.models.FakeUser;

/**
 * Created by cesarferreira on 08/07/15.
 */
public interface FakeUsersCallback {
    void onSuccess(List<FakeUser> fakeUsers);
    void onError();
}
