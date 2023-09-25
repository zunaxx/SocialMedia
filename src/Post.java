import java.time.LocalDate;

public class Post {
    private static int nextPostId = 1;
    private int postId;
    private String image;
    private String description;
    private LocalDate created;
    private Comment firstComment;

    public Post(String image, String description, LocalDate created, Comment firstComment) {
        this.postId = nextPostId++;
        this.image = image;
        this.description = description;
        this.created = created;
        this.firstComment = firstComment;
    }

    public int getPostId() {
        return postId;
    }

    public String getImage() {
        return image;
    }

    public Comment getFirstComment() {
        return firstComment;
    }

    public void setFirstComment(Comment firstComment) {
        this.firstComment = firstComment;
    }

    public void addComment(Comment newComment) {
        if (firstComment == null) {
            firstComment = newComment;
        } else {
            Comment currentComment = firstComment;
            while (currentComment.getNextComment() != null) {
                currentComment = currentComment.getNextComment();
            }
            currentComment.setNextComment(newComment);
        }
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", firstComment=" + firstComment +
                '}';
    }
}
