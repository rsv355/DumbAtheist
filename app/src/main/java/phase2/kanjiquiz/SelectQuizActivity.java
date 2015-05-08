package phase2.kanjiquiz;

import java.util.HashMap;

import com.lakhzubplb.hthefdfkng226437.AdConfig;
import com.lakhzubplb.hthefdfkng226437.AdConfig.AdType;
import com.phase2.kanjiquiz1.R;
import com.lakhzubplb.hthefdfkng226437.AdListener;
import com.lakhzubplb.hthefdfkng226437.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import phase2.kanjiquiz.database.SqlLiteDbHelper;

public class SelectQuizActivity extends Activity implements OnClickListener, AdListener {

	private SqlLiteDbHelper dbHelper;
	private HashMap<String, String[]> hmHighScore;
	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AdConfig.setAppId(273105); // setting appid.
		AdConfig.setApiKey("1430463016226302627"); // setting apikey
		setContentView(R.layout.manu_ui);

		init();
		bindView();
		addListner();

		adView = (AdView) findViewById(R.id.myAdView);

		adView.setBannerType(AdView.BANNER_TYPE_IN_APP_AD);
		adView.setBannerAnimation(AdView.ANIMATION_TYPE_FADE);
		adView.showMRinInApp(false);
		adView.setNewAdListener(this);
		adView.loadAd();
	}

	private void init() {
		Utility.mSelectTest = "";

		hmHighScore = new HashMap<String, String[]>();
		dbHelper = new SqlLiteDbHelper(this);
		dbHelper.openDataBase();
		hmHighScore = dbHelper.getMathHighScore();
	}

	public String getHighScore(String val, String val2) {
		int valInt = Integer.parseInt(val);
		int valInt2 = Integer.parseInt(val2);

		Log.d("tag", "Val : " + val);
		Log.d("tag", "Val2 : " + val2);
		if (valInt > valInt2) {
			return String.valueOf(valInt);
		} else {
			return String.valueOf(valInt2);
		}
	}

	private void bindView() {
		((TextView) findViewById(R.id.tvMathScoreForMenuUI))
				.setText(getHighScore(hmHighScore.get("PopCulture")[0], hmHighScore.get("Math")[1]) + "/10");
		// ((TextView) findViewById(R.id.tvScienceScoreForMenuUI))
		// .setText(getHighScore(hmHighScore.get("Science")[0],
		// hmHighScore.get("Science")[1])+"/25");
		// ((TextView) findViewById(R.id.tvReligionScoreForMenuUI))
		// .setText(getHighScore(hmHighScore.get("Religion")[0],
		// hmHighScore.get("Religion")[1])+"/25");
		// ((TextView) findViewById(R.id.tvSportScoreForMenuUI))
		// .setText(getHighScore(hmHighScore.get("Sport")[0],
		// hmHighScore.get("Sport")[1])+"/25");
	}

	private void addListner() {
		// findViewById(R.id.rlMathForMenuUI).setOnClickListener(this);
		// findViewById(R.id.rlScienceForMenuUI).setOnClickListener(this);
		// findViewById(R.id.rlSportForMenuUI).setOnClickListener(this);
		// findViewById(R.id.rlReligionForMenuUI).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// switch (v.getId()) {
		// case R.id.rlMathForMenuUI:
		// Utility.mSelectTest = "Math";
		// break;
		// case R.id.rlReligionForMenuUI:
		// Utility.mSelectTest = "Religion";
		// break;
		// case R.id.rlScienceForMenuUI:
		// Utility.mSelectTest = "Science";
		// break;
		// case R.id.rlSportForMenuUI:
		// Utility.mSelectTest = "Sport";
		// break;
		// }

		Intent i = new Intent(SelectQuizActivity.this, OptionSelectScreen.class);
		startActivity(i);
		SelectQuizActivity.this.finish();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(SelectQuizActivity.this, SplasScreen.class);
		startActivity(i);
		SelectQuizActivity.this.finish();
	}

	@Override
	public void noAdListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdCached(AdType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdClickedListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdClosed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdError(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdExpandedListner() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdLoadedListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdLoadingListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdShowing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCloseListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIntegrationError(String arg0) {
		// TODO Auto-generated method stub

	}
}
