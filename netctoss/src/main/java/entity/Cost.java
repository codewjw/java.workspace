package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cost implements Serializable{
	  private Integer costId;
	  private String name;
	  //基本时长
	  private Long baseDuration;
	  //基本费用
	  private Double baseCost;
	  //单位费用
	  private Double unitCose;
	  //状态(枚举)0-开通，1-暂停
	  private String status;
	  //备注(费用说明)
	  private String descr;
	  //创建时间
	  private Timestamp creaTime;
	  //开通时间
	  private Timestamp startime;
	  //付费类型(枚举)1-包月，2-套餐，3-计时
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
