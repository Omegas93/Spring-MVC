package com.springmvc;
import java.util.*;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;


public class LocationDAO {
    
    HibernateTemplate template;
    public void setTemplate(HibernateTemplate template)
    {
        this.template = template;
        this.template.setCheckWriteOperations(false);
    }
    
    public void saveLocation(loc c)
    {
        template.save(c);
    }
    
    public void updateLocation(loc c)
    {
        template.update(c);
    }
    @Transactional
    public void deleteLocation(loc c)
    {
        template.delete(c);
    }
    
    public loc getById(int id)
    {
        loc c = (loc)template.get(loc.class, id);
        return c;
    }
    
    public List<loc> getLocations()
    {
      List<loc> list =  new ArrayList<loc>();
      list = template.loadAll(loc.class);
      return list;
    }
}
