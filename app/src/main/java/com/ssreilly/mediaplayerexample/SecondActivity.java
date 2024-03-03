package com.ssreilly.mediaplayerexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView trackNameViewMain, artistNameViewMain, albumNameViewMain;
    private ImageView nowPlayingViewCoverMain;
    private ImageButton playButtonMain;

    private ImageButton loopButtonMain, stopButtonMain;
    private ImageButton previousButtonMain, nextButtonMain, settingsButtonMain;

    ArrayList<Songs> playList = new ArrayList<>();
    int currentSongIndex;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        currentSongIndex = 0;

        Songs neverGonna = new Songs("Never Gonna Give U Up", "nevergonnagiveuup","Whenever You Need Somebody","ralbum",  "Rick Astley");
        Songs africa = new Songs("Africa", "africa", "Toto IV", "totoiv" , "Toto");
        Songs amethystRockstar = new Songs("Amethyst Rockstar", "amethystrockstar","Summer Knights","summerk", "Joey Badass");
        Songs outtaMyMind = new Songs("OUTTA MY MIND", "outtamymind", "Tradition", "monsuneouttamymindcover" , "Monsune");
        Songs rosanna = new Songs("Rosanna", "rosannatoto", "Toto IV", "totoiv" , "Toto");
        Songs priceOnMyHead = new Songs("Price On My Head", "priceonmyheadnavtheweekend", "Bad Habits", "priceonmyhead", "NAV, The Weekend");

        playList.add(neverGonna);
        playList.add(africa);
        playList.add(amethystRockstar);
        playList.add(outtaMyMind);
        playList.add(rosanna);
        playList.add(priceOnMyHead);

        mediaPlayer = MediaPlayer.create(this,
                getResources()
                        .getIdentifier(playList.get(currentSongIndex)
                                .getLink(), "raw", "com.ssreilly.mediaplayerexample"));

        nowPlayingViewCoverMain = findViewById(R.id.nowPlayingCoverView);
        Glide.with(this).load(R.drawable.ralbum).into(nowPlayingViewCoverMain);

        trackNameViewMain = findViewById(R.id.trackNameView);
        trackNameViewMain.setText(playList.get(currentSongIndex).getTitle());

        artistNameViewMain = findViewById(R.id.artistNameView);
        artistNameViewMain.setText(playList.get(currentSongIndex).getArtist());

        albumNameViewMain = findViewById(R.id.albumNameView);
        albumNameViewMain.setText(playList.get(currentSongIndex).getAlbumName());

        playButtonMain = findViewById(R.id.playButton);
        Glide.with(this).asGif().load(R.drawable.playbutton).into(playButtonMain);


        stopButtonMain = findViewById(R.id.stopButton);
        Glide.with(this).asGif().load(R.drawable.stopbutton).into(stopButtonMain);

        loopButtonMain = findViewById(R.id.loopButton);
        Glide.with(this).asGif().load(R.drawable.looponbuttoff).into(loopButtonMain);

        previousButtonMain = findViewById(R.id.previousButton);
        Glide.with(this).asGif().load(R.drawable.previousbutton).into(previousButtonMain);

        nextButtonMain = findViewById(R.id.nextButton);
        Glide.with(this).asGif().load(R.drawable.nextbutton).into(nextButtonMain);

        settingsButtonMain = findViewById(R.id.settingButton);
        Glide.with(this).asGif().load(R.drawable.settingbutton).into(settingsButtonMain);

        playButtonMain.setOnClickListener(this);
        stopButtonMain.setOnClickListener(this);
        loopButtonMain.setOnClickListener(this);
        previousButtonMain.setOnClickListener(this);
        nextButtonMain.setOnClickListener(this);
        settingsButtonMain.setOnClickListener(this);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Cuando la canción actual ha terminado, reproduces la siguiente
                playNextSong();
            }
        });
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playButton) {
            if (mediaPlayer!=null) {
                if (!mediaPlayer.isPlaying()) {
                    Glide.with(this).asGif().load(R.drawable.pausebutton).into(playButtonMain);
                    mediaPlayer.start();

                } else if (mediaPlayer.isPlaying()) {
                    Glide.with(this).asGif().load(R.drawable.playbutton).into(playButtonMain);
                    mediaPlayer.pause();

                }
            } else {
                Glide.with(this).asGif().load(R.drawable.pausebutton).into(playButtonMain);
                playCurrentSong();
            }

        } else if (v.getId() == R.id.stopButton) {
            if (mediaPlayer != null){
                Glide.with(this).asGif().load(R.drawable.playbutton).into(playButtonMain);
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }



        } else if (v.getId() == R.id.previousButton) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            currentSongIndex = (currentSongIndex - 1 + playList.size()) % playList.size();
            Glide.with(this)
                    .load(getResources()
                            .getIdentifier(playList.get(currentSongIndex)
                                    .getAlbumCoverLink(), "drawable", "com.ssreilly.mediaplayerexample"))
                    .into(nowPlayingViewCoverMain);
            trackNameViewMain.setText(playList.get(currentSongIndex).getTitle());
            artistNameViewMain.setText(playList.get(currentSongIndex).getArtist());
            albumNameViewMain.setText(playList.get(currentSongIndex).getAlbumName());

            Glide.with(this).asGif().load(R.drawable.pausebutton).into(playButtonMain);

            playCurrentSong();


        } else if (v.getId() == R.id.nextButton) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            currentSongIndex = (currentSongIndex + 1) % playList.size();
            Glide.with(this)
                    .load(getResources()
                            .getIdentifier(playList.get(currentSongIndex)
                                    .getAlbumCoverLink(), "drawable", "com.ssreilly.mediaplayerexample"))
                    .into(nowPlayingViewCoverMain);
            trackNameViewMain.setText(playList.get(currentSongIndex).getTitle());
            artistNameViewMain.setText(playList.get(currentSongIndex).getArtist());
            albumNameViewMain.setText(playList.get(currentSongIndex).getAlbumName());

            Glide.with(this).asGif().load(R.drawable.pausebutton).into(playButtonMain);

            playCurrentSong();


        } else if (v.getId() == R.id.loopButton){
            if (mediaPlayer.isLooping()) {
                mediaPlayer.setLooping(false);
                Glide.with(this).asGif().load(R.drawable.looponbuttoff).into(loopButtonMain);

            } else {
                mediaPlayer.setLooping(true);
                Glide.with(this).asGif().load(R.drawable.looponbuttonon).into(loopButtonMain);
            }
        } else if (v.getId() == R.id.settingButton){
            Intent goToThirdIntent = new Intent(this, ThirdActivity.class);
            startActivity(goToThirdIntent);
        }
    }

    private void playCurrentSong(){
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(this,
                getResources().getIdentifier(playList.get(currentSongIndex)
                        .getLink(), "raw", "com.ssreilly.mediaplayerexample"));
        mediaPlayer.start();
    }

    private void playNextSong(){
        // Incrementar el índice de la canción actual
        if (!mediaPlayer.isLooping()) {
            currentSongIndex = (currentSongIndex + 1) % playList.size();

            // Actualizar la interfaz con la información de la nueva canción
            Glide.with(this)
                    .load(getResources()
                            .getIdentifier(playList.get(currentSongIndex)
                                    .getAlbumCoverLink(), "drawable", "com.ssreilly.mediaplayerexample"))
                    .into(nowPlayingViewCoverMain);
            trackNameViewMain.setText(playList.get(currentSongIndex).getTitle());
            artistNameViewMain.setText(playList.get(currentSongIndex).getArtist());
            albumNameViewMain.setText(playList.get(currentSongIndex).getAlbumName());

            // Reproducir la nueva canción
            playCurrentSong();
        } else {

        }
    }
}
