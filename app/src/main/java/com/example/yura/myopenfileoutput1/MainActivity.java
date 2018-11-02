package com.example.yura.myopenfileoutput1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    String OUTPUT_FILE = "public_cat.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butSaveFile = (Button) findViewById(R.id.buttonSaveFile);
        final EditText editFileName = (EditText) findViewById(R.id.editTextFileName);
        final EditText editContent = (EditText) findViewById(R.id.editTextContent);

        butSaveFile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String fileName = editFileName.getText().toString(); // имя будущего файла
                String content = editContent.getText().toString();   // получаем содержимое

                FileOutputStream fos;
                try {
                    fos = openFileOutput(fileName, Context.MODE_PRIVATE); // открываем файл для записи
                    fos.write(content.getBytes()); // записываем данные
                    fos.close(); // закрываем файл

                    // выводим сообщение
                    Toast.makeText(MainActivity.this,
                            "Файл " + fileName + " сохранён", Toast.LENGTH_LONG).show();

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
