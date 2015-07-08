package github.cesarferreira.pretender.models;


import java.util.List;

public class FakeUser {
    Results results;

    private class Results {
        List<User> user;

        private class User {
            String gender;
            Name name;

            private class Name {
                String title;
                String first;
                String last;
            }
        }
    }
}

