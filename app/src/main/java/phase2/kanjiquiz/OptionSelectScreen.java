package phase2.kanjiquiz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lakhzubplb.hthefdfkng226437.AdConfig.AdType;
import com.simple.dumbatheist.R;
import com.lakhzubplb.hthefdfkng226437.AdConfig;
import com.lakhzubplb.hthefdfkng226437.AdListener;
import com.lakhzubplb.hthefdfkng226437.AdView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class OptionSelectScreen extends Activity implements OnClickListener, AdListener {

	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AdConfig.setAppId(273105); // setting appid.
		AdConfig.setApiKey("1430463016226302627"); // setting apikey
		setContentView(R.layout.option_screen);
		addListner();
		
		 adView=(AdView) findViewById(R.id.myAdView);

		 adView.setBannerType(AdView.BANNER_TYPE_IN_APP_AD);
		 adView.setBannerAnimation(AdView.ANIMATION_TYPE_FADE);
		 adView.showMRinInApp(false);
		 adView.setNewAdListener(this);
		 adView.loadAd(); 
	}

	@SuppressLint("SimpleDateFormat")
	private void addListner() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date strDate;
		try {
			strDate = sdf.parse("05/06/2015");
			if (new Date().after(strDate)) {
				Log.d("tag", "Liences Expire");
				Toast.makeText(getApplicationContext(), "Expire Application Liences!", Toast.LENGTH_LONG).show();
			} else {
				findViewById(R.id.llAForOptionScreen).setOnClickListener(this);
				findViewById(R.id.llBForOptionScreen).setOnClickListener(this);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.llAForOptionScreen:
			Utility.mOptionAorB = 0;
			break;

		case R.id.llBForOptionScreen:
			Utility.mOptionAorB = 1;
			break;
		}

		Intent i = new Intent(OptionSelectScreen.this, TopicScreen.class);
		startActivity(i);
		OptionSelectScreen.this.finish();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();

		Log.i("reach", "reach");
		Intent i = new Intent(OptionSelectScreen.this, SplasScreen.class);
		startActivity(i);
		OptionSelectScreen.this.finish();
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
