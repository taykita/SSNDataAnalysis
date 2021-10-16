package ru.booknetwork.ssn.data.analysis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatsController {
    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    private final StatsService statsService;

    @GetMapping("/stats")
    public String statsPage() {
        return "stats";
    }

    @GetMapping("/stats/data")
    @ResponseBody
    public StatisticDTO getStatisticDTO() throws Exception {
        return statsService.getStatisticDTO();
    }

}
