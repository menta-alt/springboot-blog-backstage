package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elvira.blog.mapper.CategoryMapper;
import com.elvira.blog.pojo.Category;
import com.elvira.blog.service.CategoryService;
import com.elvira.blog.vo.CategoryVo;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.CategoryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Result publish(CategoryParams categoryParams) {
        Category category = new Category();
        category.setCategoryName(categoryParams.getCategoryName());
        categoryMapper.insert(category);

        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setId(category.getId().toString());
        categoryVo.setCategoryName(category.getCategoryName());
        categoryVo.setCreateTime(category.getCreateTime());
        return Result.success(categoryVo);
    }

    @Override
    public Result getCategory() {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Category::getCreateTime);
        List<Category> category = categoryMapper.selectList(queryWrapper);
        return Result.success(category);
    }

    @Override
    public Result getCategoryName(Long categoryId) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getId, categoryId);
        List<Category> categoryName = categoryMapper.selectList(queryWrapper);
        return Result.success(categoryName.get(0).getCategoryName());
    }

    @Override
    public Result deleteCategoryById(Long categoryId) {
        categoryMapper.deleteById(categoryId);
        return Result.success(null);
    }
}
