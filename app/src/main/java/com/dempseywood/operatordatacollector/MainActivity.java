package com.dempseywood.operatordatacollector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    static final String[] scheduleItems = new String[] { "2.12 Supply and place straw mulch to temporary stabilise earthworks areas",
            "2.13 Hydro-seeding to temporarily stabilise earthworks areas",
            "2.30 1.0mm HDPE liner with welded joints to a depth of 1.0m for sediment retention ponds.  Include for preparation of smooth base perimeter fixing and ballast/weighting as required.",
            "3.6 R Strip topsoil 200mm thick to temporary stockpile (measured in the cut)",
            "3.8 Undercut gully material to waste off-site (measured in the cut)",
            "3.9 Approved imported hardfill backfill, as specified to gully undercut (measured solid in place)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.scheduleItemListView);
        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.activity_main, scheduleItems));
    }

    public void confirmScheduleItems(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);


        startActivity(intent);
    }


}
