package cn.smbms.service.user;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.tools.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 *
 * @author Administrator
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean add(User user) {
        boolean flag = false;

        try {
            int updateRows = userMapper.add(user);

            if (updateRows > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("rollback==================");
            throw e;

        }
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)
    public User login(String userCode, String userPassword) {

        User user = null;
        try {
            user = userMapper.getLoginUser(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //匹配密码
        if (null != user) {
            if (!user.getUserPassword().equals(userPassword))
                user = null;
        }

        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {

        List<User> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            userList = userMapper
                    .getUserList(queryUserName, queryUserRole, (currentPageNo-1)*pageSize, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)
    public User selectUserCodeExist(String userCode) {

        User user = null;
        try {
            user = userMapper.getLoginUser(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteUserById(Integer delId) {

        boolean flag = false;
        try {
            if (userMapper.deleteUserById(delId) > 0)
                flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)
    public User getUserById(Integer id) {
        User user = null;

        try {
            user = userMapper.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            user = null;
        }
        return user;
    }

    @Override
    public boolean modify(User user) {

        boolean flag = false;
        try {
            if (userMapper.modify(user) > 0)
                flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
        return flag;
    }

    @Override
    public boolean updatePwd(int id, String pwd) {
        boolean flag = false;

        try {
            if (userMapper.updatePwd(id, pwd) > 0)
                flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true,isolation = Isolation.READ_COMMITTED)
    public int getUserCount(String queryUserName, int queryUserRole) {

        int count = 0;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        try {
            count = userMapper.getUserCount(queryUserName, queryUserRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

}
