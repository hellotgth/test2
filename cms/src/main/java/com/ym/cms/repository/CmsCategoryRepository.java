package com.ym.cms.repository;

import com.ym.cms.pojo.CmsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CmsCategoryRepository extends JpaRepository<CmsCategory,Integer> {

}
