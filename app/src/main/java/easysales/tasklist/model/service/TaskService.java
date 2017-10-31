package easysales.tasklist.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import easysales.tasklist.model.Task;

/**
 * Created by lordp on 16.07.2017.
 */

public class TaskService {
    public static void addSpendHours(Task task, int value){
        TaskService.addSpendMinuts(task, value * 60);
    }

    public static void addSpendMinuts(Task task, int value){
        task.spandMinuts += value;
    }

}
