package com.example.hardwaremonitor;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HardwarePropertiesManager;
import android.os.StatFs;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;

import static java.lang.System.getProperty;


public class procs extends AppCompatActivity {

    TextView textView ;
    ProcessBuilder processBuilder;
    String Holder = "";
    String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
    InputStream inputStream;
    Process process ;
    byte[] byteArry ;

    /*private TextView infoModel;
    private TextView infoManuf;
    private TextView infoDev;
    private TextView infoNomHard;
    private TextView infoBoard;
    private TextView infoCode;
    private TextView infoRel;
    private TextView infoVerSDK;
    private TextView infoOS;
    private TextView infoArchOS;
    private TextView infoVerJava;
    private Handler monGestionnaire;
    private static int periode = 500; //période d'appel de la tache de fond en ms

    private Runnable tacheDeFond = new Runnable() {
        @Override
        public void run() {
            //CallBack

            //Initialisation tempo avant le nouvel appel de la tache de fond
            monGestionnaire.postDelayed(this, periode);
        }
    };*/

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procs);

        textView = (TextView)findViewById(R.id.textView);

        byteArry = new byte[1024];

        try{
            processBuilder = new ProcessBuilder(DATA);

            process = processBuilder.start();

            inputStream = process.getInputStream();

            while(inputStream.read(byteArry) != -1){

                Holder = Holder + new String(byteArry);
            }

            inputStream.close();

        } catch(IOException ex){

            ex.printStackTrace();
        }

        textView.setText(Holder);



        /*Button button = (Button) findViewById(R.id.button);
        HardwarePropertiesManager hPM;

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        // textView is the TextView view that should display it
        //clock.setText(currentDateTimeString);

        //informarion générale invariante
        infoModel = findViewById(R.id.infoModel);
        infoModel.setText(Build.MODEL);
        infoManuf = findViewById(R.id.infoManuf);
        infoManuf.setText(Build.MANUFACTURER);
        infoDev = findViewById(R.id.infoDev);
        infoDev.setText(Build.DEVICE);
        infoNomHard = findViewById(R.id.infoNomHard);
        infoNomHard.setText(Build.HARDWARE);
        infoBoard = findViewById(R.id.infoBoard);
        infoBoard.setText(Build.BOARD);
        infoCode = findViewById(R.id.infoCode);
        infoCode.setText(Build.VERSION.CODENAME);
        infoRel = findViewById(R.id.infoRel);
        infoRel.setText(Build.VERSION.RELEASE);
        infoVerSDK = findViewById(R.id.infoVerSDK);
        infoVerSDK.setText(Integer.toString(Build.VERSION.SDK_INT));
        infoOS = findViewById(R.id.infoOS);
        infoOS.setText(Build.VERSION.BASE_OS);
        infoArchOS = findViewById(R.id.infoArchOS);
        infoArchOS.setText(getProperty("os.arch"));
        infoVerJava = findViewById(R.id.infoVerJava);
        infoVerJava.setText(getProperty("java.vm.version"));

        ActivityManager activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        float totalMem = memoryInfo.totalMem/(1024*1024);
        float freeMem = memoryInfo.availMem/(1024*1024);
        Log.w("BTO","Total mem "+Float.toString(totalMem));
        Log.w("BTO","Free mem "+Float.toString(freeMem));
        //ROM
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        float blockSize = stat.getBlockSizeLong();
        float totalBlock = stat.getBlockCountLong();
//        float blockLibre = stat.
        Log.w("BTO", "BlockSize "+Float.toString(blockSize));
        Log.w("BTO", "totalBlock "+Float.toString(totalBlock));


        monGestionnaire = new Handler();
        monGestionnaire.postDelayed(tacheDeFond, periode);*/

    };

    public void BTN_Back(View view) {
        Intent BTN_Back = new Intent(procs.this, MainActivity.class);
        this.finish();
        startActivity(BTN_Back);
    }

    public void View_Memory(View view) {
        Intent BTN_Back = new Intent(procs.this, MemoryActivity.class);
        this.finish();
        startActivity(BTN_Back);
    }

    public void View_Storage(View view) {
        Intent BTN_Back = new Intent(procs.this, StorageActivity.class);
        this.finish();
        startActivity(BTN_Back);
    }

    /*public void menuPrin(View v) {

        Intent intent1 = new Intent(procs.this, MainActivity.class);
        startActivity(intent1);
    };*/

}