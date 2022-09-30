package com.lenaegerer.messageinabottle.service;

import com.lenaegerer.messageinabottle.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
