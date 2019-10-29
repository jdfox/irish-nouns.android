package com.syzible.irishnoungenders.screens;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.syzible.irishnoungenders.MainActivity;
import com.syzible.irishnoungenders.R;
import com.syzible.irishnoungenders.screens.modes.gender.GenderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainMenuFragment extends MvpFragment<MainMenuView, MainMenuPresenter> implements MainMenuView {

    private Unbinder unbinder;

    @BindView(R.id.main_menu_gender_mode)
    TextView genderMode;

    @BindView(R.id.main_menu_how_to_play)
    TextView howToPlay;

    @BindView(R.id.main_menu_settings)
    TextView settings;

    public MainMenuFragment() {
    }

    @NonNull
    @Override
    public MainMenuPresenter createPresenter() {
        return new MainMenuPresenter();
    }

    public static MainMenuFragment getInstance() {
        return new MainMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        genderMode.setOnClickListener(v -> MainActivity.setFragment(getFragmentManager(), GenderFragment.getInstance()));

        howToPlay.setOnClickListener(v -> notifyModeUnimplemented());
        settings.setOnClickListener(v -> notifyModeUnimplemented());

        //        settings.setOnClickListener(v -> startActivity(new Intent(getActivity(), SettingsActivity.class)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void notifyModeUnimplemented() {
        Toast.makeText(getContext(), "Mode coming soon!", Toast.LENGTH_LONG).show();
    }
}
