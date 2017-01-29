package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mohammed.lessonsmanagerapp.R;

public class info extends Fragment {
    private Button back;
    private EditText textinfo;
    private EditText subTitle;
    private EditText lessonDate;
    private TextView infoTitle;
    private TextView save;
    private TextView edit;
    private boolean saved;
    private int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_info, container, false);
    }
}
