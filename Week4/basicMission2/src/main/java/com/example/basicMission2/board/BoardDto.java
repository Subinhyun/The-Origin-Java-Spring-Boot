package com.example.basicMission2.board;

public class BoardDto {
    private String category;

    public BoardDto() {
    }

    public BoardDto(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "category='" + category + '\'' +
                '}';
    }
}
