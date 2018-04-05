package com.example.durma.mvpudemy.login;

/**
 * Created by durma on 9.3.18..
 */

public interface LoginRepository {

        User getUser();

        void saveUser(User user);

}
