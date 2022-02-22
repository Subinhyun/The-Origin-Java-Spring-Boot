package com.example.basicMission2.board;

public class BoardDto {
    private Long board_id;
    private String category;

    public BoardDto() {
    }

    public Long getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Long board_id) {
        this.board_id = board_id;
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
                "board_id=" + board_id +
                ", category='" + category + '\'' +
                '}';
    }
}
