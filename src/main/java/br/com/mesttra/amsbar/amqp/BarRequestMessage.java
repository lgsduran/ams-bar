package br.com.mesttra.amsbar.amqp;

import java.util.List;

import br.com.mesttra.amsbar.entity.BarItem;
import br.com.mesttra.amsbar.enums.OrderStatus;
import lombok.Data;

@Data
public class BarRequestMessage {

   List<BarItem> barItems;

    String orderId;
    
    OrderStatus barStatus;

}
