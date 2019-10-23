package com.example.a16478004_wxy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a16478004_wxy.Module.Authors;
import com.example.a16478004_wxy.Module.Book;

public class SecondActivity extends Activity {

    TextView bookid,bookname,authorid,authorname;
    Button baidu,call;
    Book book;
    Authors author;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Bundle bd = intent.getBundleExtra("bundle");
        book = (Book)bd.getSerializable("book");
        initView();
        initEvent();
    }

    //初始化组件
    private void initView(){
        bookid = findViewById(R.id.show_bid);
        bookname = findViewById(R.id.show_bname);
        authorid = findViewById(R.id.show_aid);
        authorname = findViewById(R.id.show_aname);
        baidu = findViewById(R.id.btn_gotobaidu);
        call = findViewById(R.id.btn_call);
        bookid.setText("书籍ID："+book.getBookid());
        bookname.setText("书名："+book.getBookname());
        authorid.setText("作者ID："+book.getAuthor().getAuthorid()+"");
        authorname.setText("作者名："+book.getAuthor().getAuthorname());
    }

    //组件绑定事件
    private void initEvent() {
        baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri website = Uri.parse("http://www.baidu.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, website);
                startActivity(webIntent);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:10086");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });
    }

}
