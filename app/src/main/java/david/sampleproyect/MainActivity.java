package david.sampleproyect;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    private final static int REQUEST_CODE_ACTIVITY = 0;
    private TextView textView;
  /*  private String fechaRetorno =null;*/

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview1);
        textView.setText("Esta es la activity 1");

        Button botonNuevaActivity = findViewById(R.id.buttonNewActivity);
        Button btnsendemail = findViewById(R.id.btnsendemail);

        
        botonNuevaActivity.setOnClickListener(this);
        btnsendemail.setOnClickListener(this);



        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "onSaveInstanceState");

        if (textView != null){
            outState.putString("fechaRetorno",textView.getText().toString());
            Log.d(TAG, "onSaveInstanceState  if");
        }

        /*if (fechaRetorno != null){
            outState.putString("fechaRetorno",fechaRetorno);
            Log.d(TAG, "onSaveInstanceState  if");
        }*/
    }



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        
        Log.d(TAG, "onRestoreInstanceState");
        
        /*if (savedInstanceState != null && savedInstanceState.containsKey("fechaRetorno")){
            fechaRetorno = savedInstanceState.getString("fechaRetorno");
            textView.setText(fechaRetorno);
            
        }*/

        if (savedInstanceState != null && savedInstanceState.containsKey("fechaRetorno")){
            textView.setText(savedInstanceState.getString("fechaRetorno"));

        }
    }

    /**/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_ACTIVITY) {

            Toast.makeText(MainActivity.this, "¡Intent devuelto!", Toast.LENGTH_LONG).show();

            /*   if (data.getExtras() != null && data.getExtras().containsKey("date")) {
                  fechaRetorno = data.getExtras().getString("date");
                textView.setText(fechaRetorno);
            }*/

            if (data.getExtras() != null && data.getExtras().containsKey("date")) {
                textView.setText(data.getExtras().getString("date"));
            }

        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonNewActivity:

                Log.d(TAG, "onClick");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Date currentDate = Calendar.getInstance().getTime();
                intent.putExtra("date", currentDate.toString());
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_ACTIVITY);


            break;

            case R.id.btnsendemail:

                // enviar email
                break;

            default:

                // comportamiento por default
                break;
        }

    }
}
