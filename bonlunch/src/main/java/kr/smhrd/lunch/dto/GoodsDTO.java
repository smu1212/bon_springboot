package kr.smhrd.lunch.dto;

import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 자료 전송 객체(DTO) 타입 데이터를 담는 공간 
   -> Service.java에서 호출! */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsDTO {
	
		private Integer id;
		private String name;
		private String price;
		private Boolean isNew;
		private Boolean isBest;
		private String main_thumb;
		
		// GoodsDetail 물품의 상세 정보 객체도
		public GoodsDetail detail;
		
		// React에서 이중 객체의 형태로 반호나하기를 바라기 때문에

}
