package phase2.kanjiquiz;

import com.lakhzubplb.hthefdfkng226437.AdConfig;
import com.lakhzubplb.hthefdfkng226437.AdConfig.AdType;
import com.simple.dumbatheist.R;
import com.lakhzubplb.hthefdfkng226437.AdListener;
import com.lakhzubplb.hthefdfkng226437.AdView;
import com.lakhzubplb.hthefdfkng226437.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class TopicScreen extends Activity implements OnClickListener, AdListener {

	private LinearLayout txtTrivia, txtScience, txtReligion;
	private AdView adView;
	private Main main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AdConfig.setAppId(273105); // setting appid.
		AdConfig.setApiKey("1430463016226302627"); // setting apikey
		setContentView(R.layout.topic_screen);

		txtReligion = (LinearLayout) findViewById(R.id.txtReligion);
		txtScience = (LinearLayout) findViewById(R.id.txtScience);
		txtTrivia = (LinearLayout) findViewById(R.id.txtTrivia);

		txtTrivia.setOnClickListener(this);
		txtReligion.setOnClickListener(this);
		txtScience.setOnClickListener(this);

		adView = (AdView) findViewById(R.id.myAdView);

		adView.setBannerType(AdView.BANNER_TYPE_IN_APP_AD);
		adView.setBannerAnimation(AdView.ANIMATION_TYPE_FADE);
		adView.showMRinInApp(false);
		adView.setNewAdListener(this);
		adView.loadAd();

		main = new Main(this);

		main.start360BannerAd(this);
		main.startInterstitialAd(AdType.smartwall);

	}

//	@Override
//	public void onBackPressed() {
//
////		try {
////			main.showCachedAd(AdType.smartwall); // This will display the ad but
////													// it wont close the app.
////		} catch (Exception e) {
////			// close the activity if ad is not available.
////			finish();
////		}
//		super.onBackPressed();
//	}
	
	@Override
	protected void onDestroy() {

		main.remove360BannerAd(TopicScreen.this);
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.txtTrivia:
			Intent i1 = new Intent(TopicScreen.this, StartQuiz.class);
			i1.putExtra("topic", "PopCulture");
			startActivity(i1);
			TopicScreen.this.finish();
			break;
		case R.id.txtReligion:
			Intent i2 = new Intent(TopicScreen.this, StartQuiz.class);
			i2.putExtra("topic", "Religion");
			startActivity(i2);
			TopicScreen.this.finish();
			break;
		case R.id.txtScience:
			Intent i3 = new Intent(TopicScreen.this, StartQuiz.class);
			i3.putExtra("topic", "Science");
			startActivity(i3);
			TopicScreen.this.finish();
			break;
		}

		/*
		 * Intent i = new Intent(TopicScreen.this, StartQuiz.class);
		 * startActivity(i); TopicScreen.this.finish();
		 */
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
