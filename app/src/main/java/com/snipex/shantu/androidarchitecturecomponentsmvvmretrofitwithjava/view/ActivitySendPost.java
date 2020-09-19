package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Post;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.ArticleRepository;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model.ArticleViewModel;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model.PostViewModel;

public class ActivitySendPost extends AppCompatActivity {
    private static final String TAG = ActivitySendPost.class.getSimpleName();

    TextView tv_response  ,tv_response2;
    EditText et_body,et_title;
    Button btn_submit ;
    PostViewModel postViewModel ;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendpost);
        post = new Post();

        tv_response = (TextView) findViewById(R.id.tv_response);
        tv_response2 = (TextView) findViewById(R.id.tv_response2);

        et_body = (EditText) findViewById(R.id.et_body);
        et_title = (EditText) findViewById(R.id.et_title);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);




        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set dummy data
                if(et_title.getText().toString()!=null || et_body.getText().toString()!=null){

                    post.setTitle(et_title.getText().toString());
                    post.setBody(et_body.getText().toString());
                    post.setUserId((int)Math.random());

                }

                postViewModel.setPostData(post);


                postViewModel.getPostResponseLiveData().observe(ActivitySendPost.this , postResponse -> {

                    if(postResponse != null){
                        //Log.e(TAG, "onClick: "+postResponse.getBody().toString() );
                        tv_response.setText(""+postResponse);
                        tv_response2.setText("Success : " + Math.random());
                    }
                });


            }
        });


    }
}
