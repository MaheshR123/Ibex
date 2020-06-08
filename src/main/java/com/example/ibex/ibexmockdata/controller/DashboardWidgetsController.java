package com.example.ibex.ibexmockdata.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ibex.ibexmockdata.exception.ResourceNotFoundException;
import com.example.ibex.ibexmockdata.model.DashboardWidgets;
import com.example.ibex.ibexmockdata.model.DashboardWidgetsCustom;
import com.example.ibex.ibexmockdata.repository.DashboardWidgetsRepository;
import com.example.ibex.ibexmockdata.repository.DashboardWidgetsRepositoryOriginal;

@RestController
@RequestMapping("/api/ibex")
public class DashboardWidgetsController {
	
	@Autowired
	private DashboardWidgetsRepository dashboardWidgetsRepository;
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private DashboardWidgetsRepositoryOriginal dashboardWidgetsRepositoryOriginal;

	@GetMapping("/getWidgetsById/{id}")
	public List<DashboardWidgetsCustom> getWidgetsById(@PathVariable (value="id") int id) {
		
		return dashboardWidgetsRepository.findBySearchTerm(id,em);
	}
	
	@PostMapping("/dashboardWidgets")
	public DashboardWidgets createDashboardWidgets(@Valid @RequestBody DashboardWidgets dashboardWidgets) {
		
		dashboardWidgets.setConfigurationsetting(dashboardWidgets.getConfigurationsetting().toString());
		
		DashboardWidgets dashwidgets = dashboardWidgetsRepositoryOriginal.save(dashboardWidgets);
		
		return dashwidgets;
		
	}
	
	@PutMapping("/dashboardWidgets/{id}")
	public ResponseEntity<DashboardWidgets> updateDashboardWidgetById(@PathVariable (value = "id") Long dashboardWidgetsId, @Valid @RequestBody DashboardWidgets dashboardWidgets) 
			throws ResourceNotFoundException{
		
		DashboardWidgets dashboardWidget = dashboardWidgetsRepositoryOriginal.findById(dashboardWidgetsId)
				.orElseThrow(() -> new ResourceNotFoundException("Widgets not found for this id :: " +dashboardWidgetsId));
		
		dashboardWidget.setDashboardid(dashboardWidgets.getDashboardid());
		dashboardWidget.setWidgetid(dashboardWidgets.getWidgetid());
		dashboardWidget.setConfigurationsetting(dashboardWidgets.getConfigurationsetting().toString());
		
		final DashboardWidgets widgetsUpdate = dashboardWidgetsRepositoryOriginal.save(dashboardWidget);
		
		return ResponseEntity.ok(widgetsUpdate);
		
	}
	
	@DeleteMapping("/dashboardWidgets/{id}")
    public Map<String, Boolean> deleteDashboardWidget(@PathVariable(value ="id") Long id) throws ResourceNotFoundException{
		DashboardWidgets dashboardWidget = dashboardWidgetsRepositoryOriginal.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Widgets not found for this id :: " +id));;
		dashboardWidgetsRepositoryOriginal.delete(dashboardWidget);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("deleted", true);
        return map;
		
	}
	
	
}
