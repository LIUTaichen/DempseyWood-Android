package com.dempseywood.operatordatacollector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.dempseywood.operatordatacollector.scheduleitem.DataHolder;
import com.dempseywood.operatordatacollector.scheduleitem.ScheduleItem;
import com.dempseywood.operatordatacollector.status.LoadedButtonOnDragListener;
import com.dempseywood.operatordatacollector.status.LoadedButtonOnLongClickListener;
import com.dempseywood.operatordatacollector.status.UnloadedButtonOnDragListener;
import com.dempseywood.operatordatacollector.status.UnloadedButtonOnLongClickListener;

import java.util.ArrayList;

public class EquipmentStatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_status);

        ArrayList<ScheduleItem> allItems = DataHolder.getInstance().getScheduleItemList();
       /* ArrayList<ScheduleItem> activeItems = new  ArrayList<ScheduleItem>();
        for(ScheduleItem item: allItems){
            if(item.isSelected()){
                activeItems.add(item);
            }
        }*/

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.schedule_items_array, R.layout.spinner_layout);


// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.dropdown_layout);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        Button buttonUnloaded = (Button) findViewById(R.id.unloadedButton);
        Button buttonLoaded = (Button) findViewById(R.id.loadedButton);

        buttonLoaded.setClickable(false);
        buttonLoaded.setBackgroundResource(R.drawable.inactive);
        buttonUnloaded.setOnLongClickListener(new UnloadedButtonOnLongClickListener());
        buttonLoaded.setOnLongClickListener(new LoadedButtonOnLongClickListener());

        buttonUnloaded.setOnDragListener(new UnloadedButtonOnDragListener());


        buttonLoaded.setOnDragListener(new LoadedButtonOnDragListener());
    }

    public void incrementLoadCount(){
        TextView countView = (TextView)findViewById(R.id.count);
        String currentCount = countView.getText().toString();
        int newCount = Integer.parseInt(currentCount);
        countView.setText(newCount + 1 +"");
    }

    public void switchToUnloaded(){
        Button buttonUnloaded = (Button) findViewById(R.id.unloadedButton);
        Button buttonLoaded = (Button) findViewById(R.id.loadedButton);
        buttonUnloaded.setClickable(true);
        buttonLoaded.setClickable(false);
        buttonUnloaded.setBackgroundResource(R.drawable.active_unloaded);
        buttonLoaded.setBackgroundResource(R.drawable.inactive);
        TextView instruction = (TextView)findViewById(R.id.instruction);
        instruction.setText(R.string.drag_down);
        incrementLoadCount();

    }

    public void switchToLoaded(){
        Button buttonUnloaded = (Button) findViewById(R.id.unloadedButton);
        Button buttonLoaded = (Button) findViewById(R.id.loadedButton);
        buttonUnloaded.setClickable(false);
        buttonLoaded.setClickable(true);
        buttonUnloaded.setBackgroundResource(R.drawable.inactive);
        buttonLoaded.setBackgroundResource(R.drawable.active_loaded);
        TextView instruction = (TextView)findViewById(R.id.instruction);
        instruction.setText(R.string.drag_up);
    }
}