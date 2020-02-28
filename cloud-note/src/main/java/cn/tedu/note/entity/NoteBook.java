package cn.tedu.note.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class NoteBook implements Serializable{
	
	private static final long serialVersionUID = -4390457048538048801L;
	
	private String notebookId; 
    private String userId;
    private String notebookTypeId;
    private String notebookName;
    private String notebookDesc;
    private Timestamp notebookCreateTime;
    
    public NoteBook() {
	}
	
	public NoteBook(String notebookId, String userId, String notebookTypeId, String notebookName, String notebookDesc,
			Timestamp notebookCreateTime) {
		super();
		this.notebookId = notebookId;
		this.userId = userId;
		this.notebookTypeId = notebookTypeId;
		this.notebookName = notebookName;
		this.notebookDesc = notebookDesc;
		this.notebookCreateTime = notebookCreateTime;
	}
    
	public String getNotebookId() {
		return notebookId;
	}
	public void setNotebookId(String notebookId) {
		this.notebookId = notebookId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNotebookTypeId() {
		return notebookTypeId;
	}
	public void setNotebookTypeId(String notebookTypeId) {
		this.notebookTypeId = notebookTypeId;
	}
	public String getNotebookName() {
		return notebookName;
	}
	public void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
	}
	public String getNotebookDesc() {
		return notebookDesc;
	}
	public void setNotebookDesc(String notebookDesc) {
		this.notebookDesc = notebookDesc;
	}
	public Timestamp getNotebookCreateTime() {
		return notebookCreateTime;
	}
	public void setNotebookCreateTime(Timestamp notebookCreateTime) {
		this.notebookCreateTime = notebookCreateTime;
	}

	@Override
	public String toString() {
		return "NoteBook [notebookId=" + notebookId + ", userId=" + userId + ", notebookTypeId=" + notebookTypeId
				+ ", notebookName=" + notebookName + ", notebookDesc=" + notebookDesc + ", notebookCreateTime="
				+ notebookCreateTime + "]";
	}
	
	
    
	
}
