package kr.smhrd.lunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.smhrd.lunch.entity.GoodsDetail;

//개체(Entity) 타입 데이터 중 상세 데이터를 담는 공간

public interface GoodsDetailRepository extends JpaRepository<GoodsDetail, Integer>{
	
}
