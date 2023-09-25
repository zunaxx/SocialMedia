import java.time.LocalDate;
import java.util.Arrays;

public class Profile {
    private static int nextProfileId = 1;
    private int profileId;
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private Post[] posts;

    public Profile(String fullName, LocalDate dateOfBirth, String gender, Post[] posts) {
        this.profileId = nextProfileId++;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.posts = posts;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + profileId +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", posts=" + Arrays.toString(posts) +
                '}';
    }
}
