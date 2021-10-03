package br.com.mesttra.amsbar.amqp;

import static br.com.mesttra.amsbar.amqp.RabbitConfig.ORDER_BAR_QUEUE;
import static br.com.mesttra.amsbar.enums.OrderStatus.PREPARING;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.mesttra.amsbar.service.BarItemService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class FromOrderConsumer {

	private BarItemService barItemService;
	
	@RabbitListener(queues = ORDER_BAR_QUEUE)
    public void consumer(@Payload BarRequestMessage barItem) {
		barItem.setBarStatus(PREPARING);
		barItemService.addBarItem(barItem);  
		
    }

}
