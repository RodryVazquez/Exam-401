///////////////////////////////////////////////////////////////////////////////
// Exam AND-401
// BMI CALCULATOR
// By: Rodrigo Vazquez
//

package and_401.exam_01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float BMI,height,width;
    private EditText getInputHeight,getInputWeight;
    private Button btnCalculateBMI;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        getInputHeight = (EditText)findViewById(R.id.edt_input_height);
        getInputWeight = (EditText)findViewById(R.id.edt_input_weight);
        btnCalculateBMI = (Button)findViewById(R.id.btnCalculate_BMI);
        txtResult = (TextView)findViewById(R.id.txtResult);


        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BMI = calculateBMI(Float.parseFloat(getInputHeight.getText().toString()), Float.parseFloat(getInputWeight.getText().toString()));
                if(BMI < 16){
                    txtResult.setText("Your BMI: " + BMI +"( Severely underweight)");
                }else if(BMI < 18.5){
                    txtResult.setText("Your BMI: " + BMI +"( Underweight)");
                }else if(BMI < 25){
                    txtResult.setText("Your BMI: " + BMI +"( Normal)");
                }else if(BMI < 30){
                    txtResult.setText("Your BMI: " + BMI +"( Overweight)");
                }else{
                    txtResult.setText("Your BMI: " + BMI +"( Obese)");
                }
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

    //Metodo para calcular el BMI
    public float calculateBMI(float height, float weight){
        height = (height/100);
        return (weight/(height * height));
    }

}
