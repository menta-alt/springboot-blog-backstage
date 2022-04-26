package com.elvira.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//入口文件
@SpringBootApplication
//@MapperScan("com.elvira.blog.mapper")
public class ElviraBlogApplication {

	public static void main(String[] args) {
		System.out.println("springboot项目启动了");
		SpringApplication.run(ElviraBlogApplication.class, args);
	}

}
