package com.developer.techies.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.developer.techies.retrofittutorial.adapter.ResponseAdapter;
import com.developer.techies.retrofittutorial.model.Item;
import com.developer.techies.retrofittutorial.model.MyResponse;
import com.developer.techies.retrofittutorial.remote.Service;
import com.developer.techies.retrofittutorial.utils.ApiUtils;
import com.developer.techies.retrofittutorial.utils.ItemListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ItemListener<Item>{

    Service mService;
    RecyclerView mRecyclerView;
    ResponseAdapter mAdapter;
    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main );
        mService = ApiUtils.getSOService();
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new ResponseAdapter(this, new ArrayList<Item>(0), this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    public void loadAnswers() {
        mService.getAnswers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(MyResponse soAnswersResponse) {
                        mAdapter.updateAnswers(soAnswersResponse.getItems());
                    }
                });
    }

    @Override
    public void onItemClick(Item v) {

    }
}
