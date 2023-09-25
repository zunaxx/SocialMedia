public class Database {
    private User[] users;
    private Profile[] profiles;
    private Comment[] comments;
    private Post[] posts;

    public Database(int maxUsers, int maxProfiles, int maxComments, int maxPosts) {
        users = new User[maxUsers];
        profiles = new Profile[maxProfiles];
        comments = new Comment[maxComments];
        posts = new Post[maxPosts];
    }

    public void saveUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return; // Пользователь добавлен, выходим из цикла
            }
        }
        System.out.println("Database is full. Cannot add user.");
    }
    public Profile findProfileByUserId(int userId) {
        for (User user : users) {
            if (user != null && user.getUserId() == userId) {
                return user.getProfile(); // Вернуть профиль пользователя с указанным ID
            }
        }
        return null;
    }

    public String deleteProfileByUserId(int userId) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getUserId() == userId) {
                users[i].setProfile(null); // Удалить профиль пользователя с указанным ID
                return "Profile deleted for User with ID " + userId;
            }
        }
        return "User with ID " + userId + " not found or doesn't have a profile.";
    }



    public User findUserById(int id) {
        for (User user : users) {
            if (user != null && user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }
    public User[] deleteUser2(int userId) {
        // Create a new array with a size one less than the original array
        User[] updatedUsers = new User[users.length - 1];

        int index = 0; // Index for the new array

        for (User user : users) {
            if (user != null && user.getUserId() == userId) {
                // Skip the user to be deleted
                continue;
            }

            // Copy the user to the updated array
            updatedUsers[index++] = user;
        }

        // Set the users array to the updated array
        users = updatedUsers;

        return users; // Return the updated array
    }

    public String saveProfileByUserId(int userId, Profile profile) {
        for (User user : users) {
            if (user != null && user.getUserId() == userId) {
                // Associate the profile with the user
                user.setProfile(profile);
                return "Profile saved for User with ID " + userId;
            }
        }
        return "User with ID " + userId + " not found.";
    }


    public String savePost(int userId, Post post) {
        for (User user : users) {
            if (user != null && user.getUserId() == userId) {
                // Add the post to the user's profile
                Profile userProfile = user.getProfile();
                if (userProfile != null) {
                    // Get the user's existing posts
                    Post[] userPosts = userProfile.getPosts();

                    // Calculate the new size for the posts array
                    int newSize = (userPosts != null) ? userPosts.length + 1 : 1;

                    // Create a new array with the new size
                    Post[] newPosts = new Post[newSize];

                    // Copy existing posts, if any
                    if (userPosts != null) {
                        System.arraycopy(userPosts, 0, newPosts, 0, userPosts.length);
                    }

                    // Add the new post to the end of the array
                    newPosts[newSize - 1] = post;

                    // Set the updated posts array back to the user's profile
                    userProfile.setPosts(newPosts);
                    return "Post saved for User with ID " + userId;
                } else {
                    return "User with ID " + userId + " does not have a profile.";
                }
            }
        }
        return "User with ID " + userId + " not found.";
    }

    public void getPostByUserId(int userId) {
        for (User user : users) {
            if (user != null && user.getUserId() == userId) {
                // Get the user's profile
                Profile userProfile = user.getProfile();
                if (userProfile != null) {
                    // Get the user's posts
                    Post[] userPosts = userProfile.getPosts();
                    if (userPosts != null) {
                        System.out.println("Posts by User with ID " + userId + ":");
                        for (Post post : userPosts) {
                            System.out.println(post);
                        }
                    } else {
                        System.out.println("User with ID " + userId + " has no posts.");
                    }
                } else {
                    System.out.println("User with ID " + userId + " does not have a profile.");
                }
                return; // Found the user, no need to continue searching
            }
        }
        System.out.println("User with ID " + userId + " not found.");
    }

    public User[] getAllUsers() {
        int userCount = 0;
        for (User user : users) {
            if (user != null) {
                userCount++;
            }
        }
        User[] userList = new User[userCount];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                userList[index++] = user;
            }
        }
        return userList;
    }

    public Profile[] getAllProfiles() {
        int profileCount = 0;
        for (Profile profile : profiles) {
            if (profile != null) {
                profileCount++;
            }
        }
        Profile[] profileList = new Profile[profileCount];
        int index = 0;
        for (Profile profile : profiles) {
            if (profile != null) {
                profileList[index++] = profile;
            }
        }
        return profileList;
    }

    public Comment[] getAllComments() {
        int commentCount = 0;
        for (Comment comment : comments) {
            if (comment != null) {
                commentCount++;
            }
        }
        Comment[] commentList = new Comment[commentCount];
        int index = 0;
        for (Comment comment : comments) {
            if (comment != null) {
                commentList[index++] = comment;
            }
        }
        return commentList;
    }

    public Post getPostById(int postId) {
        for (Post post : posts) {
            if (post != null && post.getPostId() == postId) {
                return post;
            }
        }
        return null; // Post with the specified ID not found
    }

    public User getUserById(int userId) {
        for (User user : users) {
            if (user != null && user.getUserId() == userId) {
                return user;
            }
        }
        return null; // User with the specified ID not found
    }


    public Profile getProfileById(int profileId) {
        for (Profile profile : profiles) {
            if (profile != null && profile.getProfileId() == profileId) {
                return profile;
            }
        }
        return null; // Profile with the specified ID not found
    }

    public Comment getCommentById(int commentId) {
        for (Comment comment : comments) {
            if (comment != null && comment.getCommentId() == commentId) {
                return comment;
            }
        }
        return null; // Comment with the specified ID not found
    }


    public void addCommentToPost(int postIdToAddComment, Comment newComment) {
    }
}