package kr.smhrd.lunch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.lunch.dto.GoodsDTO;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.service.GoodsService;

@CrossOrigin(origins = "http://54.180.250.70:5173")
@RestController
@RequestMapping("/api")
public class GoodsController {
	//http://localhost:8089/api/goods_list
	// GoodsService.java 객체 주입
	@Autowired
	GoodsService goodsService;
	
	// @PathVariable -> 경로에 추가되는 값을 변수에 저장
	@GetMapping("/goods_list/{id}")  // 상세 페이지 볼 때 /id 추가!
	public GoodsDTO getGoodsDetail(@PathVariable("id") int id) {
		// GoodsService.java로 가서 실행! 
		// -> Goods 안의 데이터를 전부 DTO 타입으로 변환시켜 리스트에 담기! 
		GoodsDTO goodsDetail = goodsService.getGoodsDetail(id);
		
		return goodsDetail;
	}
	
	@GetMapping("/goods_list")  // 상품 목록 페이지
	public List<GoodsDTO> getGoodsDTO() {
		 System.out.println("[list 출력 컨트롤러]");
		 
		 // 2Step -> Service -> Repository 
		 // GoodsService.java로 가서 실행! 
		 // -> Goods 안의 데이터를 전부 DTO 타입으로 변환시켜 리스트에 담기!  
		 List<GoodsDTO> list = goodsService.getGoodsList(); 
		 
		 return list;
		 
	 }
}
