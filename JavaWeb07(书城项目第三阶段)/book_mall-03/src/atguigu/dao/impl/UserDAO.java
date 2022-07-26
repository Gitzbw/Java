package atguigu.dao.impl;


import atguigu.pojo.User;

public class UserDAO extends BasicDAO implements atguigu.dao.UserDAO {

    @Override
    public User queryUserByName(String userName) {
        String sql = "select * from t_user where username = ?";
        return (User) querySingle(sql,User.class,userName);
    }

    @Override
    public User queryUserByNameAndPassword(String userName, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return (User) querySingle(sql,User.class,userName,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user values(null,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
