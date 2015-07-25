package github.cesarferreira.sample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import github.cesarferreira.pretender.Pretender;
import github.cesarferreira.pretender.interfaces.FakeUsersCallback;
import github.cesarferreira.pretender.models.FakeUser;
import github.cesarferreira.pretender.utils.Gender;
import github.cesarferreira.pretender.utils.Nationality;
import github.cesarferreira.sample.R;
import github.cesarferreira.sample.adapters.UsersAdapter;

public class UsersAdapterFragment extends Fragment {

    @InjectView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    @InjectView(R.id.progress_view_container)
    LinearLayout progressContainer;

    public UsersAdapterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_adapter, container, false);
        ButterKnife.inject(this, view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        fetchData();

        return view;
    }


    private void fetchData() {

        showProgress();

        Pretender.with(getActivity())
                .amount(30)
                .nationality(Nationality.NL)
                .gender(Gender.FEMALE)
                .fetch(new FakeUsersCallback() {
                    @Override
                    public void onSuccess(List<FakeUser> fakeUsers) {
                        hideProgress();
                        fillAdapter(fakeUsers);
                    }

                    @Override
                    public void onError(Throwable exception) {
                        hideProgress();
                        exception.printStackTrace();
                    }
                });
    }

    private void fillAdapter(List<FakeUser> data) {
        RecyclerView.Adapter mAdapter = new UsersAdapter(data, R.layout.layout_users_item);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void hideProgress() {
        progressContainer.setVisibility(View.INVISIBLE);
    }

    private void showProgress() {
        progressContainer.setVisibility(View.VISIBLE);
    }

}
