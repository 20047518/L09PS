package sg.edu.rp.c346.id20047518.l09ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvSong, tvName, tvYear, tvStar;
    EditText etSong, etName, etYear;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Button btnAdd, btnDisplay;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        tvSong = findViewById( R.id.tvSong );
        tvName = findViewById( R.id.tvName );
        tvYear = findViewById( R.id.tvYear );
        tvStar = findViewById( R.id.tvStar );
        etSong = findViewById( R.id.etSong );
        etName = findViewById( R.id.etName );
        etYear = findViewById( R.id.etYear );
        rb1 = findViewById( R.id.rb1 );
        rb2 = findViewById( R.id.rb2 );
        rb3 = findViewById( R.id.rb3 );
        rb4 = findViewById( R.id.rb4 );
        rb5 = findViewById( R.id.rb5 );
        btnAdd = findViewById( R.id.btnAdd );
        btnDisplay = findViewById( R.id.btnDisplay );
        rg = findViewById( R.id.rg );


        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etSong.getText().toString().trim();
                String singers = etName.getText().toString().trim();
                String year_str = etYear.getText().toString().trim();
                int year = Integer.valueOf( year_str );
                int stars = getStars();


                DBHelper dbh = new DBHelper( MainActivity.this );
                long inserted_id = dbh.insertSong(title,singers,year,stars);
                if (inserted_id != -1) {
                    Toast.makeText( MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT ).show();
                }

            }
        } );

        btnDisplay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MainActivity.this,
                        ListActivity.class );
                startActivity( i );
            }

        } );


    }


    private int getStars() {
        int stars = 1;
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.rb1:
                stars = 1;
                break;
            case R.id.rb2:
                stars = 2;
                break;
            case R.id.rb3:
                stars = 3;
                break;
            case R.id.rb4:
                stars = 4;
                break;
            case R.id.rb5:
                stars = 5;
                break;
        }
        return stars;
    }
}


