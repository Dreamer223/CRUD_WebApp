package ru.webapp.dreamer.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.webapp.dreamer.dao.PersonDAO;

@Controller
@RequestMapping("/test-batch")
public class BatchController {
    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    private final PersonDAO personDAO;


//    @GetMapping()
//    public String index() {
//        return "batch/index";
//    }
//
//    @GetMapping("/test")
//    public String test() {
//        personDAO.testBatchUpdate();
//        return "redirect:/people";
//    }
//    @GetMapping("/without")
//    public String without() {
//        personDAO.testMuipleUpdate();
//        return "redirect:/people";
//    }
}
