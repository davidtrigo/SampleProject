package david.sampleproyect;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {

    private final static int REQUEST_CODE_ACTIVITY = 0;
    private TextView textView;
    private String fechaRetorno =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview1);
        textView.setText("Esta es la activity 1");

        Button botonNuevaActivity = findViewById(R.id.buttonNewActivity);

        botonNuevaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MainActivity.class.getSimpleName(), "onClick");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Date currentDate = Calendar.getInstance().getTime();
                intent.putExtra("date", currentDate.toString());
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_ACTIVITY);


            }


        });
        Log.d(MainActivity.class.getSimpleName(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MainActivity.class.getSimpleName(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MainActivity.class.getSimpleName(), "onResume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainActivity.class.getSimpleName(), "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.class.getSimpleName(), "onDestroy");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MainActivity.class.getSimpleName(), "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        if (fechaRetorno!=null){
            outState.putString("fechaRetorno",fechaRetorno);

        }
    }

    /**/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_ACTIVITY) {

            Toast.makeText(MainActivity.this, "¡Intent devuelto!", Toast.LENGTH_LONG).show();

            if (data.getExtras() != null && data.getExtras().containsKey("date")) {
                  fechaRetorno = data.getExtras().getString("date");
                textView.setText(fechaRetorno);
            }

        }
    }
}
