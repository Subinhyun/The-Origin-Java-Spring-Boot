package dev.hsooovn.jpa;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostDto {
    private int id;

    @NotBlank
    @NotNull(message = "title not null")
    private String title;

    @NotBlank
    @Size(max = 40, message = "size under 40")
    private String content;

    @Size(min = 3, max = 10, message = "size between 3 -10")
    private String writer;

    private int boardId;

    private String userId;

    public PostDto(int i, String title, String content, String writer, int i1) {
    }

    public PostDto(int id, String title, String content, String writer, int boardId, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", boardId=" + boardId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
