package org.raghav.springreactmongoapp.Repos;

import org.raghav.springreactmongoapp.Models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Long> {

}
