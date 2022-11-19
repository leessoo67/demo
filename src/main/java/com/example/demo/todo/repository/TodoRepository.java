package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;

import java.util.List;

public interface TodoRepository {


    //할일 생성 기능

    /**
     * 할 일 데이터를 저장소에 저장하는 기능
     * @param todo - 할 일 데이터의 집합
     * @return - 저장 성공시 true, 실패 시 false 반환
     */
    boolean save(ToDo todo);

    //할일 목록조회 기능
    List<ToDo> findAll();

    //할일 개별조회 기능
    ToDo findOne(long id);

    //할일 삭제 기능
    boolean remove(long id);
}
