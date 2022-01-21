package com.yavuz.catchthekenny;

public class User {
    public String fullName, age , email , userLevel;

    public User(){

    }
    public User(String fullName,String age,String email,String userLevel){
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.userLevel = userLevel;
    }

    public String getUserLevel(){
        return userLevel;
    }
    public void setUserLevel(){
        this.userLevel = userLevel;
    }
    public String getFullName(){
     return getFullName();
    }

    public void setFullName(){
        this.fullName = fullName;
    }

    public String getAge(){
        return age;
    }

    public void setAge(){
        this.age = age;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }


}
