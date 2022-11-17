package kr.kwangan2.jpatest;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name="BOARD")
@Data
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long seq;
	private String title;
	private String wirter;
	private String content;
	private Date createDate;
	private Long cnt;
	
	public Board() {
		super();
	}
   
}
