/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories;

import java.util.List;

/**
 *
 * @author Linh
 */
public interface StatsRepository {
    long statsNumberOfPatients();
    List<Object[]> statsRevenueByPeriod(int year, String period);
}
