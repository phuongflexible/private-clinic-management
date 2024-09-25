/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.services;

import java.util.List;

/**
 *
 * @author Linh
 */
public interface StatsService {
    long statsNumberOfPatients();
    List<Object[]> statsRevenueByPeriod(int year, String period);
}
