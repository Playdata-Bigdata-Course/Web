﻿/*CREATE TABLE recipient (
       recipient_id         VARCHAR2(20) PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       receiveHopeContent   VARCHAR2(50) NULL
); */

package probono.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "recipient")
public class RecipientEntity {
	@Id
	@Column(name="recipient_id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="receiveHopeContent")
	private String receiveContent;
	@OneToMany(mappedBy = "receiveId")
	private List<ProbonoProjectEntity> projects;
	
	public RecipientEntity(String id, String name, String password, String receiveContent) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.receiveContent = receiveContent;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" 4. 제공받는 대상자가 제공받는 서비스 : ");
		builder.append(receiveContent);
		return builder.toString();
	}
}