package layout;


import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import com.example.mohammed.lessonsmanagerapp.ImageDownloader;
import com.example.mohammed.lessonsmanagerapp.R;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;


public class Imagefragmet extends Fragment {

    private Button btn1;
    private Button btn2;
    private ImageView img1;
    private ImageView img2;

  //  private ImageView downloadedImg;
    private ProgressDialog simpleWaitDialog;
    private String downloadUrl = "http://www.androidpolice.com/wp-content/uploads/2010/07/superdroid.png";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_imagefragmet, container, false);
        btn1 = (Button) v.findViewById(R.id.btn1);
        btn2 = (Button) v.findViewById(R.id.btn2);

        img1 = (ImageView) v.findViewById(R.id.image1);
        img2 = (ImageView) v.findViewById(R.id.image2);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Picasso.with(getActivity()).load(downloadUrl).into(img1);


            }});

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ImageDownloader downloadImg = new ImageDownloader(img2,getActivity()) ;
                downloadImg.execute(downloadUrl);
              //  img2 = img.getImage();

            }});


        return v;
    }

//    public class ImageDownloader extends AsyncTask<String,Void,Bitmap> {
//        private ImageView image;
//
//        public ImageDownloader() {
//
//            View v = new ImageView(getActivity().getBaseContext());
//            image = new ImageView(v.getContext());
//
//        }
//
//        ProgressDialog mProgressDialog;
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // Create a progressdialog
//            mProgressDialog = new ProgressDialog(getActivity());
//            // Set progressdialog title
//            mProgressDialog.setTitle("Download Image Tutorial");
//            // Set progressdialog message
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            // Show progressdialog
//            mProgressDialog.show();
//        }
//
//        public ImageView getImage() {
//            return image;
//        }
//
//        @Override
//        protected Bitmap doInBackground(String... URL) {
//
//            String imageURL = URL[0];
//
//            Bitmap bitmap = null;
//            try {
//                // Download Image from URL
//                InputStream input = new java.net.URL(imageURL).openStream();
//                // Decode Bitmap
//                bitmap = BitmapFactory.decodeStream(input);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return bitmap;
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap result) {
//            // Set the bitmap into ImageView
//            img2.setImageBitmap(result);
//            // Close progressdialog
//            mProgressDialog.dismiss();
//        }
//    }

}



