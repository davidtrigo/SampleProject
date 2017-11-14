package david.sampleproyect;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview1);
        textView.setText("Esta es la activity 1");
        Button botonNuevaActivity = findViewById(R.id.buttonNewActivity);

        botonNuevaActivity.setOnClickListener(new View.OnClickListener(){
           @Override
            public  void onClick(View v){
              Log.d(MainActivity.class.getSimpleName(),"onClick");
               Intent intent = new Intent(MainActivity.this,SecondActivity.class);

               startActivity(intent);
           }


        });
        Log.d(MainActivity.class.getSimpleName(),"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MainActivity.class.getSimpleName(),"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MainActivity.class.getSimpleName(),"onResume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainActivity.class.getSimpleName(),"onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.class.getSimpleName(),"onDestroy");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MainActivity.class.getSimpleName(),"onPause");
    }
}
