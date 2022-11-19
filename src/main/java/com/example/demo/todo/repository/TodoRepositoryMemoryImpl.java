package com.example.demo.todo.repository;

import com.example.demo.todo.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 역할 : 할 일 데이터를 메모리에 CRUD 하는 역할
@Repository
public class TodoRepositoryMemoryImpl implements TodoRepository {

    //메모리 저장소

    /**
     * key: 할 일의 식별 id 값
     * value:할 일 집합객체
     * @param todo - 할 일 데이터의 집합
     * @return
     */
    private static final Map<Long, ToDo> toDoMap = new HashMap<>();

    static {

        toDoMap.put(1L, new ToDo(1L, "김철수","저녁밥 만들기", false));
        toDoMap.put(2L, new ToDo(2L, "박영희","저녁밥 만들기", false));
        toDoMap.put(3L, new ToDo(3L, "김민수","저녁밥 만들기", true));
    }



    @Override
    public boolean save(ToDo todo) {
        if (todo == null) return false;

        toDoMap.put(todo.getId(), todo);
        return false;
    }

    @Override
    public List<ToDo> findAll() {
        List<ToDo> toDoList = new ArrayList<>();

        for (Long id : toDoMap.keySet()){
            ToDo toDo = toDoMap.get(id);
            toDoList.add(toDo);
        }
        return toDoList;
    }

    @Override
    public ToDo findOne(long id) {
        return toDoMap.get(id);
    }

    @Override
    public boolean remove(long id) {
        ToDo todo = toDoMap.remove(id);
        return todo != null ;
    }
}
