package com.ppsweet.friend.dao;

import com.ppsweet.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend,String> {

    public Friend findByUseridAndFriendid(String userid,String friendid);

    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid=? AND friendid=?",nativeQuery = true)
    public void updateIsLike(String islike,String userid,String friendid);

    @Modifying
    @Query(value = "DELETE  FROM  tb_friend  WHERE userid=? AND friendid=?",nativeQuery = true)
    void deletefriend(String userId, String friendid);
}
