package base.toor.click;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.myapplication.HomeActivity;
import com.example.administrator.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class Toor_gengduo extends Activity {

    @BindView(R.id.title_signs_fh)
    TextView titleSignsFh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toor_gengduo);

//        隐藏Actionbar
        if (getActionBar() != null) {
            getActionBar().hide();
        }
//        信号栏变主题
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.title_signs_fh)
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.title_signs_fh:
            finish();
        break;
    }
    }
}
