package base.toor.click;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.myapplication.HomeActivity;
import com.example.administrator.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Toor_xiaoxitx extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toor_xiaoxitx);

        //        隐藏Actionbar
        if (getActionBar() != null) {
            getActionBar().hide();
        }
//        信号栏变主题
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.title_xiaoxitx_fh)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_xiaoxitx_fh:
                finish();
                break;
        }

    }
}
