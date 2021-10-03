package br.com.mesttra.amsbar.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan
@NoArgsConstructor
@Data
public class BarItem {

    @Id
    private String id;

    private String name;

    private Integer quantity;

    private String note;
	
}
