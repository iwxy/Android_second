package com.example.a16478004_wxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a16478004_wxy.Module.Authors;
import com.example.a16478004_wxy.Module.Book;

public class FirstActivity extends Activity {

    EditText bookid,bookname,authorid,authorname;
    Button btn_submit;

    String bname,aname;
    int bid,aid;

    Book book = new Book();
    Authors author = new Authors();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        initEvent();
    }
    //初始化组件
    private void initView(){
        bookid = findViewById(R.id.bookid);
        bookname = findViewById(R.id.bookname);
        authorid = findViewById(R.id.bookid);
        authorname = findViewById(R.id.authorname);
        btn_submit = findViewById(R.id.btn_submit);

    }

    //组件绑定事件
    private void initEvent() {


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bookid.getText()==null || bookid.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"书ID不能为空哦，请填写！",Toast.LENGTH_SHORT).show();
                    bookid.setFocusable(true);
                }else if(bookname.getText()==null || bookname.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"书名不能为空哦，请填写！",Toast.LENGTH_SHORT).show();
                    bookname.setFocusable(true);
                }else if(authorid.getText()==null || authorid.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"作者ID不能为空哦，请填写！",Toast.LENGTH_SHORT).show();
                    authorid.setFocusable(true);
                }else if(authorname.getText()==null || authorname.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"作者名不能为空哦，请填写！",Toast.LENGTH_SHORT).show();
                    authorname.setFocusable(true);
                }else{
//                    bookid.setText("123456");
                    bid = Integer.parseInt(bookid.getText().toString());
                    aid = Integer.parseInt(authorid.getText().toString());
                    bname = bookname.getText().toString();
                    aname = authorname.getText().toString();
//                    Toast.makeText(getApplicationContext(),aid,Toast.LENGTH_SHORT).show();

                    author.setAuthorid(aid);
                    author.setAuthorname(aname);
                    book.setBookid(bid);
                    book.setBookname(bname);
                    book.setAuthor(author);

                    Bundle bd = new Bundle();
                    bd.putSerializable("book",book);
                    Intent in = new Intent();
                    in.setAction("MyAction");
//                    in.addCategory("MyCategory");
                    in.putExtra("bundle",bd);
                    startActivity(in);
                }
            }
        });
    }

}
