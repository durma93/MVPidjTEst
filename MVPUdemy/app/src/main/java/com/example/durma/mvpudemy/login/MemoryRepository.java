package com.example.durma.mvpudemy.login;

/**
 * Created by durma on 9.3.18..
 */

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {

        if (user == null){
            User user = new User("Fox","Naruto");
            user.setId(0);
            return user;
        } else {

            return user;
        }


    }

    @Override
    public void saveUser(User user) {

        if (user == null){
            user = getUser();
        }

        this.user = user;
    }
}
