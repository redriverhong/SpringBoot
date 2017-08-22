package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void testMySql(){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = jdbcTemplate.queryForList("select * from user");
		System.out.println("the size = "+result.size());
	}
	@RequestMapping("/redis")
	public String testRedis(){
		stringRedisTemplate.opsForValue().set("name", "cyh");
		String name = stringRedisTemplate.opsForValue().get("name");
		System.out.println(name);
		return name;
	}

}
