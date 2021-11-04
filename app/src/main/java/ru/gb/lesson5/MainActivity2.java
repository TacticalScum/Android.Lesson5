package ru.gb.lesson5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import ru.gb.lesson4.R;

public class MainActivity2 extends AppCompatActivity {
    public static final String PREFERENCES_NAME = "MAIN_ACTIVITY2";
    public static final String THEME_NAME = "THEME_FROM_MAIN_ACTIVITY2";
    Profile profile;
    public int themeCode;
    public static final int lightTheme = 0;
    public static final int darkTheme = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setTheme(loadAppTheme());

        setContentView(R.layout.activity_main2);


        findViewById(R.id.radioButtonLightTheme).setOnClickListener(v -> {
            saveTheme(lightTheme);
            recreate();
        });

        findViewById(R.id.radioButtonDarkTheme).setOnClickListener(v -> {
            saveTheme(darkTheme);
            recreate();
        });

        findViewById(R.id.buttonSave).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);

            profile = new Profile();
            profile.setThemeID(themeCode);
            startActivity(intent);
        });

    }

    private int loadAppTheme() {
         themeCode = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).getInt(THEME_NAME, lightTheme);


        return styleIdCode(themeCode);
    }

    private void saveTheme(int themeCode) {
        getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE).edit().putInt(THEME_NAME, themeCode).apply();
    }

    private int styleIdCode(int codeStyle) {
        if (codeStyle == darkTheme) {
            return R.style.myNightTheme_Lesson4;
        }
        return R.style.MyTheme_Lesson4;
    }

}