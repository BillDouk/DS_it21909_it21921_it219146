package gr.hua.dit.DistributedSystemsAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer>{

}
