package huang.com.qrscansample;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

public class MainActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resultTextView = (TextView) findViewById(R.id.result_tv);

        mydecoderview = (QRCodeReaderView) findViewById(R.id.qrdecoderview);
        mydecoderview.setOnQRCodeReadListener(this);
        // Use this function to enable/disable decoding
//        mydecoderview.setQRDecodingEnabled(true);

        // Use this function to change the autofocus interval (default is 5 secs)
//        mydecoderview.setAutofocusInterval(2000L);

        // Use this function to enable/disable Torch
//        mydecoderview.setTorchEnabled(true);

        // Use this function to set front camera preview
//        mydecoderview.setFrontCamera();

        // Use this function to set back camera preview
        mydecoderview.setBackCamera();

        mydecoderview.startCamera();


        SampleMaskView viewById = (SampleMaskView) findViewById(R.id.sample_mask_view);
        viewById.startScanAnimation();
    }

    private TextView resultTextView;
    private QRCodeReaderView mydecoderview;

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        resultTextView.setText(text);
        Toast.makeText(this,text,0).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mydecoderview.startCamera();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mydecoderview.stopCamera();
    }
}
