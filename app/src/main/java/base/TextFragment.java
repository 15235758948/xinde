package base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/20.
 */

public class TextFragment extends Fragment {
    private static final String FRAGMENT_TEXT = "fragment_text";
    @BindView(R.id.text)
    TextView text;

    public static TextFragment newInstance(String text) {
        TextFragment textFragment = new TextFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_TEXT, text);
        textFragment.setArguments(bundle);
        return textFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        ButterKnife.bind(this, view);
        text.setText(getArgumentText());
        return view;
    }
    public  String getArgumentText(){
        return getArguments().getString(FRAGMENT_TEXT);
    }
}
