package com.ppsweet.friend.service;

import com.ppsweet.friend.pojo.NoFriend;
import com.ppsweet.friend.dao.FriendDao;
import com.ppsweet.friend.dao.NoFriendDao;
import com.ppsweet.friend.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    public int addFriend(String userId, String friendid) {
        //先判断userId到friendId是否有数据，有就是重复添加好友，返回0
       Friend friend= friendDao.findByUseridAndFriendid(userId,friendid);
       if (friend !=null)
       {
           return  0;
       }
        //直接添加好友，让好友表中userId到friendId方向的type为0
        friend=new Friend();
        friend.setUserid(userId);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);
        //判断friendId到userId方向有数据，有就把双方状态改为1
        if (friendDao.findByUseridAndFriendid(friendid,userId) !=null)
        {
          friendDao.updateIsLike("1",userId,friendid);
            friendDao.updateIsLike("1",friendid,userId);
        }
        return 1;
    }

    public int addNoFriend(String userId, String friendid) {

        //先判断是否为非好友
       NoFriend noFriend= noFriendDao.findByUseridAndFriendid(userId,friendid);
       if (noFriend !=null)
       {
           return 0;
       }
       noFriend=new NoFriend();
       noFriend.setUserid(userId);
       noFriend.setFriendid(friendid);
       noFriendDao.save(noFriend);
        return 1;
    }

    public void deleteFriend(String userId, String friendid) {

        //删除好友表中userId到friendId的数据
        friendDao.deletefriend(userId,friendid);
        //更新friendId到userId方向的type为0
        friendDao.updateIsLike("0",friendid,userId);
        //向非好友表中添加一条记录
        NoFriend noFriend=new NoFriend();
        noFriend.setUserid(userId);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
    }
}
