package phase2.kanjiquiz;

import com.lakhzubplb.hthefdfkng226437.AdConfig;
import com.lakhzubplb.hthefdfkng226437.AdConfig.AdType;
import com.phase2.kanjiquiz1.R;
import com.lakhzubplb.hthefdfkng226437.AdListener;
import com.lakhzubplb.hthefdfkng226437.AdView;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity implements AdListener {

	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AdConfig.setAppId(273105); // setting appid.
		AdConfig.setApiKey("1430463016226302627"); // setting apikey
		setContentView(R.layout.base_activity);

	}

	public void setad() {

		adView = (AdView) findViewById(R.id.myAdView);

		adView.setBannerType(AdView.BANNER_TYPE_IN_APP_AD);
		adView.setBannerAnimation(AdView.ANIMATION_TYPE_FADE);
		adView.showMRinInApp(false);
		adView.setNewAdListener(this);
		adView.loadAd();
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
