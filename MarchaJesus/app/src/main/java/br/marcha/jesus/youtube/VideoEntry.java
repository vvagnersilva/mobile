package br.marcha.jesus.youtube;

import android.os.Parcel;
import android.os.Parcelable;

public final class VideoEntry implements Parcelable {
    private final String videoId;
    private final String text;

    public VideoEntry(String text, String videoId) {
        this.text = text;
        this.videoId = videoId;
    }

    public VideoEntry(Parcel in) {
        this.videoId = in.readString();
        this.text = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(videoId);
        dest.writeString(text);
    }

    public static final Parcelable.Creator<VideoEntry> CREATOR = new Parcelable.Creator<VideoEntry>() {
        @Override
        public VideoEntry createFromParcel(Parcel in) {
            return new VideoEntry(in);
        }

        @Override
        public VideoEntry[] newArray(int size) {
            return new VideoEntry[size];
        }
    };

    public String getText() {
        return text;
    }

    public String getVideoId() {
        return videoId;
    }
}