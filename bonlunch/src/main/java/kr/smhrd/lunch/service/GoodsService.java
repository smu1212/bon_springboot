package kr.smhrd.lunch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.lunch.dto.GoodsDTO;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import kr.smhrd.lunch.repository.GoodsDetailRepository;
import kr.smhrd.lunch.repository.GoodsRepository;

@Service
public class GoodsService {
	// 특정 컴포넌트 찾지 못한다!
	// 1. 내가 컴포넌트 만들었나?
	// 2. AutoWired -> 작성이 되었는가?\
	// 3. 어노테이션 작성 되었는가?
	
	// GoodsRepository.java에 자동 연결!
	@Autowired
	GoodsRepository goodsRepo;
	
	@Autowired
	GoodsDetailRepository detailRepo;
	
	public List<GoodsDTO> getGoodsList() {
		
		// 1. 데이터 처리
		// 2. repository 호출
		List<Goods> result = goodsRepo.findAll();
		
		// 3. Controller 돌려줄 데이터 처리
		List<GoodsDTO> list = new ArrayList<GoodsDTO>(); 
		
		/* List 형태이므로 for-each 문을 통해서 
		   리스트 내 데이터를 전부 DTO 타입으로 변환! */
		for(Goods g : result) {
			GoodsDTO dto = new GoodsDTO();
			dto.setId(g.getId());
			dto.setName(g.getName());
			dto.setPrice(g.getPrice());
			dto.setIsNew(g.getIsNew());
			dto.setIsBest(g.getIsBest());
			dto.setMain_thumb(g.getMain_thumb());
			list.add(dto);
		}
		
		return list;
		
	}

	public GoodsDTO getGoodsDetail(int id) {
		
		// 1. id 값을 가지고 제품 정보 Goods 가지고 오기!
		Goods goods = goodsRepo.findById(id).orElse(null);
		GoodsDetail detail = detailRepo.findById(id).orElse(null);
		
		// 2. 두 변수의 값이 null인 경우에는 null을 리턴 
		if(goods == null || detail == null) {
			return null;
		}
		
		/* dto.setA(entity.getA());
		   -> Entity(개체) 타입을 DTO(데이터 전송 객체) 타입으로 변환! */
		GoodsDTO dto = new GoodsDTO();
		dto.setId(goods.getId());
		dto.setPrice(goods.getPrice());
		dto.setName(goods.getName());
		dto.setIsNew(goods.getIsNew());
		dto.setIsBest(goods.getIsNew());
		dto.setMain_thumb(goods.getMain_thumb());
		dto.setDetail(detail);
		
		return dto;
	}
	
}
