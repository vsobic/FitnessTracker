package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Goal;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Goal save(Goal goal) {

		System.out.println("em.persist(goal);");
		
		//em.getTransaction().begin();
		
		em.persist(goal);
		
		System.out.println("em.flush();");
		em.flush();
		
		//em.getTransaction().commit();
				
		System.out.println("return goal;");
		return goal;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Goal> loadAll() {
		Query query = em.createQuery("Select g from Goal g");
		
		List goals = query.getResultList();
		
		return goals;
	}

}
