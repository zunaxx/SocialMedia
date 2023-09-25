import java.time.LocalDate;

import java.util.Scanner;

public class Main {
    private static int userIdCounter = 1;
    private static int profileIdCounter = 1;
    private static int postIdCounter = 1;
    private static int commentIdCounter = 1;

    public static void main(String[] args) {
        Database database = new Database(100, 100, 100, 100);
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Add User");
            System.out.println("2. Add Profile");
            System.out.println("3. Save Profile by User ID");
            System.out.println("4. Delete Profile by User ID");
            System.out.println("5. Get Post by User ID");
            System.out.println("6. Add Comment to Post");
            System.out.println("7. Get All Users");
            System.out.println("8. Get All Profiles");
            System.out.println("9. Get All Comments");
            System.out.println("10. Get Post by ID");
            System.out.println("11. Get User by ID");
            System.out.println("12. Get Profile by ID");
            System.out.println("13. Get Comment by ID");
            System.out.println("14. Exit");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter password:");
                    int password;
                    try {
                        password = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for password. Please enter a number.");
                        continue;
                    }

                    User newUser = new User(username, email, password, null);
                    newUser.setUserId(userIdCounter++);
                    database.saveUser(newUser);
                    break;

                case 2:
                    System.out.println("Enter full name:");
                    String fullName = scanner.nextLine();
                    System.out.println("Enter date of birth (yyyy-MM-dd):");
                    String dobString = scanner.nextLine();
                    LocalDate dateOfBirth;
                    try {
                        dateOfBirth = LocalDate.parse(dobString);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
                        continue;
                    }
                    System.out.println("Enter gender:");
                    String gender = scanner.nextLine();

                    Profile newProfile = new Profile(fullName, dateOfBirth, gender, null);


                    int userIdForProfile = userIdCounter++;
                    newProfile.setProfileId(profileIdCounter++);

                    String saveProfileResult = database.saveProfileByUserId(userIdForProfile, newProfile);
                    System.out.println(saveProfileResult);
                    break;

                case 3:
                    System.out.println("Enter User ID:");
                    int userIdToUpdate;
                    try {
                        userIdToUpdate = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for User ID. Please enter a number.");
                        continue;
                    }
                    System.out.println("Enter updated full name:");
                    String updatedFullName = scanner.nextLine();

                    Profile updatedProfile = new Profile(updatedFullName, null, null, null);
                    updatedProfile.setProfileId(profileIdCounter++);
                    String saveUpdatedProfileResult = database.saveProfileByUserId(userIdToUpdate, updatedProfile);
                    System.out.println(saveUpdatedProfileResult);
                    break;

                case 4:
                    System.out.println("Enter User ID to delete:");
                    int userIdToDelete;
                    try {
                        userIdToDelete = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for User ID. Please enter a number.");
                        continue;
                    }
                    String deleteProfileResult = database.deleteProfileByUserId(userIdToDelete);
                    System.out.println(deleteProfileResult);
                    break;

                case 5:
                    System.out.println("Enter User ID to get posts:");
                    int userIdToGetPosts;
                    try {
                        userIdToGetPosts = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for User ID. Please enter a number.");
                        continue;
                    }
                    database.getPostByUserId(userIdToGetPosts);
                    break;

                case 6:
                    System.out.println("Enter Post ID to add a comment:");
                    int postIdToAddComment;
                    try {
                        postIdToAddComment = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for Post ID. Please enter a number.");
                        continue;
                    }

                    System.out.println("Enter comment text:");
                    String commentText = scanner.nextLine();
                    LocalDate commentDate = LocalDate.now();

                    Comment newComment = new Comment(commentText, commentDate);
                    newComment.setCommentId(commentIdCounter++);
                    database.addCommentToPost(postIdToAddComment, newComment);
                    break;

                // Inside the switch cases for retrieving all users, profiles, and comments
                case 7:
                    User[] allUsers = database.getAllUsers();
                    for (User user : allUsers) {
                        if (user != null) {
                            System.out.println(user.toString());
                        }
                    }
                    break;

                case 8:
                    Profile[] allProfiles = database.getAllProfiles();
                    for (Profile profile : allProfiles) {
                        if (profile != null) {
                            System.out.println(profile.toString());
                        }
                    }
                    break;

                case 9:
                    Comment[] allComments = database.getAllComments();
                    for (Comment comment : allComments) {
                        if (comment != null) {
                            System.out.println(comment.toString());
                        }
                    }
                    break;


                case 10:
                    System.out.println("Enter Post ID:");
                    int postIdToGet;
                    try {
                        postIdToGet = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for Post ID. Please enter a number.");
                        continue;
                    }
                    database.getPostById(postIdToGet);
                    break;

                case 11:
                    System.out.println("Enter User ID:");
                    int userIdToGet;
                    try {
                        userIdToGet = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for User ID. Please enter a number.");
                        continue;
                    }
                    database.getUserById(userIdToGet);
                    break;

                case 12:
                    System.out.println("Enter Profile ID:");
                    int profileIdToGet;
                    try {
                        profileIdToGet = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for Profile ID. Please enter a number.");
                        continue;
                    }
                    database.getProfileById(profileIdToGet);
                    break;

                case 13:
                    System.out.println("Enter Comment ID:");
                    int commentIdToGet;
                    try {
                        commentIdToGet = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for Comment ID. Please enter a number.");
                        continue;
                    }
                    database.getCommentById(commentIdToGet);
                    break;

                case 14:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
}




