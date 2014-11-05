package com.squeezymo.mutibo.repository;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionSetRepo extends CrudRepository<QuestionSet, Long>{
	Collection<QuestionSet> findByDomainId(long domainId);
}
