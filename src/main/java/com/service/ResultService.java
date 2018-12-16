package com.service;

import com.database.ResultEntity;
import com.google.gson.Gson;
import com.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    //ответ(массив джейсон)

    private String checkPoint(double x, double y, double r) {
        boolean f1 = false, f2 = false, f3 = false;

        if (x * x + y * y <= r * r && x >= 0 && x <= r && y >= 0 && y <= r) f1 = true;
        if (x >= 0 && x <= r && y <= 0 && y >= -r / 2) f2 = true;
        if (1 / 2 * x + r / 2 <= y && x >= -r && x <= 0 && y >= 0 && y <= r / 2) f3 = true;

        if (f1 || f2 || f3) return "hit";

        return "missed";
    }

    public boolean addResult(double x, double y, double r) {
        try {
            ResultEntity result = new ResultEntity();
            result.setX(x);
            result.setY(y);
            result.setR(r);
            result.setAnswer(checkPoint(x, y, r));
            resultRepository.save(result);
        } catch (NullPointerException ex) {
            return false;
        }
        return true;
    }

    public String getJSON() {
        String jsonString = null;
        try {
            List<ResultEntity> resultEntities = resultRepository.findAll();
            Gson gson = new Gson();
            jsonString = gson.toJson(resultEntities);
        } catch (NullPointerException ex) {
            return "aaaaaaaaaaaaaшибка";
        }
        return jsonString;
    }
//x:2 y:5 r:7
}
