package com.bproductive.todo;

import java.time.LocalDate;

/** 
 * @author Sebastiaan van den Berg
 * The Object which stores Task required data. The Object is saved in
 * the repository after the user has sufficiently filled out a form on the 
 * Web App and has been processed by both the Controller and the service.
*/

import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.bproductive.enums.Priorities;
import com.bproductive.enums.Status;

@Entity
public class ToDoModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String creator;
	
	private String toDo;
	
	private Status status = Status.DO; 
	
	private Priorities priority = Priorities.LOW;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate creationDate = LocalDate.now();
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate endDate;	

	public ToDoModel(String creator, String toDo, Priorities priority, String endDate) {
		this.creator = creator;
		this.toDo = toDo;
		this.priority = priority;
		setEndDate(endDate);
	}
	
	public ToDoModel() {
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priorities getPriority() {
		return priority;
	}

	public void setPriority(Priorities priority) {
		this.priority = priority;
	}
	
	public Long getId() {
		return id;
	}	

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}	

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getToDo() {
		return toDo;
	}
	
	public void setToDo(String toDo) {
		this.toDo = toDo;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}	

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((toDo == null) ? 0 : toDo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoModel other = (ToDoModel) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (toDo == null) {
			if (other.toDo != null)
				return false;
		} else if (!toDo.equals(other.toDo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ToDoModel [id=" + id + ", creator=" + creator + ", toDo=" + toDo + ", status=" + status + ", priority="
				+ priority + ", creationDate=" + creationDate + ", endDate=" + endDate + "]";
	}
	
	
}
