package br.com.mesttra.amsbar.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.amsbar.amqp.BarRequestMessage;
import br.com.mesttra.amsbar.dto.BarStatusDto;
import br.com.mesttra.amsbar.service.BarItemService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/bar-orders")
public class BarItemController {
	
	private BarItemService barItemService;
	
	@PatchMapping(path = "/{barItemId}")
	public BarRequestMessage changeOredrStatus(
			@PathVariable String barItemId, 
			@RequestBody BarStatusDto dto) {
		
		return barItemService.changeStatus(barItemId, dto);
		
	}

}
