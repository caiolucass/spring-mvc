package com.projeto.mvc;

import com.projeto.mvc.controller.InvoiceController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMvcApplicationTests {

	@Autowired
	private InvoiceController invoiceController;

	@Test
	void contextLoads() {
		assertThat(invoiceController).isNotNull();
	}

}
