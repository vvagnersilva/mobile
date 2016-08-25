package dominando.android.multimidia;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageButton;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GravarAudioFragment extends Fragment
        implements View.OnClickListener {
    ImageButton mBtnGravar;
    ImageButton mBtnPlay;
    Chronometer mChronometer;
    MediaRecorder mMediaRecorder;
    MediaPlayer mMediaPlayer;
    File mCaminhoAudio;
    boolean mGravando;
    boolean mTocando;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        String caminhoAudio = Util.getUltimaMidia(getActivity(), Util.MIDIA_AUDIO);
        if (caminhoAudio != null) {
            mCaminhoAudio = new File(caminhoAudio);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gravar_audio, container, false);
        mBtnGravar = (ImageButton) view.findViewById(R.id.btnGravar);
        mBtnPlay = (ImageButton) view.findViewById(R.id.btnPlay);
        mChronometer = (Chronometer) view.findViewById(R.id.chronometer);
        mBtnGravar.setOnClickListener(this);
        mBtnPlay.setOnClickListener(this);
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        pararDeGravar();
        pararDeTocar();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGravar:
                btnGravarClick();
                break;
            case R.id.btnPlay:
                btnPlayClick();
                break;
        }
    }
    private void btnPlayClick() {
        mChronometer.stop();
        if (mTocando) {
            pararDeTocar();
        } else if (mCaminhoAudio != null && mCaminhoAudio.exists()) {
            if (ActivityCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE },
                        0);

            } else {
                try {
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setDataSource(mCaminhoAudio.getAbsolutePath());
                    mMediaPlayer.setOnCompletionListener(
                            new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    mTocando = false;
                                    mChronometer.stop();
                                    atualizarBotoes();
                                }
                            });
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                    mChronometer.start();
                    mTocando = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        atualizarBotoes();
    }
    private void btnGravarClick() {
        mChronometer.stop();
        if (mGravando) {
            pararDeGravar();
        } else {
            ArrayList<String> permissions = new ArrayList<>();
            if (ActivityCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (ActivityCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.RECORD_AUDIO) !=
                    PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.RECORD_AUDIO);
            }
            if (permissions.isEmpty()){
                mCaminhoAudio = Util.novaMidia(Util.MIDIA_AUDIO);
                mMediaRecorder = new MediaRecorder();
                mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mMediaRecorder.setOutputFile(mCaminhoAudio.getAbsolutePath());
                mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                try {
                    mMediaRecorder.prepare();
                    mMediaRecorder.start();
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                    mChronometer.start();
                    mGravando = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                String[] permissoesPraRequisitar = new String[permissions.size()];
                permissions.toArray(permissoesPraRequisitar);
                ActivityCompat.requestPermissions(getActivity(),
                        permissoesPraRequisitar,
                        0);
            }
        }
        atualizarBotoes();
    }
    private void atualizarBotoes() {
        mBtnGravar.setImageResource(mGravando ?
                android.R.drawable.ic_media_pause :
                android.R.drawable.ic_btn_speak_now);
        mBtnGravar.setEnabled(!mTocando);
        mBtnPlay.setImageResource(mTocando ?
                android.R.drawable.ic_media_pause :
                android.R.drawable.ic_media_play);
        mBtnPlay.setEnabled(!mGravando);
    }
    private void pararDeTocar() {
        if (mMediaPlayer != null && mTocando) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mTocando = false;
        }
    }
    private void pararDeGravar() {
        if (mMediaRecorder != null && mGravando) {
            mMediaRecorder.stop();
            mMediaRecorder.release();
            mMediaRecorder = null;
            mGravando = false;
            Util.salvarUltimaMidia(getActivity(),
                    Util.MIDIA_AUDIO, mCaminhoAudio.getAbsolutePath());
        }
    }
}
