package cluster.manager.srs.dao;

import cluster.manager.srs.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDAO
 * @Description TODO
 * @Date 2021/8/22 15:27
 * @Created by xjl
 */
@Mapper
@Repository
public interface UserDAO {
    /**
     * @description TODO 用户登入接口
     * @param: user
     * @date: 2021/8/22 15:32
     * @return: cluster.manager.srs.entity.User
     * @author: xjl
     */
    User login(User user);
}
