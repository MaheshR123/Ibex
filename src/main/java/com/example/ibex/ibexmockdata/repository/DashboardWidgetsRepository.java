package com.example.ibex.ibexmockdata.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ibex.ibexmockdata.model.DashboardWidgetsCustom;

@Repository
public class DashboardWidgetsRepository {
	
	/*
	 * @Query(value =
	 * "SELECT t.id, d.name, d.basicsettings, t.configurationsetting FROM Widgets d, DashboardWidgets t WHERE "
	 * + "t.widgetid=d.id and t.dashboardid = :searchTerm", nativeQuery = true)
	 */
	
	  public List<DashboardWidgetsCustom> findBySearchTerm(@Param("searchTerm") Integer searchTerm, EntityManager em) {
		  
		  Session session=em.unwrap(Session.class);
		  String query="SELECT t.id,t.dashboardid, d.name AS widgetname,d.basicsettings, t.widgetid, t.configurationsetting FROM Widgets d, DashboardWidgets t WHERE " + 
		  		" t.widgetid = d.id and t.dashboardid = :searchTerm ";
		  SQLQuery q1=session.createSQLQuery(query);
		  q1.setParameter("searchTerm", searchTerm);
		  q1.setResultTransformer(Transformers.aliasToBean(DashboardWidgetsCustom.class));
		  
		  return q1.list();
	 }
	 
	
	
	
	
}
 