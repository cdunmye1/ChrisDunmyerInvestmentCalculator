package westga.edu.chrisdunmyerinvestmentcalculator;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.test.TouchUtils;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testCalculateButtonIsDisabledByDefault() {
        MainActivity activity = getActivity();
        Button calculateButton =
                (Button) activity.findViewById(R.id.calculateButton);
        assertEquals(false, calculateButton.isEnabled());
    }
}
