package com.londonappbrewery.destini;

/**
 * Created by Roger on 2017-10-11.
 */

public class StoryMap {

    private int mAnswerIndex;
    private int mStoryID;
    private int mAnswer1ID;
    private int mAnswer2ID;

    public StoryMap(int StoryID, int Answer1ID, int Answer2ID) {
        mStoryID = StoryID;
        mAnswer1ID = Answer1ID;
        mAnswer2ID = Answer2ID;
    }

    public int getStoryID() {
        return mStoryID;
    }

    public void setStoryID(int storyID) {
        mStoryID = storyID;
    }

    public int getAnswer1ID() {
        return mAnswer1ID;
    }

    public void setAnswer1ID(int answer1ID) {
        mAnswer1ID = answer1ID;
    }

    public int getAnswer2ID() {
        return mAnswer2ID;
    }

    public void setAnswer2ID(int answer2ID) {
        mAnswer2ID = answer2ID;
    }
}


