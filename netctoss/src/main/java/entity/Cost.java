package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cost implements Serializable{
	  private Integer costId;
	  private String name;
	  //����ʱ��
	  private Long baseDuration;
	  //��������
	  private Double baseCost;
	  //��λ����
	  private Double unitCose;
	  //״̬(ö��)0-��ͨ��1-��ͣ
	  private String status;
	  //��ע(����˵��)
	  private String descr;
	  //����ʱ��
	  private Timestamp creaTime;
	  //��ͨʱ��
	  private Timestamp startime;
	  //��������(ö��)1-���£�2-�ײͣ�3-��ʱ
	  private String costType;
	  
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Long baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public Double getUnitCose() {
		return unitCose;
	}
	public void setUnitCose(Double unitCose) {
		this.unitCose = unitCose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Timestamp getCreaTime() {
		return creaTime;
	}
	public void setCreaTime(Timestamp creaTime) {
		this.creaTime = creaTime;
	}
	public Timestamp getStartime() {
		return startime;
	}
	public void setStartime(Timestamp startime) {
		this.startime = startime;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	  
}
