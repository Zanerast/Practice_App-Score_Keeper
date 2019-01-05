package com.example.zane.nightmodepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.security.interfaces.RSAKey;

public class MainActivity extends AppCompatActivity {

	private static final String STATE_SCORE_ONE = "score_one";
	private static final String STATE_SCORE_TWO = "score_two";
	private int scoreOne;
	private int scoreTwo;

	private TextView tvScoreOne;
	private TextView tvScoreTwo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvScoreOne = findViewById(R.id.tv_score_one);
		tvScoreTwo = findViewById(R.id.tv_score_two);

		if (savedInstanceState != null){
			scoreOne = (int) savedInstanceState.get(STATE_SCORE_ONE);
			scoreTwo = (int) savedInstanceState.get(STATE_SCORE_TWO);

			tvScoreOne.setText(String.valueOf(scoreOne));
			tvScoreTwo.setText(String.valueOf(scoreTwo));
		}


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);

		int nightMode = AppCompatDelegate.getDefaultNightMode();

		if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
			menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
		} else {
			menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.night_mode){
			int nightMode = AppCompatDelegate.getDefaultNightMode();

			if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
				AppCompatDelegate.setDefaultNightMode
								(AppCompatDelegate.MODE_NIGHT_NO);
			} else {
				AppCompatDelegate.setDefaultNightMode
								(AppCompatDelegate.MODE_NIGHT_YES);
			}
			recreate();
		}
		return true;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putInt(STATE_SCORE_ONE, scoreOne);
		outState.putInt(STATE_SCORE_TWO, scoreTwo);
		super.onSaveInstanceState(outState);
	}

	public void decreaseScore(View view) {
		int viewID = view.getId();
		switch (viewID){
			case R.id.btn_decrease_team_one:
				scoreOne--;
				tvScoreOne.setText(String.valueOf(scoreOne));
				break;
			case R.id.btn_decrease_team_two:
				scoreTwo--;
				tvScoreTwo.setText(String.valueOf(scoreTwo));
		}
	}

	public void increaseScore(View view) {
		int viewID = view.getId();
		switch (viewID){
			case R.id.btn_increase_team_one:
				scoreOne++;
				tvScoreOne.setText(String.valueOf(scoreOne));
				break;
			case R.id.btn_increase_team_two:
				scoreTwo++;
				tvScoreTwo.setText(String.valueOf(scoreTwo));
		}
	}
}
