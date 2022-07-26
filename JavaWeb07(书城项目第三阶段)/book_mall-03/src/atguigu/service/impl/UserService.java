package atguigu.service.impl;


import atguigu.dao.impl.UserDAO;
import atguigu.pojo.User;

public class UserService implements atguigu.service.UserService
{
    UserDAO userDAO = new UserDAO();

    @Override
    public void register(User user) {
            userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String userName) {
        return userDAO.queryUserByName(userName) != null;
    }
}

