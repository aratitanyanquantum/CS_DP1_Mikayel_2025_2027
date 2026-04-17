package lesson_2026_04_17.homework;
class Comment{
    private String comment;
    private User author;
    public Comment(String comment, User author){
        setComment(comment);
        setAuthor(author);
    }
    public void setComment(String com){
        comment = com;
    }
    public void setAuthor(User aut){
        author = aut;
    }
    public String getComment(){
        return comment;
    }
    public User getAuthor(){
        return author;
    }
}


class Post{
    private Comment[] comments;
    private int likeCount;
    public Post(){}
    public void setLikeCount(int count){
        likeCount = count;
    }
    public int getLikeCount(){
        return likeCount;
    }
    public void setComments(Comment[] arr){
        comments = arr;
    }
    public Comment[] getComments(){
        return comments;
    }
    public void newComment(Comment comment, User user){
        Comment[] comments1 = new Comment[comments.length+1];
        for(int i = 0; i < comments.length; i++){
            comments1[i] = comments[i];
        }
        comments1[comments1.length-1] = comment;
        comments = comments1;

    }

    public void newlike(){
        likeCount++;
    }
}


class User{
    private String Username;
    private String displayName;
    private String profilePicture;
    private Post[] posts;


    public User(String username, String displayName, String profilePicture){
        this.Username = username;
        this.displayName = displayName;
        this.profilePicture = profilePicture;
    }


    public void newTextMessage(){
    }

    public void newPictureMessage(){
    }

    public void newVideoMessage(){
    }

    public int getPostsCount(){
        return posts.length;
    }

    public Post getPost(int num){
        return posts[num];
    }

    public void newComment(int num, String comment, User user){

    }

    public void newLike(int num){

    }
}


class TextMessage extends Post{
    private String message;
    public TextMessage(String message){
        setMessage(message);
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

}


class PictureMessage extends Post{
    private String pictureURL;
    public PictureMessage(String message){
        setPictureURL(pictureURL);
    }
    public void setPictureURL(String pictureURL){
        this.pictureURL = pictureURL;
    }
    public String getPictureURL(){
        return pictureURL;
    }
}

class VideoMessage extends Post{
    private String youtubeLink;
    public VideoMessage(String message){
        setYoutubeLink(message);
    }
    public void setYoutubeLink(String youtubeLink){
        this.youtubeLink = youtubeLink;
    }
    public String getYoutubeLink(){
        return youtubeLink;
    }
}

public class socialmedia {
}
