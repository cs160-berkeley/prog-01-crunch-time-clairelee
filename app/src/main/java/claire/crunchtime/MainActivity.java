package claire.crunchtime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //final String exercise = spinner.getSelectedItem().toString();

        Button buttonConvert = (Button) findViewById(R.id.buttonConvert);
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit_weight = (EditText) findViewById(R.id.edit_weight);
                EditText edit_reps = (EditText) findViewById(R.id.edit_reps);
                EditText edit_calories = (EditText) findViewById(R.id.edit_calories);
                TextView done = (TextView) findViewById(R.id.textView10);
                Spinner spinner = (Spinner) findViewById(R.id.exercise);

                String exercise = spinner.getSelectedItem().toString();

                double weight = Double.valueOf(edit_weight.getText().toString());
                double reps = Double.valueOf(edit_reps.getText().toString());
                double temp = repsToCalories(exercise, reps, weight);
                int calories = (int) temp;
                edit_calories.setText(String.valueOf(calories));

                double[][] array = new double[12][3];

                array[0][1] = 0.2514;
                array[1][1] = 0.44;
                array[2][1] = 0.3911;
                array[3][1] = 3.52;
                array[4][1] = 3.52;
                array[5][1] = 8.8;
                array[6][1] = 0.88;
                array[7][1] = 7.33;
                array[8][1] = 4.4;
                array[9][1] = 7.33;
                array[10][1] = 6.76;
                array[11][1] = 5.86;

                for (int i=0; i<12; i++) {
                    array[i][2] = 2.2 * 60 * calories / (weight * array[i][1]);
                }

                StringBuilder storage = new StringBuilder();
                storage.append("Reps of Pushups: ");
                storage.append(String.valueOf((int) array[0][2]));
                storage.append("\nReps of Situps: ");
                storage.append(String.valueOf((int) array[1][2]));
                storage.append("\nReps of Squats: ");
                storage.append(String.valueOf((int) array[2][2]));
                storage.append("\nMinutes of Leg-Lifts: ");
                storage.append(String.valueOf((int) array[3][2]));
                storage.append("\nMinutes of Planks: ");
                storage.append(String.valueOf((int) array[4][2]));
                storage.append("\nMinutes of Jumping Jacks: ");
                storage.append(String.valueOf((int) array[5][2]));
                storage.append("\nReps of Pullups: ");
                storage.append(String.valueOf((int) array[6][2]));
                storage.append("\nMinutes of Cycling: ");
                storage.append(String.valueOf((int) array[7][2]));
                storage.append("\nMinutes of Walking: ");
                storage.append(String.valueOf((int) array[8][2]));
                storage.append("\nMinutes of Jogging: ");
                storage.append(String.valueOf((int) array[9][2]));
                storage.append("\nMinutes of Swimming: ");
                storage.append(String.valueOf((int) array[10][2]));
                storage.append("\nMinutes of Stair-Climbing: ");
                storage.append(String.valueOf((int) array[11][2]));

                done.setText(storage);

            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit_weight = (EditText) findViewById(R.id.edit_weight);
                EditText edit_calories = (EditText) findViewById(R.id.edit_calories);
                TextView done = (TextView) findViewById(R.id.textView10);
                double weight = Double.valueOf(edit_weight.getText().toString());
                double calories = Double.valueOf(edit_calories.getText().toString());

                double[][] array = new double[12][3];

                array[0][1] = 0.2514;
                array[1][1] = 0.44;
                array[2][1] = 0.3911;
                array[3][1] = 3.52;
                array[4][1] = 3.52;
                array[5][1] = 8.8;
                array[6][1] = 0.88;
                array[7][1] = 7.33;
                array[8][1] = 4.4;
                array[9][1] = 7.33;
                array[10][1] = 6.76;
                array[11][1] = 5.86;

                for (int i=0; i<12; i++) {
                    array[i][2] = 2.2 * 60 * calories / (weight * array[i][1]);
                }

                StringBuilder storage = new StringBuilder();
                storage.append("Reps of Pushups: ");
                storage.append(String.valueOf((int) array[0][2]));
                storage.append("\nReps of Situps: ");
                storage.append(String.valueOf((int) array[1][2]));
                storage.append("\nReps of Squats: ");
                storage.append(String.valueOf((int) array[2][2]));
                storage.append("\nMinutes of Leg-Lifts: ");
                storage.append(String.valueOf((int) array[3][2]));
                storage.append("\nMinutes of Planks: ");
                storage.append(String.valueOf((int) array[4][2]));
                storage.append("\nMinutes of Jumping Jacks: ");
                storage.append(String.valueOf((int) array[5][2]));
                storage.append("\nReps of Pullups: ");
                storage.append(String.valueOf((int) array[6][2]));
                storage.append("\nMinutes of Cycling: ");
                storage.append(String.valueOf((int) array[7][2]));
                storage.append("\nMinutes of Walking: ");
                storage.append(String.valueOf((int) array[8][2]));
                storage.append("\nMinutes of Jogging: ");
                storage.append(String.valueOf((int) array[9][2]));
                storage.append("\nMinutes of Swimming: ");
                storage.append(String.valueOf((int) array[10][2]));
                storage.append("\nMinutes of Stair-Climbing: ");
                storage.append(String.valueOf((int) array[11][2]));

                done.setText(storage);



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


    public double repsToCalories(String exercise, double mins, double weight) {
        double[][] array = new double[12][2];
        array[0][1] = 0.2514;
        array[1][1] = 0.44;
        array[2][1] = 0.3911;
        array[3][1] = 3.52;
        array[4][1] = 3.52;
        array[5][1] = 8.8;
        array[6][1] = 0.88;
        array[7][1] = 7.33;
        array[8][1] = 4.4;
        array[9][1] = 7.33;
        array[10][1] = 6.76;
        array[11][1] = 5.86;
//        array[0][1] = 0.0019;
//        array[1][1] = 0.0033;
//        array[2][1] = 0.003;
//        array[3][1] = 0.906;
//        array[4][1] = 0.9060;
//        array[5][1] = 0.0667;
//        array[6][1] = 0.0667;
//        array[7][1] = 0.0556;
//        array[8][1] = 0.0333;
//        array[9][1] = 0.556;
//        array[10][1] = 0.513;
//        array[11][1] = 0.444;

        // calories = reps * weight * conversion

        for (int i=0; i<12; i++) {
            array[i][0] = (mins/60) * (weight/2.2) * array[i][1];
            //array[i][0] = mins * weight * array[i][1];
        }

        if (exercise.equals("Pushups")) {
            return array[0][0];
        } else if (exercise.equals("Situps")) {
            return array[1][0];
        } else if (exercise.equals("Squats")) {
            return array[2][0];
        } else if (exercise.equals("Leg Lifts")) {
            return array[3][0];
        } else if (exercise.equals("Planks")) {
            return array[4][0];
        } else if (exercise.equals("Jumping Jacks")) {
            return array[5][0];
        } else if (exercise.equals("Pullups")) {
            return array[6][0];
        } else if (exercise.equals("Cycling")) {
            return array[7][0];
        } else if (exercise.equals("Walking")) {
            return array[8][0];
        } else if (exercise.equals("Jogging")) {
            return array[9][0];
        } else if (exercise.equals("Swimming")) {
            return array[10][0];
        } else if (exercise.equals("Stair Climbing")) {
            return array[11][0];
        }
        return 0;

    }


}