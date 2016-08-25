package dominando.android.multimidia;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;
import java.util.ArrayList;

public class CameraVideoFragment extends Fragment implements
        View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    Uri mVideoUri;
    VideoView mVideoView;
    int mPosicao;
    boolean mExecutando;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        String caminhoVideo = Util.getUltimaMidia(getActivity(), Util.MIDIA_VIDEO);
        if (caminhoVideo != null) {
            mVideoUri = Uri.parse(caminhoVideo);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(
                R.layout.fragment_camera_video, container, false);
        layout.findViewById(R.id.btnVideo).setOnClickListener(this);
        layout.getViewTreeObserver().addOnGlobalLayoutListener(this);
        mVideoView = (VideoView) layout.findViewById(R.id.videoView);
        mVideoView.setMediaController(new MediaController(getActivity()));
        return layout;
    }
    @Override
    public void onDestroyView() {
        mExecutando = mVideoView.isPlaying();
        mPosicao = mVideoView.getCurrentPosition();
        if (mPosicao == mVideoView.getDuration()) {
            mPosicao = 0;
        }
        super.onDestroyView();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Util.REQUESTCODE_VIDEO
                && resultCode == Activity.RESULT_OK) {
            mVideoUri = data.getData();
            carregarVideo();
        }
    }
    @Override
    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            getView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        carregarVideo();
    }
    @Override
    public void onClick(View view) {
        ArrayList<String> permissions = new ArrayList<>();
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED){
            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.RECORD_AUDIO) !=
                PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.RECORD_AUDIO);
        }
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.CAMERA);
        }

        if (permissions.isEmpty()){
            abrirCamera();
        } else {
            String[] permissoesPraRequisitar = new String[permissions.size()];
            permissions.toArray(permissoesPraRequisitar);
            ActivityCompat.requestPermissions(getActivity(),
                    permissoesPraRequisitar,
                    0);
        }
    }

    private void abrirCamera(){
        File caminhoVideo = Util.novaMidia(Util.MIDIA_VIDEO);
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        takeVideoIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(caminhoVideo));
        if (takeVideoIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, Util.REQUESTCODE_VIDEO);
        }
    }

    private void carregarVideo() {
        if (mVideoUri != null) {
            mVideoView.setVideoURI(mVideoUri);
            mVideoView.seekTo(mPosicao);
            if (mExecutando) {
                mVideoView.start();
            }
            Util.salvarUltimaMidia(getActivity(), Util.MIDIA_VIDEO,
                    mVideoUri.toString());
        }
    }
}

