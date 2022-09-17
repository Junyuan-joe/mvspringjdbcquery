package demo.spring.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.model.*;

@Controller
public class CoffeeController {
	@RequestMapping(value = "/cfjdbc", method = RequestMethod.GET)
	public String spJdbc(ModelMap model) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CoffeeDAO dao = (CoffeeDAO) ctx.getBean("cfdao");
		JdbcTemplate tm = (JdbcTemplate) ctx.getBean("myTemplate");
		dao.setTemplate(tm);
		List<Coffee> list = dao.getAllEmployeesRowMapper();

		model.addAttribute("coffees", list);
		return "coffee";
	}
}
