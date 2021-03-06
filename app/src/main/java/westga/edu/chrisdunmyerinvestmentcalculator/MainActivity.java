package westga.edu.chrisdunmyerinvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import westga.edu.chrisdunmyerinvestmentcalculator.model.InvestmentCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void didTapCalculateButton(View view) {
        EditText paymentEditText =
                (EditText) findViewById(R.id.paymentEditText);
        EditText rateEditText =
                (EditText) findViewById(R.id.rateEditText);
        EditText numOfPeriodsEditText =
                (EditText) findViewById(R.id.numOfPeriodsEditText);
        TextView resultTextView =
                (TextView) findViewById(R.id.resultTextView);

        if (paymentEditText.getText().toString().isEmpty()) {
            resultTextView.setText("Payment Required!");
            return;
        }

        if (rateEditText.getText().toString().isEmpty()) {
            resultTextView.setText("Rate Required!");
            return;
        }

        if (numOfPeriodsEditText.getText().toString().isEmpty()) {
            resultTextView.setText("Periods Required!");
            return;
        }

        InvestmentCalculator calculator = new InvestmentCalculator();
        double futureAmount = calculator.getFutureValue(Double.parseDouble(paymentEditText.getText().toString()), Double.parseDouble(rateEditText.getText().toString()), Integer.parseInt(numOfPeriodsEditText.getText().toString()));
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        resultTextView.setText(currency.format(futureAmount));
    }
}
