package com.sains.openpdf;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int GET_FROM_FILE = 01;
    Button btnPdf;
    PDFView pdfViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfViewer = findViewById(R.id.pdfView);
        btnPdf = findViewById(R.id.btn_pdf);

        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("file/pdf");
                startActivityForResult(intent, GET_FROM_FILE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri pdf = data.getData();
        pdfViewer.fromUri(pdf).load();


    }

}
