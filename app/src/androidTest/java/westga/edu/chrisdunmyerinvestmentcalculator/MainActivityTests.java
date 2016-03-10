package westga.edu.chrisdunmyerinvestmentcalculator;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.test.TouchUtils;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testCalculateButtonIsEnabledByDefault() {
        MainActivity activity = getActivity();
        Button calculateButton =
                (Button) activity.findViewById(R.id.calculateButton);
        assertEquals(true, calculateButton.isEnabled());
    }

    public void testResultTextViewShowsErrorWhenPaymentIsEmpty() {
        MainActivity activity = getActivity();
        Button calculateButton =
                (Button) activity.findViewById(R.id.calculateButton);
        TouchUtils.clickView(this, calculateButton);
        TextView resultsTextView =
                (TextView) activity.findViewById(R.id.resultTextView);
        assertEquals("Payment Required!", resultsTextView.getText().toString());
    }

    public void testResultTextViewShowsErrorWhenPaymentIsProvidedButRateIsEmpty() {
        MainActivity activity = getActivity();
        Button calculateButton =
                (Button) activity.findViewById(R.id.calculateButton);

        // type name in text paymentEditText
        final EditText paymentEditText =
                (EditText) activity.findViewById(R.id.paymentEditText);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                paymentEditText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("0");
        TouchUtils.clickView(this, calculateButton);
        TextView resultsTextView =
                (TextView) activity.findViewById(R.id.resultTextView);
        assertEquals("Rate Required!", resultsTextView.getText().toString());
    }

}
