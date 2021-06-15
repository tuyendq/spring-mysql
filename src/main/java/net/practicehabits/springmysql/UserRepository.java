package net.practicehabits.springmysql;

import org.springframework.data.repository.CrudRepository;

import net.practicehabits.springmysql.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
