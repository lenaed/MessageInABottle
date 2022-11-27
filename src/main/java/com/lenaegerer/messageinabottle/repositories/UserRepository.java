package com.lenaegerer.messageinabottle.repositories;

import com.lenaegerer.messageinabottle.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
