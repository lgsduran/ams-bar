package br.com.mesttra.amsbar.amqp;

import java.util.List;

import br.com.mesttra.amsbar.entity.BarItem;
import br.com.mesttra.amsbar.enums.OrderStatus;
import lombok.Data;

@Data
public class BarRequestMessage {

    private List<BarItem> barItems;

    private String orderId;
    
    private OrderStatus barStatus;

}
