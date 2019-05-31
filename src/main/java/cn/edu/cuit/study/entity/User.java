package cn.edu.cuit.study.entity;

/**
 * @date: 2019/5/31
 * @author: Flemming
 * @description: 用户信息实体类
 */
public class User {

    /**
     * 用户ID
     */
    private int userID;

    /**
     * 名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生年月
     */
    private String birth;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 用户的角色
     */
    private int role;

    /**
     * 用户存放的头像
     */
    private String head;




    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Course{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", head='" + head + '\'' +
                '}';
    }
}
