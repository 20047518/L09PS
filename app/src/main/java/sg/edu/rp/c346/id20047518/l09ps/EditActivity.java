package sg.edu.rp.c346.id20047518.l09ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    TextView tvID, tvSong, tvName, tvYear, tvStar;
    EditText etID, etSong, etName, etYear;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rg;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_edit );

        tvID = findViewById( R.id.tvID );
        tvSong = findViewById( R.id.tvSong );
        tvName = findViewById( R.id.tvName );
        tvYear = findViewById( R.id.tvYear );
        tvStar = findViewById( R.id.tvStar );
        etID = findViewById( R.id.etID );
        etSong = findViewById( R.id.etSong );
        etName = findViewById( R.id.etName );
        etYear = findViewById( R.id.etYear );
        rb1 = findViewById( R.id.rb1 );
        rb2 = findViewById( R.id.rb2 );
        rb3 = findViewById( R.id.rb3 );
        rb4 = findViewById( R.id.rb4 );
        rb5 = findViewById( R.id.rb5 );
        btnUpdate = findViewById( R.id.btnUpdate );
        btnDelete = findViewById( R.id.btnDelete );
        btnCancel = findViewById( R.id.btnCancel );
        rg = findViewById( R.id.rg );
        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        int rbID = rg.getCheckedRadioButtonId();

        RadioButton radioButton = (RadioButton) rg.findViewById(rbID);

        //String selectedText = (String) radioButton.getText();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setTitle(etSong.getText().toString());
                data.setSingers(etName.getText().toString());
                data.setYear( Integer.parseInt( etYear.getText().toString() ) );
                int SelectedRB = rg.getCheckedRadioButtonId();
                RadioButton rb =  (RadioButton) findViewById( SelectedRB );
                data.setStars( Integer.parseInt( rb.getText().toString() ));
                dbh.updateSong(data);
                dbh.close();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(data.getid());

            }
        });

        btnCancel.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent( EditActivity.this,
                        ListActivity.class );
                startActivity( i );
            }
        } );
    }
}