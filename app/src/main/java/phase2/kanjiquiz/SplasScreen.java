package phase2.kanjiquiz;

import java.util.ArrayList;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.VideoCallbacks;
import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAdAvailabilityListener;
import com.jirbo.adcolony.AdColonyNativeAdListener;
import com.jirbo.adcolony.AdColonyNativeAdMutedListener;
import com.jirbo.adcolony.AdColonyNativeAdView;
import com.lakhzubplb.hthefdfkng226437.AdConfig;
import com.lakhzubplb.hthefdfkng226437.AdConfig.AdType;
import com.simple.dumbatheist.R;
import com.lakhzubplb.hthefdfkng226437.AdListener;
import com.lakhzubplb.hthefdfkng226437.AdView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SplasScreen extends Activity implements OnClickListener, AdColonyAdAvailabilityListener,
		AdColonyNativeAdListener, AdColonyNativeAdMutedListener, AdListener {

	final String APP_ID = "app86dac84aee2740c1a1";
	final String ZONE_ID = "vz14e8c507d36b48fd86";

	// It is recommended to keep a list of native ads, so that you are able to
	// properly destroy
	// them or otherwise modify them as needed.
	ArrayList<AdColonyNativeAdView> native_ad_list = new ArrayList<AdColonyNativeAdView>();

	// Layout that we will be adding our Instant Feed ad into
	LinearLayout native_layout;

	// Used to calculate appropriate native ad width
	float density;
	private AdView adView;
	int i=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AdConfig.setAppId(273105); // setting appid.
		AdConfig.setApiKey("1430463016226302627"); // setting apikey
		setContentView(R.layout.splas_screen);

		i=0;

		String AppoDealappKey = "052d488da6ead7b548643f428542e230e4fd19b147090b04";
		Appodeal.initialize(this, AppoDealappKey);

		showAppoDealAdd();


		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// Get this device's density multiplier
		// density = getResources().getDisplayMetrics().density;

		// Get layout from the layout.xml
		// native_layout = (LinearLayout) findViewById(R.id.native_layout);

		// Configure AdColony and add an ad availability listener

		adView = (AdView) findViewById(R.id.myAdView);

		adView.setBannerType(AdView.BANNER_TYPE_IN_APP_AD);
		adView.setBannerAnimation(AdView.ANIMATION_TYPE_FADE);
		adView.showMRinInApp(false);
		adView.setNewAdListener(this);
		adView.loadAd();

		// AdColony.configure(this, "version:1.0,store:google", APP_ID,
		// ZONE_ID);
		// AdColony.addAdAvailabilityListener(this);

		// setad();

		Utility.mSelectTest = "";
		addListner();
	}


	private void showAppoDealAdd(){

			Appodeal.setVideoCallbacks(new VideoCallbacks() {
			private Toast mToast;

			@Override
			public void onVideoLoaded() {
			//	showToast("onVideoLoaded");
				if(i==0) {
					Appodeal.show(SplasScreen.this, Appodeal.VIDEO);
				}

			}

			@Override
			public void onVideoFailedToLoad() {
			//	showToast("onVideoFailedToLoad");
				i=0;
			}

			@Override
			public void onVideoShown() {
				//showToast("onVideoShown");
				i+=1;
			}

			@Override
			public void onVideoFinished() {
				//showToast("onVideoFinished");
				i+=1;
			}

			@Override
			public void onVideoClosed() {
				//showToast("onVideoClosed");
				i+=1;
			}

			void showToast(final String text) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (mToast == null) {
							mToast = Toast.makeText(SplasScreen.this, text, Toast.LENGTH_SHORT);
						}
						mToast.setText(text);
						mToast.setDuration(Toast.LENGTH_SHORT);
						mToast.show();
					}
				});
			}
		});

	}

	AdListener adListener = new AdListener() {

		@Override
		public void onIntegrationError(String errorMessage) {
			// This will get called when any error has occurred. This will also
			// get called if the SDK notices any integration mistakes.

		}

		@Override
		public void onCloseListener() {
			// This will get called when an ad is closing/resizing from an
			// expanded state.

		}

		@Override
		public void onAdShowing() {
			// This will be called by SDK when it’s showing any of the SmartWall
			// ad.

		}

		@Override
		public void onAdLoadingListener() {
			// This will get called when a rich media ad is loading.

		}

		@Override
		public void onAdLoadedListener() {
			// This will get called when an ad has loaded.

		}

		@Override
		public void onAdExpandedListner() {
			// This will get called when an ad is showing on a user's screen.
			// This may cover the whole UI.

		}

		@Override
		public void onAdError(String errorMessage) {
			// This will get called if any error occurred during ad serving.

		}

		@Override
		public void onAdClosed() {
			// This will be called by SDK when the SmartWall ad is closed.

		}

		@Override
		public void onAdClickedListener() {
			// This will get called when ad is clicked.

		}

		@Override
		public void onAdCached(AdType adType) {
			// This will get called when an ad is cached.

		}

		@Override
		public void noAdListener() {
			// this will get called when ad is not available

		}
	};

	public void addListner() {
		((Button) findViewById(R.id.btnStartGameForSplas)).setOnClickListener(this);
		((Button) findViewById(R.id.btnTopScoresForSplas)).setOnClickListener(this);
		((Button) findViewById(R.id.btnInstructionForSplas)).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnStartGameForSplas:
			Utility.mSelectTest = "PopCulture";
			Intent i = new Intent(SplasScreen.this, OptionSelectScreen.class);
			startActivity(i);
			SplasScreen.this.finish();
			break;
		case R.id.btnTopScoresForSplas:
			Intent ii = new Intent(SplasScreen.this, SelectQuizActivity.class);
			startActivity(ii);
			SplasScreen.this.finish();
			break;
		case R.id.btnInstructionForSplas:

			break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		AdColony.resume(this); // REQUIRED
	}

	@Override
	protected void onPause() {
		super.onPause();
		AdColony.pause(); // REQUIRED
	}

	void addInstantFeedAd(AdColonyNativeAdView native_ad) {

		// Create inner layouts for ad unit
		LinearLayout header_layout = new LinearLayout(this);
		LinearLayout sub_header_layout = new LinearLayout(this);
		header_layout.setOrientation(LinearLayout.HORIZONTAL);
		sub_header_layout.setOrientation(LinearLayout.VERTICAL);
		sub_header_layout.setGravity(Gravity.CENTER_VERTICAL);

		// Create views - retrieve ad specific info
		TextView advertiser_name = new TextView(this);
		TextView sponsored_text = new TextView(this);
		ImageView advertiser_image = native_ad.getAdvertiserImage();
		advertiser_name.setText(native_ad.getAdvertiserName());
		advertiser_name.setTextSize(20);
		advertiser_name.setTextColor(Color.BLACK);
		advertiser_name.setTypeface(Typeface.DEFAULT_BOLD);
		sponsored_text.setText("Sponsored");
		sponsored_text.setTextColor(Color.GRAY);

		// Create and setup layout params
		LinearLayout.LayoutParams advertiser_image_params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams sub_header_params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams advertiser_name_params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

		advertiser_image_params.setMargins(0, 0, (int) (6 * density), (int) (6 * density));
		sub_header_params.setMargins(0, (int) (6 * density), 0, 0);
		advertiser_name_params.setMargins(0, 0, 0, (int) (-6 * density));

		// Attach listeners
		native_ad.withListener(this).withMutedListener(this);

		/*
		 * You can also optionally retrieve the ad title and description for
		 * your use using the following methods:
		 * 
		 * native_ad.getTitle() : String native_ad.getDescription() : String
		 */

		sub_header_layout.addView(advertiser_name, advertiser_name_params);
		sub_header_layout.addView(sponsored_text, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		header_layout.addView(advertiser_image, advertiser_image_params);
		header_layout.addView(sub_header_layout, sub_header_params);
		native_layout.addView(header_layout);
		native_layout.addView(native_ad,
				new LinearLayout.LayoutParams(native_ad.getNativeAdWidth(), native_ad.getNativeAdHeight()));
		native_layout.setVisibility(View.VISIBLE);
	}

	@Override
	public void onAdColonyAdAvailabilityChange(boolean available, String zone_id) {

		if (Looper.myLooper() == null)
			Looper.prepare();
		if (available) {
			// Create native ad object, and add to layout (on UI thread) if one
			// is available
			final AdColonyNativeAdView native_ad = new AdColonyNativeAdView(SplasScreen.this, zone_id,
					(int) (300 * density));
			Log.i("reach", "before" + native_ad.isReady() + native_ad);
			if (native_ad.isReady()) {
				runOnUiThread(new Runnable() {
					public void run() {
						Log.i("reach", "reach");
						addInstantFeedAd(native_ad);
						native_ad_list.add(native_ad);
						Toast.makeText(SplasScreen.this, "Added Instant-Feed ad to the layout.", Toast.LENGTH_SHORT)
								.show();
					}
				});
			}
		}
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

	@Override
	public void onAdColonyNativeAdMuted(AdColonyNativeAdView arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAdColonyNativeAdFinished(boolean expanded, AdColonyNativeAdView native_ad) {
		if (expanded) {
			// We are choosing to remove native ad view from the layout after an
			// expanded ad play finishes.
			// Note that you can choose to remove the ad at any point that you
			// wish -
			// the important thing is to remember to call destroy() whenever you
			// do.

			runOnUiThread(new Runnable() {
				public void run() {
					Toast.makeText(SplasScreen.this, "Removed Instant-Feed ad from the layout.", Toast.LENGTH_SHORT)
							.show();
					native_layout.removeAllViews();
					for (AdColonyNativeAdView native_ad : native_ad_list)
						native_ad.destroy();
					native_ad_list.clear();
				}
			});
		}

	}

	@Override
	public void onAdColonyNativeAdStarted(boolean arg0, AdColonyNativeAdView arg1) {
		// TODO Auto-generated method stub

	}

}
