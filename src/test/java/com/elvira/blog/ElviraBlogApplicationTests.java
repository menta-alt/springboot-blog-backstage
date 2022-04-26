package com.elvira.blog;

import com.elvira.blog.mapper.ArticleMapper;
import com.elvira.blog.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ElviraBlogApplicationTests {
	@Autowired
	private ArticleMapper articleMapper;

	@Test
	void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<Article> ArticleList = articleMapper.selectList(null);
		ArticleList.forEach(System.out::println);
		System.out.println("list:"+ ArticleList);
	}

}
