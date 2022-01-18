package com.example.luncher.Books;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.luncher.Data.DataBaseHandler;
import com.example.luncher.Details.About_practical;
import com.example.luncher.Home;
import com.example.luncher.R;
import com.example.luncher.model.Content;

import java.io.File;

public class Practical extends AppCompatActivity {

    ActionBar actionBar;
    Boolean Showing_first =true;

    File file = new File(Environment.getExternalStorageDirectory() + "/Documents/HP-8570 Datasheet.pdf");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical);
        nostatus();

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        actionBar.setDisplayShowTitleEnabled(false);

        Button open_PDF = findViewById(R.id.open_practical);

       // File file = new File(Environment.getExternalStorageDirectory() + "/Documents/HP-8570 Datasheet.pdf");
        if(file.exists()){
            open_PDF.setText("Open");
        }
        else{
            open_PDF.setText("DOWNLOAD");
        }

        final Button bookmark = findViewById(R.id.prac_bookmark);
        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Showing_first==true){
                    bookmark.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);
                    Showing_first= false;
                    showToast("practical English Usage added to your Bookmarks.");

                    DataBaseHandler db = new DataBaseHandler(Practical.this);
                    Content Practical = new Content();
                    Practical.setName("Practical English Usage");
                    Practical.setTopic("English");

                    db.addcontent(Practical);
                }
                else {
                    bookmark.setBackgroundResource(R.drawable.ic_bookmark_border_black_24dp);
                    Showing_first = true;
                    showToast("practical English Usage removed from your Bookmarks.");

                    DataBaseHandler db = new DataBaseHandler(Practical.this);
                    Content Practical = new Content();
                    db.deleteContent(Practical);
                }
            }
        });


        open_PDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloader();
            }
        });

        Button about_prac = findViewById(R.id.about_prac);
        about_prac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_detail();
            }
        });

    }

    public void nostatus(){
        Window window = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void showToast(String text){

        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }

    public void Go_Home(){
        Intent intent= new Intent(this, Home.class);
        startActivity(intent);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void downloader(){

        //File file = new File(Environment.getExternalStorageDirectory() + "/Documents/HP-8570 Datasheet.pdf");
        if(file.exists()){

            //File pdf = new File(Environment.getExternalStorageDirectory() + "/Documents/HP-8570 Datasheet.pdf");
            Uri uri = Uri.fromFile(file);

            Intent intent = new Intent();
            intent.setDataAndType(uri,"application/pdf");
            startActivity(intent);
        }
        else{

            if (isNetworkAvailable()==true){

                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://drive.google.com/uc?export=download&id=1gAVqAgjlejAtgGQjyg7ZbKeWpStTxsjE");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setVisibleInDownloadsUi(true);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOCUMENTS, "HP-8570 Datasheet.pdf");
                downloadManager.enqueue(request);

                BroadcastReceiver onComplete=new BroadcastReceiver() {
                    public void onReceive(Context ctxt, Intent intent) {
                        Button open_PDF = findViewById(R.id.open_practical);
                        open_PDF.setText("Open");
                        showToast("Downloaded");
                    }
                };

                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

            }

            else{
                showToast("There is no Internet Connection");
            }

        }

    }

    public void go_detail(){
        Intent goto_Detail = new Intent(this, About_practical.class);
        startActivity(goto_Detail);
    }

}
