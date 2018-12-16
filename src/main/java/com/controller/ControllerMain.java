package com.controller;


/*Цели:
 * 0) форма добавления точек
 * 1) добавить график с предыдущих лаб
 * 3) добавить таблицу
 * 2) обрабатывать json нормально
 * 4) отрисовывать точки на графике
 * 5) Кнопку, по которой аутентифицированный пользователь может закрыть свою сессию
 * и вернуться на стартовую страницу приложения.
 * */


import com.database.UsersEntity;
import com.service.ResultService;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerMain {

    private final ResultService resultService;
    private final UsersService usersService;


    @Autowired
    public ControllerMain(ResultService resultService, UsersService usersService) {
        this.resultService = resultService;
        this.usersService = usersService;
    }




    @GetMapping("/start")
    public String start() {
        return "checkIn";
    }

    @GetMapping("/startRegistration")
    public String startRegistration() {
        return "registration";
    }

    //    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(UsersEntity user, Model model) {

        boolean answer = usersService.addUser(user.getLogin(), user.getPassword());
        if (answer) {
            model.addAttribute("registration", "successful registration");
            return "checkIn";
        }
        model.addAttribute("registration", "This login already exists");
        return "registration";
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUser(UsersEntity user) {
        boolean answer = usersService.checkUser(user.getLogin(), user.getPassword());
        if (answer)
            return "main";
        return "checkIn";

    }


    @GetMapping("/addResult")
    public String addResult() {
        resultService.addResult(1, 1, 1);
        return "ok";
    }

    @GetMapping("/getResults")
    public String getResults(Model model) {
        String results = resultService.getJSON();
        model.addAttribute("results", results);
        return "getResults";
    }
}
