package kr.smhrd.lunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.smhrd.lunch.entity.Goods;

// 개체(Entity) 타입 데이터를 담는 공간

// Integer -> ID 값
public interface GoodsRepository extends JpaRepository<Goods, Integer>{
	
}
