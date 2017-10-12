package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;
    int mStoryID;
    int mStory;
    int mAnswer1;
    int mAnswer2;

    private StoryMap[] mStoryMap = new StoryMap[] {
        new StoryMap(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
        new StoryMap(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
        new StoryMap(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
        new StoryMap(R.string.T4_End, 0,0),
        new StoryMap(R.string.T5_End, 0,0),
        new StoryMap(R.string.T6_End, 0,0),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        mStory = mStoryMap[mStoryID].getStoryID();
        mAnswer1 = mStoryMap[mStoryID].getAnswer1ID();
        mAnswer2 = mStoryMap[mStoryID].getAnswer2ID();
        mStoryTextView.setText(mStory);
        mTopButton.setText(mAnswer1);
        mBottomButton.setText(mAnswer2);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Top pressed", Toast.LENGTH_SHORT).show();
                updateStory(1);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Bottom pressed", Toast.LENGTH_SHORT).show();
                updateStory(2);
            }
        });

    }

    public void updateStory(int userAnswer) {

        if (mStoryID >= 3) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("THE END");
            alert.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        if (mStoryID == 0) {
            if (userAnswer == 1) {
                mStoryID = 2;
            } else {
                mStoryID = 1;
            }
        } else if (mStoryID == 1) {
            if (userAnswer == 1) {
                mStoryID = 2;
            } else {
                mStoryID = 3;
            }
        } else if (mStoryID == 2) {
            if (userAnswer == 1) {
                mStoryID = 5;
            } else {
                mStoryID = 4;
            }
        }

        Log.println(Log.INFO, "Story", "StoryID: "+ Integer.toString(mStoryID) );

        mStory = mStoryMap[mStoryID].getStoryID();
        mStoryTextView.setText(mStory);

        if (mStoryID < 3) {
            mAnswer1 = mStoryMap[mStoryID].getAnswer1ID();
            mAnswer2 = mStoryMap[mStoryID].getAnswer2ID();
            mTopButton.setText(mAnswer1);
            mBottomButton.setText(mAnswer2);
        } else {
            mTopButton.setText("THE END");
            mBottomButton.setText("");
        }

    }
}
