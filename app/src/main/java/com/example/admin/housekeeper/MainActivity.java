package com.example.admin.housekeeper;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.admin.housekeeper.JAVA.FunctionAdapter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener, Toolbar.OnMenuItemClickListener {
    private long                mStartTime;
    private GridView            mView;
    private ArrayList<Function> mList;
    private Toolbar mToolbar;
    private int[]    mIcon = {R.drawable.icon_rocket, R.drawable.icon_softmgr, R.drawable.icon_phonemgr,
            R.drawable.icon_telmgr, R.drawable.icon_filemgr, R.drawable.icon_sdclean};
    private String[] mName = {"手机加速", "软件管理", "手机检测", "通讯大全", "文件管理", "垃圾清理"};
    private FunctionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (GridView) findViewById(R.id.gv_show);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mList = new ArrayList<>();
        for (int i = 0; i < mIcon.length; i++) {

            mList.add(new Function(mName[i], mIcon[i]));

        }
        mAdapter = new FunctionAdapter(this, mList);
        mView.setAdapter(mAdapter);
        mView.setOnItemClickListener(this);
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(this);


    }

    /**
     * assets下的文件移动到包名下
     *
     * @param
     */
    public void moveData() throws IOException {
        if (!DBReader.isExsitDBFile()) {
            String path = "data/data/com.example.admin.housekeeper/commonnum.db";
            AssetManager manager = getAssets();
            InputStream is = manager.open("commonnum.db");
            BufferedInputStream bis = new BufferedInputStream(is);
            //      FileOutputStream os = openFileOutput("commonnum.db",MODE_PRIVATE);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            bos.close();
            bis.close();
        }

    }



    //对返回做出限制，不允许返回动画界面，只能点击两次后退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        while (System.currentTimeMillis() - mStartTime > 2000) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                Toast.makeText(this, "请在两秒内再次点击退出", Toast.LENGTH_SHORT).show();
                mStartTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //点击事件，进行跳转到通讯录大全界面
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 3:
                try {
                    moveData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, TelphoneActivity.class);
                startActivity(intent);

                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this,"点击了Toolbar",Toast.LENGTH_SHORT).show();
        return false;
    }
}
