/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.GymOwner;

/**
 * 
 */
public interface GymOwnerInterface {
	public boolean createGymOwner(GymOwner gymOwner);
	public boolean updateGymOwner(int gymOwnerId);
	public boolean deleteGymOwner(int gymOwnerId) ;
	public void listGymOwner();

}
