package sg.edu.rp.c346.id20013327.democontextmenutranslationl06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText, tvTranslatedText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.tvTranslatedText);
        tvTranslatedText2 = findViewById(R.id.tvTranslatedText2);
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");

        if(v == tvTranslatedText) {
            wordClicked = "1st"; // To give some clarity
        } else if (v == tvTranslatedText2) {
            wordClicked = "2nd"; // To give some clarity
        }
        menu.setHeaderTitle(wordClicked + " is clicked");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d("onContextItemSelected", "detected menuitem click");
        if(wordClicked.equalsIgnoreCase("1st")) { //check whether the selected menu item ID is 0
            //code for action
            Log.d("onContextItemSelected", "detected menuitem click");
            if(item.getItemId()== 0){
                tvTranslatedText.setText("Hello");
            } else if (item.getItemId()==1){
                tvTranslatedText.setText("Ciao");
            }
            return true; //menu item successfully handled
        }
        if(wordClicked.equalsIgnoreCase("2nd")) { //check if the selected menu item ID is 1
            //code for action
            Log.d("onContextItemSelected", "detected menuitem click");
            if(item.getItemId()== 0) {
                tvTranslatedText2.setText("Bye");
            } else if(item.getItemId()==1) {
                tvTranslatedText2.setText("Addio");
            }
            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }




}