/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */

import java.util.List;

public interface FlipfitGymCenterDAOInterface {
    
    // Create operation
    boolean insert(Object obj);
    
    // Read operation
    Object findById(int id);
    List<Object> findAll();
    
    // Update operation
    boolean update(Object obj);
    
    // Delete operation
    boolean delete(int id);
    
    // Additional methods if needed
    // For example:
    // List<Object> findByCriteria(String criteria);
    
}
