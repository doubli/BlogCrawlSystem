package com.xiyou.BCS.dao;

import com.xiyou.BCS.model.User;

public interface UserDAO {
	 
    /**
     * 
     * @param user
     * @return
     */
    public int insertUser(User user);
}
