package org.example;

public class UserBuilder {
    private User user;

    public static UserBuilder builder(){
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.user = new User();
        return userBuilder;
    }
    public UserBuilder firstName(String firstName){
        this.user.setFirstName(firstName);
        return this;
    }
    public UserBuilder lastName(String lastName){
        this.user.setLastName(lastName);
        return this;
    }
    public UserBuilder email(String email){
        this.user.setEmail(email);
        return this;
    }
    public UserBuilder age(int age){
        this.user.setAge(age);
        return this;
    }
    public UserBuilder phoneNumber(String phoneNumber){
        this.user.setPhoneNumber(phoneNumber);
        return this;
    }

    public User build(){
        return this.user;
    }
}
