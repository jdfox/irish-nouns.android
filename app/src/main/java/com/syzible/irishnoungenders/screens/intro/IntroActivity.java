package com.syzible.irishnoungenders.screens.intro;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.syzible.irishnoungenders.MainActivity;
import com.syzible.irishnoungenders.R;
import com.syzible.irishnoungenders.common.persistence.LocalStorage;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(slide1());
        addSlide(slide2());
        addSlide(slide3());
        addSlide(slide4());
        addSlide(slide5());

        setFadeAnimation();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        LocalStorage.setBooleanPref(this, LocalStorage.Pref.FIRST_RUN_COMPLETE, true);
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    private AppIntroFragment slide1() {
        return AppIntroFragment.newInstance(
                "Welcome to " + getString(R.string.app_name),
                R.font.open_sans,
                "Learn noun genders through fun and interesting games",
                R.font.open_sans,
                R.drawable.lightbulb,
                ContextCompat.getColor(this, R.color.lightCarminePink));
    }

    private AppIntroFragment slide2() {
        return AppIntroFragment.newInstance(
                "Multiple mode types",
                R.font.open_sans,
                "Train various areas including gender, declension & plural.",
                R.font.open_sans,
                R.drawable.test,
                ContextCompat.getColor(this, R.color.lapisLazuli));
    }

    private AppIntroFragment slide3() {
        return AppIntroFragment.newInstance(
                "Compete with players",
                R.font.open_sans,
                "Earn a world-wide high score and rise in the ranks.",
                R.font.open_sans,
                R.drawable.medal,
                ContextCompat.getColor(this, R.color.mediumTurquoise));
    }

    private AppIntroFragment slide4() {
        return AppIntroFragment.newInstance(
                "Train your vocab",
                R.font.open_sans,
                "More than 130+ categories and 40,000+ words to expand your vocabulary.",
                R.font.open_sans,
                R.drawable.flask,
                ContextCompat.getColor(this, R.color.lightCarminePink));
    }

    private AppIntroFragment slide5() {
        return AppIntroFragment.newInstance(
                "Ready to start?",
                R.font.open_sans,
                "Begin your journey and widen your knowledge.",
                R.font.open_sans,
                R.drawable.diploma,
                ContextCompat.getColor(this, R.color.jet));
    }
}