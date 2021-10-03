package br.com.mesttra.amsbar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mesttra.amsbar.amqp.BarRequestMessage;

public interface BarItemRepository extends MongoRepository<BarRequestMessage, String> {

}
