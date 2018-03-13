package pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yev on 2018-03-11.
 */

public class User implements Parcelable {

    private String firstName;
    private String lastName;
    private String email;
    private String choice;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(email);
        parcel.writeString(choice);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private User(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        choice = in.readString();
    }

    public User(String firstName, String lastName, String email, String choice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.choice = choice;
    }

    //GETTERS AND SETTERS

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
