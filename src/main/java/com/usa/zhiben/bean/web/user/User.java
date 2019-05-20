package com.usa.zhiben.bean.web.user;

import java.util.Date;

public class User {
    /**
     *
     */
    private Integer id;

    /**
     * 登录账户名称
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPassword;

    /**
     * shiro登录验证的 盐值
     */
    private String loginSalt;

    /**
     * 警员编号
     */
    private String userId;

    /**
     * 中文就只存这个
     */
    private String fristName;

    /**
     *
     */
    private String lastName;

    /**
     * 生日 年月 日
     */
    private Date userBirthday;

    /**
     * 宣誓就职日期
     */
    private Date swornDate;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 职位名称 无其他关联
     */
    private String userRole;

    /**
     * 部门编号
     */
    private Integer divisionId;

    /**
     * 用户状态：1有效;  0 禁止登录
     */
    private Integer userStatus;

    /**
     * 执法仪密码
     */
    private String devicePassword;

    /**
     * 性别 0 女 1 男
     */
    private Integer userSex;

    /**
     * 电话号码
     */
    private String userPhone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 用户登陆IP
     */
    private String uesrIp;

    /**
     * 是否固定ip, 0 :固定  1：不固定
     */
    private Integer ipStatus;

    /**
     *
     */
    public String getCredentialsSalt() {
        return loginName + loginSalt;

    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 登录账户名称
     *
     * @return login_name 登录账户名称
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录账户名称
     *
     * @param loginName 登录账户名称
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 登录密码
     *
     * @return login_password 登录密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 登录密码
     *
     * @param loginPassword 登录密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /**
     * shiro登录验证的 盐值
     *
     * @return login_salt shiro登录验证的 盐值
     */
    public String getLoginSalt() {
        return loginSalt;
    }

    /**
     * shiro登录验证的 盐值
     *
     * @param loginSalt shiro登录验证的 盐值
     */
    public void setLoginSalt(String loginSalt) {
        this.loginSalt = loginSalt == null ? null : loginSalt.trim();
    }

    /**
     * 警员编号
     *
     * @return user_id 警员编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 警员编号
     *
     * @param userId 警员编号
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 中文就只存这个
     *
     * @return frist_name 中文就只存这个
     */
    public String getFristName() {
        return fristName;
    }

    /**
     * 中文就只存这个
     *
     * @param fristName 中文就只存这个
     */
    public void setFristName(String fristName) {
        this.fristName = fristName == null ? null : fristName.trim();
    }

    /**
     * @return last_name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * 生日 年月 日
     *
     * @return user_birthday 生日 年月 日
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * 生日 年月 日
     *
     * @param userBirthday 生日 年月 日
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 宣誓就职日期
     *
     * @return sworn_date 宣誓就职日期
     */
    public Date getSwornDate() {
        return swornDate;
    }

    /**
     * 宣誓就职日期
     *
     * @param swornDate 宣誓就职日期
     */
    public void setSwornDate(Date swornDate) {
        this.swornDate = swornDate;
    }

    /**
     * 邮箱
     *
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 职位名称 无其他关联
     *
     * @return user_role 职位名称 无其他关联
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 职位名称 无其他关联
     *
     * @param userRole 职位名称 无其他关联
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    /**
     * 部门编号
     *
     * @return division_id 部门编号
     */
    public Integer getDivisionId() {
        return divisionId;
    }

    /**
     * 部门编号
     *
     * @param divisionId 部门编号
     */
    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * 用户状态：1有效;  0 禁止登录
     *
     * @return user_status 用户状态：1有效;  0 禁止登录
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 用户状态：1有效;  0 禁止登录
     *
     * @param userStatus 用户状态：1有效;  0 禁止登录
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 执法仪密码
     *
     * @return device_password 执法仪密码
     */
    public String getDevicePassword() {
        return devicePassword;
    }

    /**
     * 执法仪密码
     *
     * @param devicePassword 执法仪密码
     */
    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword == null ? null : devicePassword.trim();
    }

    /**
     * 性别 0 女 1 男
     *
     * @return user_sex 性别 0 女 1 男
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 性别 0 女 1 男
     *
     * @param userSex 性别 0 女 1 男
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * 电话号码
     *
     * @return user_phone 电话号码
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 电话号码
     *
     * @param userPhone 电话号码
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 创建时间
     *
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后登录时间
     *
     * @return last_login_time 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 用户登陆IP
     *
     * @return uesr_ip 用户登陆IP
     */
    public String getUesrIp() {
        return uesrIp;
    }

    /**
     * 用户登陆IP
     *
     * @param uesrIp 用户登陆IP
     */
    public void setUesrIp(String uesrIp) {
        this.uesrIp = uesrIp == null ? null : uesrIp.trim();
    }

    /**
     * 是否固定ip, 0 :固定  1：不固定
     *
     * @return ip_status 是否固定ip, 0 :固定  1：不固定
     */
    public Integer getIpStatus() {
        return ipStatus;
    }

    /**
     * 是否固定ip, 0 :固定  1：不固定
     *
     * @param ipStatus 是否固定ip, 0 :固定  1：不固定
     */
    public void setIpStatus(Integer ipStatus) {
        this.ipStatus = ipStatus;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", loginSalt='" + loginSalt + '\'' +
                ", userId='" + userId + '\'' +
                ", fristName='" + fristName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userBirthday=" + userBirthday +
                ", swornDate=" + swornDate +
                ", email='" + email + '\'' +
                ", userRole='" + userRole + '\'' +
                ", divisionId=" + divisionId +
                ", userStatus=" + userStatus +
                ", devicePassword='" + devicePassword + '\'' +
                ", userSex=" + userSex +
                ", userPhone='" + userPhone + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", uesrIp='" + uesrIp + '\'' +
                ", ipStatus=" + ipStatus +
                '}';
    }
}