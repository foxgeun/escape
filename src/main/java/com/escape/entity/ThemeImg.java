package com.escape.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="theme_img")
@Setter
@Getter
public class ThemeImg extends BaseEntity{
	
	
	@Id
	@Column(name="theme_img_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String imgName; //바뀐 이미지 파일명(중복방지를 위해)
	
	private String oriImgName; //원본 이미지 파일명
	
	private int level;
	
	private int horror;
	
	private String name;
	
	private String imgUrl; //이미지 조회 경로
	
	public void updateThemeImg(String oriImgName, String imgName, String imgUrl) {
		System.out.println(oriImgName+" " + imgName+" " + imgUrl + "sdkaksdmaknfakjsnkajngskjangkjansgkjangskjangkjan");
		this.oriImgName = oriImgName;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}
	
	public void updateImg(Theme theme) {
		this.name = theme.getName();
		this.level = theme.getLevel();
		this.horror = theme.getHorror();
		this.imgUrl = theme.getImgUrl();
	}
	
	
	
	
}
