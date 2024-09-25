/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories;

import com.pthtw.pojo.Schedule;
import java.util.List;

/**
 *
 * @author Linh
 */
public interface ScheduleRepository {
    List<Schedule> getList();
    void addOrUpdate(Schedule s);
    Schedule getScheduleById(int id);
    void deleteSchedule(int id);
    List<Schedule> find(String kw);
}
