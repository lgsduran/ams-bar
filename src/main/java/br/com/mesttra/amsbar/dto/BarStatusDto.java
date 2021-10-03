package br.com.mesttra.amsbar.dto;

import br.com.mesttra.amsbar.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BarStatusDto {
	
	private OrderStatus barStatus;
//	
//	public BarItem toEntity() {
//		BarItem barItem = new BarItem();
//		BeanUtils.copyProperties(this, barItem);
//		return barItem;
//	}

}
