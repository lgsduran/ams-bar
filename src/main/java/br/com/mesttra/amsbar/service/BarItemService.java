package br.com.mesttra.amsbar.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mesttra.amsbar.amqp.BarRequestMessage;
import br.com.mesttra.amsbar.amqp.RabbitConfig;
import br.com.mesttra.amsbar.dto.BarStatusDto;
import br.com.mesttra.amsbar.repository.BarItemRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BarItemService {
	
	private BarItemRepository barItemRepository;
	private RabbitTemplate rabbitTemplate;
	
	public BarRequestMessage addBarItem(BarRequestMessage barItem) {
		return this.barItemRepository.save(barItem);		
	}
	
	@Transactional
	public BarRequestMessage changeStatus(String barItemId, BarStatusDto dto) {
		BarRequestMessage db = this.barItemRepository.findById(barItemId).
					orElseThrow(() -> new RuntimeException(
							String.format("Id %s not found.", barItemId)));
		db.setBarStatus(dto.getBarStatus());
		if (dto.getBarStatus().toString().equalsIgnoreCase("done")) {
			rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.BAR_ORDER_KEY, db);
		}
		return this.barItemRepository.save(db);			
	}

}
