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
        MainActivity activity = this.passPayment(getActivity(), "0");
        //MainActivity activity = getActivity();
        Button calculateButton =
                (Button) activity.findViewById(R.id.calculateButton);
        EditText paymentEditText =
                (EditText) activity.findViewById(R.id.paymentEditText);
        //paymentEditText.setText("0");
        TouchUtils.clickView(this, calculateButton);

        TextView resultsTextView =
                (TextView) activity.findViewById(R.id.resultTextView);
        assertEquals("Rate Required!", resultsTextView.getText().toString());
    }

    public void testResultTextViewShowsErrorWhenPaymentAndRateAreProvidedButNumberOfPeriodsIsEmpty() {
        MainActivity activity = this.passPayment(getActivity(), "0");
        Button calculateButton =
                (Button) activity.findViewById(R.id.calculateButton);
        activity = this.passRate(activity, "0");
        TouchUtils.clickView(this, calculateButton);
        TextView resultsTextView =
                (TextView) activity.findViewById(R.id.resultTextView);
        assertEquals("Periods Required!", resultsTextView.getText().toString());
    }

    public void testResultIsCorrectWhenRegularNumbersArePassed() {
        MainActivity activity = this.passPayment(getActivity(), "1000");
        Button calculateButton =
                (Button) activity.findViewById(R.id.calculateButton);
        activity = this.passRate(activity, "3");
        activity = this.passPeriods(activity, "10");
        TouchUtils.clickView(this, calculateButton);
        TextView resultsTextView =
                (TextView) activity.findViewById(R.id.resultTextView);
        assertEquals("$11,463.88", resultsTextView.getText().toString());
    }

    private MainActivity passPayment(MainActivity activity, final String stringArgument) {
        final EditText paymentEditText =
                (EditText) activity.findViewById(R.id.paymentEditText);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                paymentEditText.setText(stringArgument);
            }
        });
        return activity;
    }

    private MainActivity passRate(MainActivity activity, final String stringArgument) {
        final EditText rateEditText =
                (EditText) activity.findViewById(R.id.rateEditText);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                rateEditText.setText(stringArgument);
            }
        });
        return activity;
    }

    private MainActivity passPeriods(MainActivity activity, final String stringArgument) {
        final EditText numOfPeriodsEditText =
                (EditText) activity.findViewById(R.id.numOfPeriodsEditText);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                numOfPeriodsEditText.setText(stringArgument);
            }
        });
        return activity;
    }
}
