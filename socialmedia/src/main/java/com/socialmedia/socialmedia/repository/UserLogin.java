package com.socialmedia.socialmedia.repository;

import com.hm.socialmedia.tables.pojos.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserLogin {
    private final DSLContext dslContext;

    public UserLogin (DSLContext dslContext){
        this.dslContext = dslContext;
    }

    private com.hm.socialmedia.tables.User user = com.hm.socialmedia.tables.User.USER;
    public User findUserByUserName(String userAccount){

        return  dslContext.select()
                .from(user)
                .where(user.ACCOUNT.eq(userAccount))
                .fetchOneInto(User.class);

    }
}
