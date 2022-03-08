package dev.hsooovn.jpa;

import dev.hsooovn.jpa.entity.PostEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private int id;
    @NotBlank
    @NotNull
    private String userId;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    private String name;

    private List<PostEntity> postEntityList = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(int id, String userId, String password, String name, List<PostEntity> postEntityList) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.postEntityList = postEntityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostEntity> getPostEntityList() {
        return postEntityList;
    }

    public void setPostEntityList(List<PostEntity> postEntityList) {
        this.postEntityList = postEntityList;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", postEntityList=" + postEntityList +
                '}';
    }
}
