import java.time.LocalDate;

public class Comment {
    private static int nextCommentId = 1;
    private int commentId;
    private String text;
    private LocalDate commentDate;
    private Comment nextComment; // Reference to the next comment

    public Comment(String text, LocalDate commentDate) {
        this.commentId = nextCommentId++;
        this.text = text;
        this.commentDate = commentDate;
    }

    public static int getNextCommentId() {
        return nextCommentId;
    }

    public static void setNextCommentId(int nextCommentId) {
        Comment.nextCommentId = nextCommentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public Comment getNextComment() {
        return nextComment;
    }

    public void setNextComment(Comment nextComment) {
        this.nextComment = nextComment;}



    public int getCommentId() {
        return commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", text='" + text + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}
