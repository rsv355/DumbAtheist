package phase2.kanjiquiz;

import com.lakhzubplb.hthefdfkng226437.AdConfig;
import com.lakhzubplb.hthefdfkng226437.AdConfig.AdType;
import com.simple.dumbatheist.R;
import com.lakhzubplb.hthefdfkng226437.AdListener;
import com.lakhzubplb.hthefdfkng226437.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import phase2.kanjiquiz.database.SqlLiteDbHelper;

public class FinishQuizActivity extends Activity implements AdListener {

	private SqlLiteDbHelper dbHelper;
	private String[] highScoreArray = new String[2];
	private Main main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AdConfig.setAppId(273105); // setting appid.
		AdConfig.setApiKey("1430463016226302627"); // setting apikey
		AdConfig.setAdListener(this); // setting global Ad listener.
		AdConfig.setCachingEnabled(true); // Enabling SmartWall ad caching.
		AdConfig.setPlacementId(0); // pass the placement id.
		setContentView(R.layout.finish_quize);
		init();
		bindView();

		main = new Main(this);

		main.start360BannerAd(this);
		main.startInterstitialAd(AdType.smartwall);
	}

	private void init() {
		dbHelper = new SqlLiteDbHelper(this);
		dbHelper.openDataBase();
		highScoreArray = dbHelper.getSingleTestHighScore(Utility.mSelectTest.trim());
	}

	private void bindView() {
		if (Utility.mOptionAorB == 0) {
			((TextView) findViewById(R.id.tvScoreForFinishQuize)).setText("Believer Score : " + highScoreArray[0]);
			((TextView) findViewById(R.id.tvOppnentScoreForFinishQuize))
					.setText("Atheist Score : " + highScoreArray[1]);

			if (Integer.parseInt(highScoreArray[0]) >= Integer.parseInt(highScoreArray[1])) {
				((TextView) findViewById(R.id.tvMsgForFinishQuize)).setText("You are");
				((TextView) findViewById(R.id.tvMsg2ForFinishQuize)).setText("smarter than");
				((TextView) findViewById(R.id.tvMsg3ForFinishQuize)).setText("Atheist");
			} else {
				((TextView) findViewById(R.id.tvMsgForFinishQuize)).setText("You are");
				((TextView) findViewById(R.id.tvMsg2ForFinishQuize)).setText("dumber than");
				((TextView) findViewById(R.id.tvMsg3ForFinishQuize)).setText("Atheist");
			}
		} else {
			((TextView) findViewById(R.id.tvScoreForFinishQuize)).setText("Atheist Score : " + highScoreArray[1]);
			((TextView) findViewById(R.id.tvOppnentScoreForFinishQuize))
					.setText("Believer Score : " + highScoreArray[0]);

			if (Integer.parseInt(highScoreArray[1]) >= Integer.parseInt(highScoreArray[0])) {
				((TextView) findViewById(R.id.tvMsgForFinishQuize)).setText("You are");
				((TextView) findViewById(R.id.tvMsg2ForFinishQuize)).setText("smarter than");
				((TextView) findViewById(R.id.tvMsg3ForFinishQuize)).setText("Believer");
			} else {
				((TextView) findViewById(R.id.tvMsgForFinishQuize)).setText("You are");
				((TextView) findViewById(R.id.tvMsg2ForFinishQuize)).setText("dumber than");
				((TextView) findViewById(R.id.tvMsg3ForFinishQuize)).setText("Believer");
			}
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		// try {
		// main.showCachedAd(AdType.smartwall); // This will display the ad but
		// // it wont close the app.
		// } catch (Exception e) {
		// // close the activity if ad is not available.
		// finish();
		// }

		Intent i = new Intent(FinishQuizActivity.this, SplasScreen.class);
		startActivity(i);
		FinishQuizActivity.this.finish();
	}

	@Override
	protected void onDestroy() {

		main.remove360BannerAd(FinishQuizActivity.this);
		super.onDestroy();
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
