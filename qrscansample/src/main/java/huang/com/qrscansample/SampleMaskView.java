package huang.com.qrscansample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

/**
 * Created by huangzhixiong on 16/12/27.
 */

public class SampleMaskView extends FrameLayout {
    public SampleMaskView(Context context) {
        super(context);
        init();
    }

    public SampleMaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    View mask_container;
    View scanLine,camera;
    CheckBox torch;

    void init(){
        View inflate = View.inflate(getContext(), R.layout.sample_mask_layout, this);
        scanLine = inflate.findViewById(R.id.scan_line);
        mask_container = inflate.findViewById(R.id.mask_container);
        torch = (CheckBox) inflate.findViewById(R.id.iv_torch);
        camera = inflate.findViewById(R.id.iv_camera);

        torch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("fewfe","getTop:torch");
            }
        });

        camera.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("fewfe","getTop:camera");
            }
        });
    }

    void playAnimation(){
        TranslateAnimation animation = new TranslateAnimation(0,0,-10,mask_container.getHeight()+10);
        animation.setRepeatMode(Animation.RESTART);
        animation.setDuration(2000);
        animation.setRepeatCount(-1);
        animation.setInterpolator(new DecelerateInterpolator());
//        animation.start();
        scanLine.startAnimation(animation);

    }

    public void startScanAnimation(){
        scanLine.post(new Runnable() {
            @Override
            public void run() {
                playAnimation();
                Log.d("fewfe","getTop:"+mask_container.getTop());
                Log.d("fewfe","getLeft:"+mask_container.getLeft());
                Log.d("fewfe","getBottom:"+mask_container.getBottom());
                Log.d("fewfe","getWidth:"+mask_container.getWidth());
                Log.d("fewfe","getHeight:"+mask_container.getHeight());
            }
        });

    }
}
