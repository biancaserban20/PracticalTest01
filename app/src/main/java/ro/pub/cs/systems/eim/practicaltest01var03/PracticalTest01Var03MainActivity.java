package ro.pub.cs.systems.eim.practicaltest01var03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private Button navigateToSecondaryActivityButton;
    private Button plusButton;
    private Button minusButton;

    private EditText firstNo;
    private EditText secondNo;
    private TextView resultEditText;

    private PlusButtonClickListener plusButtonClickListener = new PlusButtonClickListener();
    private class PlusButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
//            int first = Integer.parseInt(firstNo.getText().toString());
//            int second = Integer.parseInt(secondNo.getText().toString());
//            // if first and second are not integers, we will use toast to display a message
//
//            int result = first + second;
//            resultEditText.setText(first + " + " + second + " = " + result);
            try {
                int first = Integer.parseInt(firstNo.getText().toString());
                int second = Integer.parseInt(secondNo.getText().toString());

                int result = first + second;
                resultEditText.setText(first + " + " + second + " = " + result);
            } catch (NumberFormatException e) {
                // Display a toast message if firstNo or secondNo are not integers
                Toast.makeText(PracticalTest01Var03MainActivity.this, "Please enter valid integers", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private MinusButtonClickListener minusButtonClickListener = new MinusButtonClickListener();
    private class MinusButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int first = Integer.parseInt(firstNo.getText().toString());
            int second = Integer.parseInt(secondNo.getText().toString());
            int result = first - second;
            resultEditText.setText(first + " - " + second + " = " + result);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);
        firstNo = (EditText)findViewById(R.id.firstNo);
        secondNo = (EditText)findViewById(R.id.secondNo);
        resultEditText = (TextView) findViewById(R.id.resultEditText);
        plusButton = (Button)findViewById(R.id.plusButton);
        minusButton = (Button)findViewById(R.id.minusButton);
        plusButton.setOnClickListener(plusButtonClickListener);
        minusButton.setOnClickListener(minusButtonClickListener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("firstNo", firstNo.getText().toString());
        savedInstanceState.putString("secondNo", secondNo.getText().toString());
        savedInstanceState.putString("resultEditText", resultEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("firstNo")) {
            firstNo.setText(savedInstanceState.getString("firstNo"));
        } else {
            firstNo.setText("");
        }
        if (savedInstanceState.containsKey("secondNo")) {
            secondNo.setText(savedInstanceState.getString("secondNo"));
        } else {
            secondNo.setText("");
        }
        if (savedInstanceState.containsKey("resultEditText")) {
            resultEditText.setText(savedInstanceState.getString("resultEditText"));
        } else {
            resultEditText.setText("");
        }
    }
}