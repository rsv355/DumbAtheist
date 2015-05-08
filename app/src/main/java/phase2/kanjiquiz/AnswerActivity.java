package phase2.kanjiquiz;

import com.appodeal.ads.Appodeal;
import com.lakhzubplb.hthefdfkng226437.AdConfig;
import com.lakhzubplb.hthefdfkng226437.AdConfig.AdType;
import com.phase2.kanjiquiz1.R;
import com.lakhzubplb.hthefdfkng226437.AdListener;
import com.lakhzubplb.hthefdfkng226437.AdView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AnswerActivity extends Activity implements OnClickListener , AdListener{

	private String userAnswer, correctAnswer, optionAnswer;
	private int counter;
	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AdConfig.setAppId(273105); // setting appid.
		AdConfig.setApiKey("1430463016226302627"); // setting apikey
		setContentView(R.layout.answer_screen);
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
		userAnswer = getIntent().getStringExtra("user_ans");
		correctAnswer = getIntent().getStringExtra("correct_ans");
		optionAnswer = getIntent().getStringExtra("option");
		counter = getIntent().getIntExtra("isFinish", 0);
	}

	@SuppressLint("DefaultLocale")
	private void bindView() {
		((TextView) findViewById(R.id.tvCorrectAnswerForAnswerScreen))
				.setText("CORRECT ANSWER" + "\n \n" + correctAnswer.toUpperCase());
		((TextView) findViewById(R.id.tvYourAnswerForAnswerScreen))
				.setText("YOUR ANSWER" + "\n \n" + userAnswer.toUpperCase());

		if (Utility.mOptionAorB == 0) {

			if (!optionAnswer.equals("")) {
				((TextView) findViewById(R.id.tvOptionAnswerForAnswerScreen))
						.setText(("Atheist's ANSWER" + "\n \n" + optionAnswer.toUpperCase()));
			} else {
				((TextView) findViewById(R.id.tvOptionAnswerForAnswerScreen))
						.setText(("Atheist HAVE NOT ATTEMPT THIS QUESTION!"));
			}

		} else {

			if (!optionAnswer.equals("")) {
				((TextView) findViewById(R.id.tvOptionAnswerForAnswerScreen))
						.setText(("Believer's ANSWER" + "\n \n" + optionAnswer.toUpperCase()));
			} else {
				((TextView) findViewById(R.id.tvOptionAnswerForAnswerScreen))
						.setText(("Believer HAVE NOT ATTEMPT THIS QUESTION!"));

			}
		}

	}

	private void addListner() {

		((Button) findViewById(R.id.btnNextQuestionForAnswerScreen)).setOnClickListener(this);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();

		if(counter==4||counter==8){

			String AppoDealappKey = "052d488da6ead7b548643f428542e230e4fd19b147090b04";
			Appodeal.initialize(this, AppoDealappKey);
			Appodeal.show(AnswerActivity.this, Appodeal.INTERSTITIAL);
		}


		if (counter == 10) {
			Intent i = new Intent(AnswerActivity.this, FinishQuizActivity.class);
			startActivity(i);
			AnswerActivity.this.finish();
		} else {
			AnswerActivity.this.finishActivity(111);
		}

	}

	@Override
	public void onClick(View v) {

		Log.d("tag", "OnClick Call");

		if(counter==4||counter==8){

			String AppoDealappKey = "052d488da6ead7b548643f428542e230e4fd19b147090b04";
			Appodeal.initialize(this, AppoDealappKey);
			Appodeal.show(AnswerActivity.this, Appodeal.INTERSTITIAL);
		}


		if (counter == 10) {
			Intent i = new Intent(AnswerActivity.this, FinishQuizActivity.class);
			startActivity(i);
			AnswerActivity.this.finish();
		} else {
			AnswerActivity.this.finish();
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
}
