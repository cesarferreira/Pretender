package github.cesarferreira.pretender.models;

import com.google.gson.annotations.SerializedName;

public class EncapsulatedUser {

    public EncapsulatedUser() {
    }

    @SerializedName("seed")
    public String seed;

    @SerializedName("user")
    public FakeUser user;

}

