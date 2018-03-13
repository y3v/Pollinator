package pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yev on 2018-03-11.
 */

public class Poll implements Parcelable {

    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;

    public Poll(String question, String choice1, String choice2, String choice3, String choice4) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeString(choice1);
        parcel.writeString(choice2);
        parcel.writeString(choice3);
        parcel.writeString(choice4);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Poll> CREATOR = new Parcelable.Creator<Poll>() {
        public Poll createFromParcel(Parcel in) {
            return new Poll(in);
        }

        public Poll[] newArray(int size) {
            return new Poll[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Poll(Parcel in) {
        question = in.readString();
        choice1 = in.readString();
        choice2 = in.readString();
        choice3 = in.readString();
        choice4 = in.readString();
    }


    //Getters and setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }
}
