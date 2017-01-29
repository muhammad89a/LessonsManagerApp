package layout;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mohammed.lessonsmanagerapp.Adapters.LessonAdapter;
import com.example.mohammed.lessonsmanagerapp.ClickListener;
import com.example.mohammed.lessonsmanagerapp.DividerItemDecoration;
import com.example.mohammed.lessonsmanagerapp.DownloadImage;
import com.example.mohammed.lessonsmanagerapp.JsonActivity;
import com.example.mohammed.lessonsmanagerapp.Model.Lesson;
import com.example.mohammed.lessonsmanagerapp.PreferenceActivity;
import com.example.mohammed.lessonsmanagerapp.R;
import com.example.mohammed.lessonsmanagerapp.RecyclerTouchListener;
import com.example.mohammed.lessonsmanagerapp.ServiceActivity;

import java.util.ArrayList;
import java.util.List;

public class FragList extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    public List<Lesson> lessonsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LessonAdapter mAdapter;
    private Button AddButton;
    private int position;
    private boolean edited;
    private Intent intent_info2main ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_list, container, false);

        //  ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
    //    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        AddButton=(Button) v.findViewById(R.id.additem);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));

        mAdapter = new LessonAdapter(lessonsList);
        recyclerView.setAdapter(mAdapter);

        prepareLessonData();
        ///////////////////////////////

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Lesson lesson = lessonsList.get(position);
                Toast.makeText(getActivity(), lesson.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
                if(position==7){
                    Intent intent =new Intent(getActivity(),DownloadImage.class);
                    getActivity().startActivity(intent);
                }
                if(position==8){
                    Intent intent =new Intent(getActivity(),ServiceActivity.class);
                    getActivity().startActivity(intent);
                }
                if(position==9){
                    Intent intent =new Intent(getActivity(),JsonActivity.class);
                    getActivity().startActivity(intent);
                }
//                if(position==10){
//                    Intent intent =new Intent(getActivity(),PreferenceActivity.class);
//                    getActivity().startActivity(intent);
//                }

            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        AddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });


        //////////////////////////////


        return v;
    }
    private void prepareLessonData() {

        Lesson lesson = new Lesson("Lesson 1", "Android", "31 Nov 2016", "After completing the previous lesson, you have an app that shows an activity (a single screen) with a text field and a button. In this lesson, you’ll add some code to MainActivity that starts a new activity when the user clicks the Send button.");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 2", "Android", "1 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 3", "SQL", "3 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 4", "SQL", "5 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 5", "Web development", "7 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 6", "Android", "9 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 7", "Android", "11 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 8", "Image", "13 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 9", "service", "15 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 10", "Json", "17 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 11", "SQLite", "19 Des 2016");
        lessonsList.add(lesson);
/*
        lesson = new Lesson("Lesson 12", "Android", "21 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 13", "SQL", "23 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 14", "Android", "25 Des 2016");
        lessonsList.add(lesson);

        lesson = new Lesson("Lesson 15", "Web development", "27 Des 2016");
        lessonsList.add(lesson);
*/
        mAdapter.notifyDataSetChanged();
    }
}
