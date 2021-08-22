package cluster.manager.srs.service;

import cluster.manager.srs.dao.UserDAO;
import cluster.manager.srs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/8/22 15:22
 * @Created by xjl
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User login(User user) {
        User userDB = userDAO.login(user);
        if (userDB != null) {
            return userDB;
        }
        throw new RuntimeException("认证失败");
    }
}
