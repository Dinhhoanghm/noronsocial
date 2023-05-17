package com.socialmedia.socialmedia.repository;

import com.hm.socialmedia.tables.pojos.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class UserSignInRepo {
    private final DSLContext dslContext;

    public UserSignInRepo(DSLContext dslContext) {
        this.dslContext = dslContext;

    }

    private com.hm.socialmedia.tables.User users = com.hm.socialmedia.tables.User.USER;
    public void insertNewUser(User user) {
        dslContext.insertInto(users, users.ACCOUNT, users.EMAIL,
                        users.AVATAR, users.PASSWORD, users.NAME,
                        users.AUTHORITY, users.CREATED_AT)
                .values(user.getAccount(), user.getEmail(),
                        user.getAvatar(), user.getPassword(), user.getName(),
                        user.getAuthority(), LocalDateTime.now())
                .execute();
    }

    public boolean findEmail(String email) {
        return dslContext.select()
                .from(users)
                .where(users.EMAIL.eq(email))
                .execute() == 1;

    }
}
