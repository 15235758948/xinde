package base.toor.click.toor_xiazai;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;


/**
 * Created by Administrator on 2017/4/1.
 */
public class CompletedFragment extends Fragment {
    public static CompletedFragment newInstance() {
        return new CompletedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.downloadinglayout, null);

        return view;
    }
}
