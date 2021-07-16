package sg.edu.rp.c346.id20047518.l09ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list );
        lv = findViewById( R.id.lv );
        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>( this,
                android.R.layout.simple_list_item_1, al );
        lv.setAdapter( aa );

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(ListActivity.this,
                        EditActivity.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper( ListActivity.this );
        al.clear();

        al.addAll( dbh.getAllSongs() );
        aa.notifyDataSetChanged();
        //btnRetrieve.performClick();
    }


}
