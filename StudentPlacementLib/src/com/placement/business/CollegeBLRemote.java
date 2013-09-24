/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placement.business;

import com.placement.entity.College;
import com.placement.exception.PlacementAppException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author kemele
 */
@Remote
public interface CollegeBLRemote  extends BusinessRemote{
    public boolean save(College college)  throws PlacementAppException;
    public boolean update(College college)  throws PlacementAppException;
    public boolean delete(int id);
    public College get(int id);
    public List<College> getAll();
}
