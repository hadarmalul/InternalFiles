package com.example.internalfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.FileObserver;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;
    String stw, str, Line, str2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);

        /**
         * Reading the text file "test.txt" to the TextView widget in the screen
         */
        try {
            FileInputStream fis = openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            Line = br.readLine();
            while (Line != null){
                sb.append(Line);
                Line = br.readLine();
            }
            str = sb.toString();
            str2 = str;
            isr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.setText(str);
        et.setText(str);


    }


    public void save(View view) {

        /**
         * Writing to text file "test.txt" from the text the user typed
         * @param view
         */

        stw = et.getText().toString();

        try {
            FileOutputStream fos = openFileOutput("text.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(str2+stw);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Reading the text file "test.txt" to the TextView widget in the screen
         */
        try {
            FileInputStream fis = openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            Line = br.readLine();
            while (Line != null){
                sb.append(Line);
                Line = br.readLine();
            }
            str = sb.toString();
            str2 = str;
            isr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.setText(str);

    }

    /**
     * Resetting the text file "test.txt"
     * @param view
     */

    public void reset(View view) {
        try {
            FileOutputStream fos = openFileOutput("text.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("");
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        et.setText("");
        tv.setText("");
    }

    /**
     * Writing to text file "test.txt" from the text the user typed
     * @param view
     */

    public void exit(View view) {

        stw = et.getText().toString();

        try {
            FileOutputStream fos = openFileOutput("text.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(str2+stw);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finish();

    }
}
